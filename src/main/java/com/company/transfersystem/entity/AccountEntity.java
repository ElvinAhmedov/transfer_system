package com.company.transfersystem.entity;

import com.company.transfersystem.enums.AccountStatusEnum;
import com.company.transfersystem.enums.CurrencyEnum;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name="ACCOUNT")
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;

    @Column(name="ACCOUNT_NUMBER")
    private String accountNumber;

    @Column(name="ACTIVE")
    private Byte active;

    @Column(name="BALANCE")
    private BigDecimal balance;
    @Column(name="CREATE_DATE")
    private LocalDateTime createDate;
    @Column(name="CURRENCY")
    private CurrencyEnum currency;
    @Column(name="IBAN",unique = true)
    private String iban;
    @Column(name="STATUS")
//    @Enumerated(EnumType.ORDINAL)
    private AccountStatusEnum status;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private CustomerEntity customerEntity;

    public Long getId() {
        return id;
    }

    public AccountEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public AccountEntity setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    public Byte getActive() {
        return active;
    }

    public AccountEntity setActive(Byte active) {
        this.active = active;
        return this;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public AccountEntity setBalance(BigDecimal balance) {
        this.balance = balance;
        return this;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public AccountEntity setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
        return this;
    }

    public CurrencyEnum getCurrency() {
        return currency;
    }

    public AccountEntity setCurrency(CurrencyEnum currency) {
        this.currency = currency;
        return this;
    }

    public String getIban() {
        return iban;
    }

    public AccountEntity setIban(String iban) {
        this.iban = iban;
        return this;
    }

    public AccountStatusEnum getStatus() {
        return status;
    }

    public AccountEntity setStatus(AccountStatusEnum status) {
        this.status = status;
        return this;
    }

    public CustomerEntity getCustomerEntity() {
        return customerEntity;
    }

    public AccountEntity setCustomerEntity(CustomerEntity customerEntity) {
        this.customerEntity = customerEntity;
        return this;
    }
}
