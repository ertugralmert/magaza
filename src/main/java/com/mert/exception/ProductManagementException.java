package com.mert.exception;

import lombok.Getter;

@Getter
public class ProductManagementException extends RuntimeException {
    private ErrorType errorType;

    public ProductManagementException(ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }
}
