package com.javalearn.examquestions.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class QuestionNotFound extends RuntimeException {
    public QuestionNotFound() {
    }

    public QuestionNotFound(String msg) {
        super(msg);
    }
}