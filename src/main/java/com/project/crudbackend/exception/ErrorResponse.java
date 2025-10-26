package com.project.crudbackend.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class ErrorResponse {
    private String message;
    private int statusCode;
    private String error;
    private String path;
    private LocalDateTime timestamp;
    Map<String, String> fieldErrors;

    public ErrorResponse(String message, int statusCode, String error, String path, LocalDateTime timestamp) {
        this.message = message;
        this.statusCode = statusCode;
        this.error = error;
        this.path = path;
        this.timestamp = timestamp;
    }

    public ErrorResponse(String message, int statusCode, String error, String path, LocalDateTime timestamp, Map<String, String> fieldErrors) {
        this(message, statusCode, error, path, timestamp);
        this.fieldErrors = fieldErrors;
    }

}
