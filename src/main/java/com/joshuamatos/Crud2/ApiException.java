package com.joshuamatos.Crud2;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {ApiEmployeeException.class})
    ResponseEntity<Object> handleConflict(RuntimeException exception, WebRequest request) {
        return handleExceptionInternal(exception, "words", new HttpHeaders(), HttpStatus.OK, request);
    }
}