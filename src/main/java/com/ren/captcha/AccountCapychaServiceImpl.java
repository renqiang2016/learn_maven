package com.ren.captcha;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.beans.factory.InitializingBean;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author qiang.ren
 * @version 1.0
 * @since 2020/8/18 23:20
 */
public class AccountCapychaServiceImpl implements AccountCapychaService, InitializingBean {
    private DefaultKaptcha kaptcha;
    private Map<String, String> captchaMap = new HashMap<>();
    private List<String> preDefinedTexts;
    private int textCount = 0;

    @Override
    public String generateCaptchaKey() {
        String key = RandomGenerator.getRandomString();
        String value = getCaptchaText();
        captchaMap.put(key, value);
        return key;
    }

    @Override
    public byte[] generateCpatchaImage(String captchaKey) {
        String text = captchaMap.get(captchaKey);
        if (text == null) {
            System.out.println("Captch Key: " + captchaKey + "not found!");
        }
        BufferedImage image = kaptcha.createImage(text);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "jpg", out);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return out.toByteArray();
    }

    @Override
    public boolean validateCaptcha(String captchaKey, String captchaValue) {
        String text = captchaMap.get(captchaKey);
        if (text == null) {
            System.out.println("Captch Key: " + captchaKey + "not found!");
        }
        assert text != null;
        if (text.equals(captchaValue)) {
            captchaMap.remove(captchaKey);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<String> getPreDefinedTexts() {
        return preDefinedTexts;
    }

    @Override
    public void setPreDefinedTexts(List<String> preDefinedTexts) {
        this.preDefinedTexts = preDefinedTexts;
    }

    private String getCaptchaText() {
        if (preDefinedTexts != null && !preDefinedTexts.isEmpty()) {
            String text = preDefinedTexts.get(textCount);
            textCount = (textCount + 1) % preDefinedTexts.size();
            return text;
        } else {
            return kaptcha.createText();
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        kaptcha = new DefaultKaptcha();
        kaptcha.setConfig(new Config(new Properties()));
    }
}
