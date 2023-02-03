package com.jeffrey.blog.exceptions;

import com.jeffrey.blog.dto.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalHandleException extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
     public ResponseEntity<ErrorResponse> handleAllException(Exception ex, WebRequest request){
         ErrorResponse error =  new ErrorResponse(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
         return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
     }
     @ExceptionHandler(BlogException.class)
     public ResponseEntity<ErrorResponse> handleBlogAppException(BlogException ex, WebRequest request){
        ErrorResponse error = new ErrorResponse(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(error,ex.getStatus());
     }
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String,String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(err->{
            String fieldName = ((FieldError)err).getField();
            String message = err.getDefaultMessage();
            errors.put(fieldName,message);
        });
        return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
    }
}
