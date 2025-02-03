package com.birby.hrms_resource_api.handler;

import com.birby.hrms_resource_api.dto.ApiResponse;
import com.birby.hrms_resource_api.exception.PrincipalException;
import com.birby.hrms_resource_api.exception.RegisterFailureException;
import com.birby.hrms_resource_api.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(PrincipalException.class)
    public ResponseEntity<ApiResponse<String>> handlePrincipalException(PrincipalException e){
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(
                ApiResponse.error(e.getMessage())
        );
    }
    @ExceptionHandler(RegisterFailureException.class)
    public ResponseEntity<ApiResponse<String>> handleRegisterFailureException(RegisterFailureException e){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(
                        ApiResponse.error(e.getMessage())
                );
    }
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<String>> handleResourceNotFoundException(ResourceNotFoundException e){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(
                        ApiResponse.error(e.getMessage())
                );
    }
}

