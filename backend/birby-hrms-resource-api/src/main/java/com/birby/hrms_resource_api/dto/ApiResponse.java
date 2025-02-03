package com.birby.hrms_resource_api.dto;

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
    public static <D> ApiResponse<D> ok(boolean success,String message,D data){
        return (ApiResponse<D>) ApiResponse.builder().success(success).message(message).data(data).build();
    }
    public static <D> ApiResponse<D> error(String message){
        return (ApiResponse<D>) ApiResponse.builder().success(false).message(message).data("").build();
    }
}
