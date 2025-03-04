package com.birby.hrms_api.model.response;

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
    public static <D> ApiResponse<D> ok(String message,D data){
        return (ApiResponse<D>) ApiResponse.builder().success(true).message(message).data(data).build();
    }
    public static <D> ApiResponse<D> error(String message){
        return (ApiResponse<D>) ApiResponse.builder().success(false).message(message).build();
    }
}