package com.ren.persist;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @author rq
 * @version 1.0
 * @since 2020/8/17 下午8:08
 */
public class AccountPersistServiceTest {
    private ApplicationContext ctx = new ClassPathXmlApplicationContext("account_persist.xml");
    private AccountPersistService service = (AccountPersistService) ctx.getBean("accountPersistService");

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
