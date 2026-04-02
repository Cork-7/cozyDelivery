package com.seungmin.cozyDelivery.global.exception;

import com.seungmin.cozyDelivery.global.error.ErrorCode;

public class ProductException extends BaseException {

    public ProductException(ErrorCode errorCode) {
        super(errorCode);
    }
}
