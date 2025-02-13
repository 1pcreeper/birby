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

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
