package com.ren.captcha;

import java.util.List;

/**
 * @author qiang.ren
 * @version 1.0
 * @since 2020/8/18 20:41
 */
public interface AccountCapychaService {
    String generateCaptchaKey();

    byte[] generateCpatchaImage(String captchaKey);

    boolean validateCaptcha(String captchaKey, String captchaValue);

    List<String> getPreDefinedTexts();

    void setPreDefinedTexts(List<String> preDefinedTexts);
}
