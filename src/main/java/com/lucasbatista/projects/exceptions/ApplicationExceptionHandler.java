package com.lucasbatista.projects.exceptions;

import com.lucasbatista.projects.dto.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationExceptionHandler.class);

    public ApplicationExceptionHandler() {
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException e) {
        LOGGER.info(e.getMessage());
        return new ResponseEntity<>(new ErrorResponse(List.of(e.getMessage())), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<ErrorResponse> handleGenericExceptions(RuntimeException e) {
        LOGGER.info(e.getMessage());
        return new ResponseEntity<>(new ErrorResponse(List.of(e.getMessage())), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
