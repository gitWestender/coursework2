package com.javalearn.examquestions.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FullSet extends RuntimeException{
    public FullSet(String msg) {
        super(msg);
    }
}
