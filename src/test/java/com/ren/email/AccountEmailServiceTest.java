package com.email;

import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.ServerSetup;
import com.ren.email.AccountEmailService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author qiang.ren
 * @version 1.0
 * @since 2020/8/16 0:35
 */
public class AccountEmailServiceTest {
    private GreenMail greenMail;

    @Before
    public void startMailServer() throws Exception {
        greenMail = new GreenMail(ServerSetup.SMTP);
        greenMail.setUser("test@sina.com", "123456");
        greenMail.start();
    }

    @Test
    public void testSendMail() throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("account_email.xml");
        AccountEmailService accountEmailService = (AccountEmailService) ctx.getBean("accountEmailService");
        String subject = "Test Subject";
        String htmlText = "<h3>Test</h3>";
        //accountEmailService.sendEmail("renqiang_2015@163.com", subject, htmlText);

//        greenMail.waitForIncomingEmail(2000, 1);
//        Message[] msgs = greenMail.getReceivedMessages();
//        System.out.println("++++++++++++" + msgs.length);
//        assertEquals(1, msgs.length);
//        assertEquals(subject, msgs[0].getSubject());
//        assertEquals(htmlText, GreenMailUtil.getBody(msgs[0]).trim());
    }

    @After
    public void stopMailServer() throws Exception{
        greenMail.stop();
    }
}
