package com.birby.hrms_account_api.app.model.exception;

public class BloomFilterTransferException extends RuntimeException{
    public BloomFilterTransferException(String message){
        super(message);
    }
}
