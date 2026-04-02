package com.seungmin.cozyDelivery.global.response;

public record ErrorResponse(
        String code,
        String message
) {
}
