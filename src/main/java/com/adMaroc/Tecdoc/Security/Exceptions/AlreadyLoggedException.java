package com.adMaroc.Tecdoc.Security.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class AlreadyLoggedException extends RuntimeException {

    public AlreadyLoggedException(String message) {
        super(message);
    }
}