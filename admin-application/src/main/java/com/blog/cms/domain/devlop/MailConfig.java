package com.blog.cms.domain.devlop;

public class MailConfig {
    /**
     * SMTP服务器
     */
    private String server;
    /**
     * 端口
     */
    private int port;
    /**
     * 服务器账号
     */
    private String account;
    /**
     * 密码
     */
    private String password;
    /**
     * 发送者邮箱
     */
    private String email;
    /**
     * 邮箱名称
     */
    private String emailName;
    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailName() {
        return emailName;
    }

    public void setEmailName(String emailName) {
        this.emailName = emailName;
    }

}
