package com.jeffrey.blog.dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class ErrorResponse {
    private LocalDateTime date;
    private String message;
    private String details;

    public ErrorResponse(LocalDateTime date, String message, String details) {
        super();
        this.date = date;
        this.message = message;
        this.details = details;
    }
}
