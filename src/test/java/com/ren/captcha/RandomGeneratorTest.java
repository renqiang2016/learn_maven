package com.ren.captcha;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertFalse;

/**
 * @author qiang.ren
 * @version 1.0
 * @since 2020/8/19 0:01
 */
public class RandomGeneratorTest {

    @Test
    public void testGeneratorRandomString() {
        Set<String> randoms = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            String random = RandomGenerator.getRandomString();
            System.out.println(random);
            assertFalse(randoms.contains(random));
            randoms.add(random);
        }

    }
}
