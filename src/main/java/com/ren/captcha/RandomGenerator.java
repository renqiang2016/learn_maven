package com.ren.captcha;

import java.util.Random;

/**
 * @author qiang.ren
 * @version 1.0
 * @since 2020/8/18 20:49
 */
public class RandomGenerator {
    private static final String RANGE = "0123456789abcdefghijklmnopqrstuvwxyz";
    public static synchronized String getRandomString() {
        Random random = new Random();
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < 8; i++) {
            result.append(RANGE.charAt(random.nextInt(RANGE.length())));
        }
        return result.toString();
    }

}
