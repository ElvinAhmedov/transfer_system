package com.company.transfersystem.dto.response;

import com.company.transfersystem.enums.AccountStatusEnum;
import com.company.transfersystem.enums.CurrencyEnum;

import java.io.Serializable;
import java.math.BigDecimal;

public class AccountResponse implements Serializable {
    private Long id;
    private String iban;
    private String accountNumber;
    private BigDecimal balance;
    private CurrencyEnum currency;
    private AccountStatusEnum status;

    public AccountResponse(Long id, String iban, String accountNumber, BigDecimal balance, CurrencyEnum currency, AccountStatusEnum status) {
        this.id = id;
        this.iban = iban;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.currency = currency;
        this.status = status;
    }

    public AccountResponse() {
    }

    public Long getId() {
        return id;
    }

    public AccountResponse setId(Long id) {
        this.id = id;
        return this;
    }

    public String getIban() {
        return iban;
    }

    public AccountResponse setIban(String iban) {
        this.iban = iban;
        return this;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public AccountResponse setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public AccountResponse setBalance(BigDecimal balance) {
        this.balance = balance;
        return this;
    }

    public CurrencyEnum getCurrency() {
        return currency;
    }

    public AccountResponse setCurrency(CurrencyEnum currency) {
        this.currency = currency;
        return this;
    }

    public AccountStatusEnum getStatus() {
        return status;
    }

    public AccountResponse setStatus(AccountStatusEnum status) {
        this.status = status;
        return this;
    }

}
