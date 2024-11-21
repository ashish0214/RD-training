package com.epam.quizApplication.Dto.response;

import lombok.Builder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
@Builder
public record ErrorResponseDTO(String errorMessage
        , String apiPath
        , HttpStatus errorCode
        , LocalDateTime timeStamp) {
}
