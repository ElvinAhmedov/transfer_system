package com.company.transfersystem.dto.request;

import com.company.transfersystem.enums.AccountStatusEnum;
import com.company.transfersystem.enums.CurrencyEnum;

import java.io.Serializable;
import java.math.BigDecimal;

public class AccountRequest implements Serializable {
    private String accountNumber;
    private BigDecimal balance;
    private CurrencyEnum currency;
    private String iban;
    private AccountStatusEnum status;
    private Long customerId;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public CurrencyEnum getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyEnum currency) {
        this.currency = currency;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public AccountStatusEnum getStatus() {
        return status;
    }

    public void setStatus(AccountStatusEnum status) {
        this.status = status;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public AccountRequest setCustomerId(Long customerId) {
        this.customerId = customerId;
        return this;
    }
}
