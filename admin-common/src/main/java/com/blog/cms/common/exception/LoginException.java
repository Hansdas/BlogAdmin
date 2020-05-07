package com.blog.cms.common.exception;

public class LoginException extends Exception {
    /**
     * 构造函数
     */
    public LoginException() {
        super();
    }

    /**
     * 构造函数
     */
    public LoginException(String message) {
        super(message);
    }

    /**
     * 构造函数
     */
    public LoginException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * 构造函数
     */
    public LoginException(Throwable cause) {
        super(cause);
    }
}
