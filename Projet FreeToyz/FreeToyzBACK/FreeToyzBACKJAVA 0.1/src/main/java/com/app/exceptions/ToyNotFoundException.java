package com.app.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Toy Not Found")
@Getter

public class ToyNotFoundException extends ResponseStatusException {


    public ToyNotFoundException(HttpStatus status){
        super(status);
    }

    public ToyNotFoundException(HttpStatus status, String reason){
        super(status,reason);
    }
    public ToyNotFoundException(HttpStatus status, String reason, Throwable cause){
        super(status, reason, cause);
    }

}