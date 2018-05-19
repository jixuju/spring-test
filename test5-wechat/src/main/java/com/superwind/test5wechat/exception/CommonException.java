package com.superwind.test5wechat.exception;

import org.springframework.core.NestedRuntimeException;

public class CommonException extends NestedRuntimeException {


    private static final long serialVersionUID = 4486579896184029296L;

    private long errorCode;

    public CommonException(String msg) {
        super(msg);
    }

    public CommonException(String msg, long errorCode) {
        super(msg);
        this.errorCode = errorCode;
    }

    public CommonException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public CommonException(String msg, Throwable cause, long errorCode) {
        super(msg, cause);
        this.errorCode = errorCode;
    }

    public long getErrorCode() {
        return errorCode;
    }
}
