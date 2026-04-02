package com.seungmin.cozyDelivery.global.exception;

import com.seungmin.cozyDelivery.global.error.ErrorCode;
import com.seungmin.cozyDelivery.global.response.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BaseException.class)
    public ResponseEntity<ErrorResponse> handleBaseException(BaseException e) {

        ErrorCode errorCode = e.getErrorCode();

        ErrorResponse response = new ErrorResponse(
                errorCode.getCode(),
                errorCode.getDefaultMessage()
        );
        return ResponseEntity
                .status(errorCode.getHttpStatus())
                .body(response);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {

        ErrorResponse response = new ErrorResponse(
                "INTERNAL_SERVER_ERROR",
                "서버 내부 오류가 발생했습니다"
        );
        return ResponseEntity
                .internalServerError()
                .body(response);
    }

    @ExceptionHandler(HttpSessionRequiredException.class)
    public ResponseEntity<ErrorResponse> handleHttpSessionRequiredException(HttpSessionRequiredException e) {
        ErrorResponse response = new ErrorResponse(
                "BAD_REQUEST",
                "요청 형식이 올바르지 않습니다"
        );
        return ResponseEntity
                .badRequest()
                .body(response);
    }
}
