package com.seungmin.cozyDelivery.global.exception;

import com.seungmin.cozyDelivery.global.error.ErrorCode;

public class OrderException extends BaseException {

    public OrderException(ErrorCode errorCode) {
        super(errorCode);
    }
}
