package com.company.transfersystem.enums;

public enum TransferStatusEnum {
    CREATED(1),
    SUCCESS(2),
    FAIL(3);

    private final int value;

    TransferStatusEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
