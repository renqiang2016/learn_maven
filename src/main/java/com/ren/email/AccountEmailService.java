package com.ren.email;

/**
 * @author qiang.ren
 * @version 1.0
 * @since 2020/8/15 19:47
 */
public interface AccountEmailService {
    /***
     * 发送邮件
     * @param to 收件人
     * @param subject 主题
     * @param htmlText 邮件内容
     * @throws Exception 异常
     */
    void sendEmail(String to, String subject, String htmlText) throws Exception;
}
