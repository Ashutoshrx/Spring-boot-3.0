package com.test.application.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApplicationServiceException.class)
    public ResponseEntity<String> handleApplicationServiceException(ApplicationServiceException applicationServiceException) {
        return new ResponseEntity<String>("Input field is empty", HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<Object>("Please check the request type you are trying to send",HttpStatus.NOT_ACCEPTABLE);
//        return super.handleHttpRequestMethodNotSupported(ex, headers, status, request);
    }
}
