package com.example.userposts.controller;

import com.example.userposts.dto.response.ErrorDTO;
import com.example.userposts.exception.AppException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(AppException.class)
    public ResponseEntity<? extends ErrorDTO> handleAppException(AppException e) {
        return ResponseEntity
                .status(e.getHttpStatus())
                .body(ErrorDTO.withCurrentTimestamp(e.getMessage()));
    }
}
