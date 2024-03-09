package com.marcelocf87.apptransito.api.exceptionhandler;

import com.marcelocf87.apptransito.domain.exception.NegocioException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NegocioException.class)
    public ResponseEntity<String> capturar (NegocioException e) {
        return super.handleMethodArgumentNotValid()ResponseEntity.badRequest().body(e.getMessage());
    }

}
