package gr.icap.internal.shortbsparser.utils;

import com.jcraft.jsch.*;
import lombok.extern.slf4j.Slf4j;
import java.util.*;

@Slf4j
public class MyFileUtils {

    public static ChannelSftp openSFTPConnection(Session jschSession) throws JSchException {

        ChannelSftp channelSftp = (ChannelSftp) jschSession.openChannel("sftp");

        channelSftp.connect();

        log.info("ChannelSftp connection is made: " + channelSftp.isConnected());

        return channelSftp;
    }

    public static void closeSFTPConnection(Session jschSession) {
        if ( jschSession!=null && jschSession.isConnected() ) {

            try {

                jschSession.disconnect();

                log.info("ChannelSftp connection is closed: " + !jschSession.isConnected());
            }
            catch (Throwable f) {
                log.error("An error occured while trying to disconnect from the FTP server [" + jschSession.getHost() + "].");
            }
        }
    }

    public static Session setupJsch(String remoteHost, String username, String password) throws JSchException {

        JSch jsch = new JSch();

        Session jschSession = jsch.getSession(username, remoteHost);

        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");

        jschSession.setConfig(config);
        jschSession.setPassword(password);
        jschSession.connect();

        return jschSession;
    }
}