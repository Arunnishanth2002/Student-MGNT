package com.example.student.exception;

import com.example.student.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public  class GlobalExceptionHandler
{
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiResponse<String>>handle(RuntimeException ex)
    {
        return ResponseEntity.status(404).body(new ApiResponse<>("error",null,ex.getMessage()));
    }
}
