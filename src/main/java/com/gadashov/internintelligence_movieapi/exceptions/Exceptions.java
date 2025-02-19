package com.gadashov.internintelligence_movieapi.exceptions;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public enum Exceptions {

    MOVIE_NOT_FOUND("\n---------------| Movie notfound!!! |---------------"),
    INVALID_OPTION("\n---------------| Invalid option!!! |---------------");

    private final String message;
    private final LocalDateTime timeStamp = LocalDateTime.now().withNano(0);

    Exceptions(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message + "\n"
                ;
    }

}
