package com.codekata.kata.exception;

/**
 * Technical ErrorCode code format - Three-digit number, older number even.
 * Business ErrorCode code format - Three-digit number, older number even.
 * Created by Benek on 12.04.2017.
 */
public enum ErrorCode {


    //Technical ErrorCode
    ErrorCode_2000("sample technical error message", 2000),
    ErrorCode_2001("directory or file not exist exception", 2001),

    //Business ErrorCode
    ErrorCode_3000("sample business error message", 3000),

    //Spec code
    ErrorCode_0001("under construction", 1),
    ErrorCode_0002("not yest implanted", 2);

    private String message;
    private int id;

    ErrorCode(String message, int id) {
        this.message = message;
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public int getCodeId() {
        return id;
    }
}
