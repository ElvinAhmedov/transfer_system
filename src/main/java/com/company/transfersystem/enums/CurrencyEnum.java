package com.company.transfersystem.enums;

public enum CurrencyEnum {
    AZN(1),
    USD(2);

    private final int value;


    CurrencyEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
