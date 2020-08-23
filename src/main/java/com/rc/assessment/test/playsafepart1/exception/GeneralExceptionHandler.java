package com.rc.assessment.test.playsafepart1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Error> handleException(Exception ex) {
        MyError myError = new MyError();
        myError.setMessage(ex.getMessage());
        myError.setCode(String.valueOf(HttpStatus.BAD_REQUEST.value()));
        return new ResponseEntity(myError, HttpStatus.BAD_REQUEST);
    }
}
