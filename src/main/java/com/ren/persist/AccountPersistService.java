package com.ren.persist;

/**
 * @author rq
 * @version 1.0
 * @since 2020/8/17 下午3:48
 */
public interface AccountPersistService {
    /**
     * 增
     * @param account 账号
     * @return 账号
     */
    Account createAccount(Account account);

    /**
     * 读
     * @param id id
     * @return 账号
     */
    Account readAccount(String id);

    /**
     * 更新
     * @param account 账号
     * @return 账号
     */
    Account updateAccount(Account account);

    /**
     * 删
     * @param id id
     */
    void deleteAccount(String id);
}
