package com.birby.hrms_account_api.app.handler;

import com.birby.hrms_account_api.app.model.exception.*;
import com.birby.hrms_account_api.app.model.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(PrincipalException.class)
    public ResponseEntity<ApiResponse<String>> handlePrincipalException(PrincipalException e){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
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
    @ExceptionHandler(DatabaseUpdateFailureException.class)
    public ResponseEntity<ApiResponse<String>> handleDatabaseUpdateFailureException(DatabaseUpdateFailureException e){
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(
                        ApiResponse.error(e.getMessage())
                );
    }
    @ExceptionHandler(UnAuthorizedException.class)
    public ResponseEntity<ApiResponse<String>> handleUnAuthorizedException(UnAuthorizedException e){
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(
                        ApiResponse.error(e.getMessage())
                );
    }
    @ExceptionHandler(BloomFilterTransferException.class)
    public ResponseEntity<ApiResponse<String>> handleBloomFilterTransferException(BloomFilterTransferException e){
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(
                        ApiResponse.error(e.getMessage())
                );
    }
}

