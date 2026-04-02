package com.seungmin.cozyDelivery.global.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ProductErrorCode implements ErrorCode{

    NOT_FOUND_PRODUCT(HttpStatus.NOT_FOUND,"해당 상품이 존재하지 않습니다.");

    private final HttpStatus httpStatus;
    private final String defaultMessage;

    @Override
    public String getCode() {
        return name();
    }
}
