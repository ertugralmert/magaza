package com.mert.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorType {
    CONFLICT_ERROR(1001, "Conflict Error", HttpStatus.CONFLICT),
    BAD_REQUEST_ERROR(1002, "Bad Request", HttpStatus.BAD_REQUEST),
    DATA_NOT_FOUND(1003, "Data Not Found", HttpStatus.NOT_FOUND),
    INTERNAL_SERVER_ERROR(1004, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);

    private final int code;
    private final String message;
    private final HttpStatus httpStatus;
}
