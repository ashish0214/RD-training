package com.epam.quizApplication.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
