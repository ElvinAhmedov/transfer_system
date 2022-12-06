package com.company.transfersystem.entity;

import com.company.transfersystem.enums.CardStatusEnum;
import com.company.transfersystem.enums.CurrencyEnum;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name="CARD")
public class CardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;
    @Column(name="ACTIVE")
    private Byte active;
    @Column(name="BALANCE")
    private BigDecimal balance;
    @Column(name="CREATE_DATE")
    private LocalDateTime createDate;
    @Column(name="CARD_NUMBER")
    private String cardNumber;
    @Column(name="CURRENCY")
    private CurrencyEnum currency;
    @Column(name="EXPIRE_DATE")
    private LocalDateTime expireDate;
    @Column(name="STATUS")
    private CardStatusEnum status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id") //, referencedColumnName = "ID")
    private AccountEntity account;

    public Long getId() {
        return id;
    }

    public CardEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public Byte getActive() {
        return active;
    }

    public CardEntity setActive(Byte active) {
        this.active = active;
        return this;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public CardEntity setBalance(BigDecimal balance) {
        this.balance = balance;
        return this;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public CardEntity setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
        return this;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public CardEntity setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    public CurrencyEnum getCurrency() {
        return currency;
    }

    public CardEntity setCurrency(CurrencyEnum currency) {
        this.currency = currency;
        return this;
    }

    public LocalDateTime getExpireDate() {
        return expireDate;
    }

    public CardEntity setExpireDate(LocalDateTime expireDate) {
        this.expireDate = expireDate;
        return this;
    }

    public CardStatusEnum getStatus() {
        return status;
    }

    public CardEntity setStatus(CardStatusEnum status) {
        this.status = status;
        return this;
    }

    public AccountEntity getAccount() {
        return account;
    }

    public CardEntity setAccount(AccountEntity account) {
        this.account = account;
        return this;
    }
}
