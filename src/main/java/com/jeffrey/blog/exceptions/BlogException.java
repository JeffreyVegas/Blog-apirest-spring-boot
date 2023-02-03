package com.jeffrey.blog.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;
@Data
public class BlogException extends RuntimeException {
    private String message;
    private HttpStatus status;

    public BlogException(String message, HttpStatus status) {
        super(message);
        this.message = message;
        this.status = status;
    }

}
