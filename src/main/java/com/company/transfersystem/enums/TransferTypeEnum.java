package com.company.transfersystem.enums;

public enum TransferTypeEnum {

    CARD_TO_CARD(0, "card_to_card"),
    ACCOUNT_TO_ACCOUNT(1, "account_to_account");
    private final int value;
    private final String bpmnKey;

    TransferTypeEnum(int value, String bpmnKey) {
        this.value = value;
        this.bpmnKey = bpmnKey;
    }

    public int getValue() {
        return value;
    }

    public String getBpmnKey() {
        return bpmnKey;
    }
}
