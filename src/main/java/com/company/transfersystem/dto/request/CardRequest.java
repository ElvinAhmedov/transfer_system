package com.company.transfersystem.dto.request;

import com.company.transfersystem.entity.AccountEntity;
import com.company.transfersystem.enums.CurrencyEnum;

import java.io.Serializable;
import java.math.BigDecimal;

public class CardRequest implements Serializable {
    private BigDecimal balance;
    private String cardNumber;
    private CurrencyEnum currency;
    private Long accountId;

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public CurrencyEnum getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyEnum currency) {
        this.currency = currency;
    }


    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}
