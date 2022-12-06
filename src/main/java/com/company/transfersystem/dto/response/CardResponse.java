package com.company.transfersystem.dto.response;

import com.company.transfersystem.enums.CardStatusEnum;
import com.company.transfersystem.enums.CurrencyEnum;

import java.io.Serializable;
import java.math.BigDecimal;

public class CardResponse implements Serializable {
    private Long id;
    private BigDecimal balance;
    private String cardNumber;
    private CurrencyEnum currency;
    private CardStatusEnum status;

    public CardResponse() {
    }

    public CardResponse(Long id, BigDecimal balance, String cardNumber, CurrencyEnum currency, CardStatusEnum status) {
        this.id = id;
        this.balance = balance;
        this.cardNumber = cardNumber;
        this.currency = currency;
        this.status = status;

    }

    public Long getId() {
        return id;
    }

    public CardResponse setId(Long id) {
        this.id = id;
        return this;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public CardResponse setBalance(BigDecimal balance) {
        this.balance = balance;
        return this;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public CardResponse setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    public CurrencyEnum getCurrency() {
        return currency;
    }

    public CardResponse setCurrency(CurrencyEnum currency) {
        this.currency = currency;
        return this;
    }

    public CardStatusEnum getStatus() {
        return status;
    }

    public CardResponse setStatus(CardStatusEnum status) {
        this.status = status;
        return this;
    }
}
