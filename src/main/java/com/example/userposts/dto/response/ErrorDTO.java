package com.example.userposts.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class ErrorDTO {
    private String message;
    private LocalDateTime timestamp;

    public static ErrorDTO withCurrentTimestamp(String message) {
        return new ErrorDTO(message, LocalDateTime.now());
    }
}
