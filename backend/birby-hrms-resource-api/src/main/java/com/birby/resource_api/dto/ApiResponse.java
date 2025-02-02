package com.birby.resource_api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
    private boolean success;
    private String message;
    private T data;
    public static <T> ApiResponse<T> ok(boolean success,String message,T data){
        return (ApiResponse<T>) ApiResponse.builder().success(success).message(message).data(data).build();
    }
}
