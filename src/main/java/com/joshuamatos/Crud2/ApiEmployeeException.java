package com.joshuamatos.Crud2;

public class ApiEmployeeException extends RuntimeException {

    public ApiEmployeeException(String message) {
        super(message);
    }

    public ApiEmployeeException(Throwable throwable) {
        super(throwable);
    }
}
