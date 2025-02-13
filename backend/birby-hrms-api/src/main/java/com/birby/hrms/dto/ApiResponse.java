package com.birby.hrms.dto;

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
        ApiResponse<D> res = new ApiResponse<>();
        res.success = true;
        res.message=message;
        res.data = data;
        return  res;
    }
    public static ApiResponse<String> error(String message){
        ApiResponse<String> res = new ApiResponse<>();
        res.success = false;
        res.message=message;
        res.data = "";
        return  res;
    }
}
