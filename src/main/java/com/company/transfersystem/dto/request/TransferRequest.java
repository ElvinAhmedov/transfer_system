package com.company.transfersystem.dto.request;

import com.company.transfersystem.entity.AccountEntity;
import com.company.transfersystem.entity.CardEntity;
import com.company.transfersystem.enums.AccountStatusEnum;
import com.company.transfersystem.enums.CurrencyEnum;
import com.company.transfersystem.enums.TransferTypeEnum;

import javax.persistence.Column;
import java.io.Serializable;
import java.math.BigDecimal;

public class TransferRequest implements Serializable {
    private String creditorIban;
    private BigDecimal amount;
    private Long creditorCardId;
    private CurrencyEnum creditorCurrency;
    private String debitorIban;
    private Long debitorCardId;
    private CurrencyEnum debitorCurrency;
    private TransferTypeEnum transfertype;
    private AccountStatusEnum status;




    public BigDecimal getAmount() {
        return amount;
    }

    public TransferRequest setAmount(BigDecimal Amount) {
        this.amount = Amount;
        return this;
    }

    public Long getCreditorCardId() {
        return creditorCardId;
    }

    public TransferRequest setCreditorCardId(Long creditorCardId) {
        this.creditorCardId = creditorCardId;
        return this;
    }

    public CurrencyEnum getCreditorCurrency() {
        return creditorCurrency;
    }

    public TransferRequest setCreditorCurrency(CurrencyEnum creditorCurrency) {
        this.creditorCurrency = creditorCurrency;
        return this;
    }


    public Long getDebitorCardId() {
        return debitorCardId;
    }

    public TransferRequest setDebitorCardId(Long debitorCardId) {
        this.debitorCardId = debitorCardId;
        return this;
    }

    public CurrencyEnum getDebitorCurrency() {
        return debitorCurrency;
    }

    public TransferRequest setDebitorCurrency(CurrencyEnum debitorCurrency) {
        this.debitorCurrency = debitorCurrency;
        return this;
    }

    public TransferTypeEnum getTransfertype() {
        return transfertype;
    }

    public TransferRequest setTransfertype(TransferTypeEnum transfertype) {
        this.transfertype = transfertype;
        return this;
    }

    public String getCreditorIban() {
        return creditorIban;
    }

    public TransferRequest setCreditorIban(String creditorIban) {
        this.creditorIban = creditorIban;
        return this;
    }

    public String getDebitorIban() {
        return debitorIban;
    }

    public TransferRequest setDebitorIban(String debitorIban) {
        this.debitorIban = debitorIban;
        return this;
    }

    public AccountStatusEnum getStatus() {
        return status;
    }

    public TransferRequest setStatus(AccountStatusEnum status) {
        this.status = status;
        return this;
    }
}
