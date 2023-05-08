package com.test.application.exception;

import java.io.Serial;


public class ApplicationServiceException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;
    private String errorCode;
    private String errorMessage;


    public ApplicationServiceException(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
