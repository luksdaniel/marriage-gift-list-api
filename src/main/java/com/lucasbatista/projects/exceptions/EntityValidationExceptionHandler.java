package com.lucasbatista.projects.exceptions;

import com.lucasbatista.projects.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class EntityValidationExceptionHandler {
    public EntityValidationExceptionHandler() {
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException e) {
        List<String> messages = new ArrayList<>();
        e.getBindingResult().getAllErrors().forEach((error) -> {
            messages.add(error.getDefaultMessage());
        });
        return new ResponseEntity<>(new ErrorResponse(messages), HttpStatus.BAD_REQUEST);
    }
}