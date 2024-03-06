package com.marcelocf87.apptransito.api.exceptionhandler;

import com.marcelocf87.apptransito.domain.exception.NegocioException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(NegocioException.class)
    public ResponseEntity<String> capturar (NegocioException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
