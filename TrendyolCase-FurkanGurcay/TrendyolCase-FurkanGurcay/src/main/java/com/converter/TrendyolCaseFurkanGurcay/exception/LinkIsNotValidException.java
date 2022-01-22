package com.converter.TrendyolCaseFurkanGurcay.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class LinkIsNotValidException extends RuntimeException {
    public LinkIsNotValidException(String message) {
        super(message);
    }
}
