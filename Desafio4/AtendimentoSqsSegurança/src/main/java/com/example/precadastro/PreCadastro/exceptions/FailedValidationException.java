package com.example.precadastro.PreCadastro.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FailedValidationException extends RuntimeException {

    public FailedValidationException(String message) {
        super(message);
    }
}
