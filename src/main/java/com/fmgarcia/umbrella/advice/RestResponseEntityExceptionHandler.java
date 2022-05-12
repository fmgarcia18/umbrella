package com.fmgarcia.umbrella.advice;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleEntityNotFoundException(EntityNotFoundException ex, WebRequest request){
        ExceptionResponse response = ExceptionResponse.builder()
                .details("Any Details you would want to add")
                .message(ex.getMessage())
                .statusCode(HttpStatus.NOT_FOUND.value())
                .errorCode(HttpStatus.NOT_FOUND.name())
                .build();

        return new ResponseEntity<ExceptionResponse>(response, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
}
