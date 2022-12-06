package com.company.transfersystem.enums;

public enum CustomerTypeEnum {
    JURIDICAL(1),
    PHYSICAL(2);
    private final int value;

    CustomerTypeEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
