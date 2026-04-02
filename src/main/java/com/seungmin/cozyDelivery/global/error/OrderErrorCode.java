package com.seungmin.cozyDelivery.global.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum OrderErrorCode implements ErrorCode {

    NOT_FOUND_ORDER(HttpStatus.NOT_FOUND, "해당 주문이 존재하지 않습니다."),
    PURCHASE_NOT_AVAILABLE(HttpStatus.BAD_REQUEST,"현재 구매가 가능한 상태가 아닙니다.");

    private final HttpStatus httpStatus;
    private final String defaultMessage;

    @Override
    public String getCode() {
        return name();
    }
}
