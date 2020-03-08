package com.blog.cms.common.exception;

/**
 * 运行异常
 */
public class ServiceException extends Exception {
    /**
     * 构造函数
     */
    public ServiceException() {
        super();
    }

    /**
     * 构造函数
     */
    public ServiceException(String message) {
        super(message);
    }

    /**
     * 构造函数
     */
    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * 构造函数
     */
    public ServiceException(Throwable cause) {
        super(cause);
    }
}
