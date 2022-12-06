package com.company.transfersystem.enums;

public enum CardStatusEnum {
    BLOCK(1),
    ACTIVE(2),
    EXPIRE(3);
    private  final int value;

    CardStatusEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
