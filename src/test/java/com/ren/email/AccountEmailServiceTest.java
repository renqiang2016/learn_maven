package com.ren.email;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author qiang.ren
 * @version 1.0
 * @since 2020/8/16 0:35
 */
public class AccountEmailServiceTest {

    @Test
    public void testSendMail() throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("account_email.xml");
        AccountEmailService accountEmailService = (AccountEmailService) ctx.getBean("accountEmailService");
        String subject = "Test Subject";
        String htmlText = "<h3>Test</h3>";
        //accountEmailService.sendEmail("renqiang_2015@163.com", subject, htmlText);
    }
}
