package com.ren.captcha;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author qiang.ren
 * @version 1.0
 * @since 2020/8/19 0:02
 */
public class AccountCapychaServiceTest {
    private AccountCapychaService service;

    @Before
    public void prepare() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("account_captcha.xml");
        service = (AccountCapychaService) ctx.getBean("accountCaptchaService");
    }

    @Test
    public void testGenerateCaptcha() throws IOException {
        String captchaKey = service.generateCaptchaKey();
        assertNotNull(captchaKey);

        byte[] captchaImage = service.generateCpatchaImage(captchaKey);
        assertTrue(captchaImage.length > 0);

        File image = new File("target/" + captchaKey + ".jpg");
        OutputStream output = new FileOutputStream(image);
        output.write(captchaImage);
        output.close();
        assertTrue(image.exists() && image.length() > 0);
    }

    @Test
    public void testValidateCaptchaCorrect() {
        List<String> preDefinedTexts = new ArrayList<>();
        preDefinedTexts.add("123456");
        preDefinedTexts.add("abcde");
        service.setPreDefinedTexts(preDefinedTexts);

        String captchakey = service.generateCaptchaKey();
        service.generateCpatchaImage(captchakey);
        assertTrue(service.validateCaptcha(captchakey, "123456"));

        captchakey = service.generateCaptchaKey();
        service.generateCpatchaImage(captchakey);
        assertTrue(service.validateCaptcha(captchakey, "abcde"));
    }

    @Test
    public void testValidateCaptchaIncorrect() {
        List<String> preDefinedTexts = new ArrayList<>();
        preDefinedTexts.add("123456");
        service.setPreDefinedTexts(preDefinedTexts);

        String captchakey = service.generateCaptchaKey();
        service.generateCpatchaImage(captchakey);
        assertFalse(service.validateCaptcha(captchakey, "654321"));
    }
}
