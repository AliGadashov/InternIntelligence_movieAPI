package com.gadashov.internintelligence_movieapi.exceptions;

public class GeneralExceptions extends RuntimeException {

    public GeneralExceptions(Exceptions exception) {
        super(exception.toString());
    }

}
