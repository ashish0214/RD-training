package com.epam.quizApplication.handler;

import com.epam.quizApplication.Dto.response.ErrorResponseDTO;
import com.epam.quizApplication.exception.ResourceAlreadyExistException;
import com.epam.quizApplication.exception.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    //custum Exception
    @ExceptionHandler(ResourceAlreadyExistException.class)
    public ResponseEntity<ErrorResponseDTO> QuestionExceptionHandler(ResourceAlreadyExistException questionException, WebRequest request) {
        ErrorResponseDTO responseDTO = ErrorResponseDTO.builder().errorMessage(questionException.getMessage())
                .errorCode(HttpStatus.CONFLICT)
                .timeStamp(LocalDateTime.now())
                .apiPath(request.getDescription(false))
                .build();
        return new ResponseEntity<>(responseDTO, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> quizExceptionHandler(ResourceNotFoundException quizException, WebRequest request) {
        ErrorResponseDTO responseDTO = ErrorResponseDTO.builder()
                .timeStamp(LocalDateTime.now())
                .errorMessage(quizException.getMessage())
                .apiPath(request.getDescription(false))
                .errorCode(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<>(responseDTO, HttpStatus.NOT_FOUND);


    }


    //jakarta valiadation Exception handling
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//
//    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
//        StringBuilder errors = new StringBuilder();
//
//        ex.getBindingResult().getAllErrors().forEach((error) -> {
//            String errorMessage = error.getDefaultMessage();
//            errors.append(errorMessage).append("\n");
//        });
//        return new ResponseEntity<>(errors.toString(), HttpStatus.BAD_REQUEST);
//    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String, String> validationErrorMap = new HashMap<>();
        List<ObjectError> validationErrorList = ex.getBindingResult().getAllErrors();

        validationErrorList.forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String validationMsg = error.getDefaultMessage();
            validationErrorMap.put(fieldName, validationMsg);
        });
        return new ResponseEntity<>(validationErrorMap, HttpStatus.BAD_REQUEST);
    }

}
