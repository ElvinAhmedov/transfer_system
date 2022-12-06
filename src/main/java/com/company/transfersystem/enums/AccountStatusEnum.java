package com.company.transfersystem.enums;

public enum AccountStatusEnum {
    BLOCK(0),
    ACTIVE(1);
    private final int value;

    AccountStatusEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
