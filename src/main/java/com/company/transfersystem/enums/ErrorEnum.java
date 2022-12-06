package com.company.transfersystem.enums;

public enum ErrorEnum {
    CUSTOMER_NOT_FOUND("Customer not found", 404),
    ACCOUNT_NOT_FOUND("Account not found",404),
    CARD_NOT_FOUND("Card not found",404 ),
    INVALID_REQUEST("Invalid request",400);

    private final String message;
    private final int code;


    ErrorEnum(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }
}
