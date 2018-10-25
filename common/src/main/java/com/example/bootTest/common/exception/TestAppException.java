package com.example.bootTest.common.exception;

import lombok.Getter;

@Getter
public class TestAppException extends RuntimeException {

    private static final String INTERNAL_ERR_CODE = ErrorCode.INTERNAL_ERROR.getCode();
    private final String errorCode;

    public TestAppException(String message) {
        this(INTERNAL_ERR_CODE, message);
    }

    public TestAppException(ErrorCode err) {
        this(err.getCode(), err.getDesc());
    }

    public TestAppException(String errorCode, String message) {
        this(errorCode, message, null);
    }

    public TestAppException(String errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }
}
