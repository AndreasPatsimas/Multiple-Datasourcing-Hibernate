package gr.icap.internal.shortbsparser;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import gr.icap.internal.shortbsparser.schedulers.ShortBsScheduler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource(properties = {"spring.application.name=ShortBsTest",
        "spring.jmx.default-domain=ShortBsTest"})
public class ShortBsTest extends BasicWiremockTest {

    @Autowired
    private ShortBsScheduler shortBsScheduler;

    //@Ignore
    @Test
    public void process() throws JSchException, SftpException {

        shortBsScheduler.process();

    }
}
