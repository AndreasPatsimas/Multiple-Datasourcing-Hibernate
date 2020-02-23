package gr.icap.internal.shortbsparser.schedulers;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
import gr.icap.internal.shortbsparser.convert.BalanceSheetXmlToBalanceSheetDtoConverter;
import gr.icap.internal.shortbsparser.services.ProcessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.*;

import java.io.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static gr.icap.internal.shortbsparser.utils.MyFileUtils.*;

@EnableScheduling
@Component
@Slf4j
@PropertySource({ "classpath:application.properties" })
public class ShortBsScheduler {

    @Value("${localPath}")
    private String localPath;

    @Value("${remotePath}")
    private String remotePath;

    @Value("${downloadPath}")
    private String downloadPath;

    @Value("${remoteHost}")
    private String remoteHost;

    @Value("${remote.username}")
    private String username;

    @Value("${password}")
    private String password;

    @Value("${remote}")
    private boolean isRemoted;

    @Autowired
    ProcessService processService;

    @Scheduled(cron = "0 23 14 * * ?")
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void process() throws SftpException, JSchException {

        if(isRemoted)
            remoteProcess();
        else
            localProcess(localPath);
    }

    private void remoteProcess() throws JSchException, SftpException {

        Session session = setupJsch(remoteHost, username, password);

        ChannelSftp channelSftp = openSFTPConnection(session);

        Collection<ChannelSftp.LsEntry> files = channelSftp.ls(remotePath);

        files.forEach(file -> {
            if(!(file.getFilename().equals(".") || file.getFilename().equals(".."))){

                try {

                    channelSftp.cd(remotePath);

                    channelSftp.get(file.getFilename(), downloadPath);

                    System.out.println("Transferred file: " + file.getFilename());

                } catch (SftpException e) {
                    e.printStackTrace();
                }
            }
        });

        closeSFTPConnection(session);

        localProcess(downloadPath);

        cleanDownloadPath();
    }

    private void localProcess(String path) {


        List<File> files = Arrays.asList(new File(path).listFiles());

        files.forEach(file -> {

            try {

//                String xml = Files.lines(Paths.get(file.getAbsolutePath())).collect(Collectors.joining("\n"));
//
//                System.out.println(xml);
                if(file.getName().equals("0000023811710.xml"))
                    processService.process(BalanceSheetXmlToBalanceSheetDtoConverter.convert(file));

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void cleanDownloadPath(){

        List<File> files = Arrays.asList(new File(downloadPath).listFiles());

        files.forEach(file -> file.delete());

        log.info("Path: " + downloadPath + " cleaned");
    }
}
