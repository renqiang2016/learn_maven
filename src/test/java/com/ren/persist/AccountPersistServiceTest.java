package com.ren.persist;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author rq
 * @version 1.0
 * @since 2020/8/17 下午8:08
 */
public class AccountPersistServiceTest {
    private AccountPersistService service;

    @Test
    public void testReadAccount() {
        Account account = service.readAccount("qiang");
        assertNotNull(account);
        assertEquals("qiang", account.getId());
        assertEquals("ren qiang", account.getName());
        assertEquals("test@ren.com", account.getEmail());
        assertEquals("123456", account.getPassword());
        assertFalse(account.isActivated());
        System.out.println(account.toString());
    }
}
