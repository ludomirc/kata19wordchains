package com.codekata.kata.exception;

/**
 * Created by Benek on 13.04.2017.
 */
public class BusinessException extends AppException {

    public BusinessException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public BusinessException(ErrorCode errorCode) {
        super(errorCode);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(Throwable cause, ErrorCode errorCode, String message) {
        super(cause, errorCode, message);
    }
}
