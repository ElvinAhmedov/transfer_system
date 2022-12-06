package com.company.transfersystem.entity;

import com.company.transfersystem.enums.AccountStatusEnum;
import com.company.transfersystem.enums.CurrencyEnum;
import com.company.transfersystem.enums.TransferStatusEnum;
import com.company.transfersystem.enums.TransferTypeEnum;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name="TRANSFER")
public class TransferEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;
    @Column(name="ACTIVE")
    private Byte active;
    @Column(name="CREATE_DATE")
    private LocalDateTime createDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creditor_account_id", referencedColumnName = "id")
    private AccountEntity creditorAccountEntity;
    @Column(name="AMOUNT")
    private BigDecimal Amount;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creditor_card_id", referencedColumnName = "id")
    private CardEntity creditorCardEntity;
    @Column(name="CREDITOR_CURRENCY")
    private CurrencyEnum creditorCurrency;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "debitor_account_id", referencedColumnName = "id")
    private AccountEntity debitorAccountEntity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "debitor_card_id", referencedColumnName = "id")
    private CardEntity debitorCardEntity;
    @Column(name="DEBITOR_CURRENCY")
    private CurrencyEnum debitorCurrency;
    @Column(name="STATUS")
    private TransferStatusEnum status;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "transfer_type")
    private TransferTypeEnum transferType;

    public Long getId() {
        return id;
    }

    public TransferEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public Byte getActive() {
        return active;
    }

    public TransferEntity setActive(Byte active) {
        this.active = active;
        return this;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public TransferEntity setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
        return this;
    }

    public AccountEntity getCreditorAccountEntity() {
        return creditorAccountEntity;
    }

    public TransferEntity setCreditorAccountEntity(AccountEntity creditorAccountEntity) {
        this.creditorAccountEntity = creditorAccountEntity;
        return this;
    }

    public BigDecimal getAmount() {
        return Amount;
    }

    public TransferEntity setAmount(BigDecimal Amount) {
        this.Amount = Amount;
        return this;
    }

    public CardEntity getCreditorCardEntity() {
        return creditorCardEntity;
    }

    public TransferEntity setCreditorCardEntity(CardEntity creditorCardEntity) {
        this.creditorCardEntity = creditorCardEntity;
        return this;
    }

    public CurrencyEnum getCreditorCurrency() {
        return creditorCurrency;
    }

    public TransferEntity setCreditorCurrency(CurrencyEnum creditorCurrency) {
        this.creditorCurrency = creditorCurrency;
        return this;
    }

    public AccountEntity getDebitorAccountEntity() {
        return debitorAccountEntity;
    }

    public TransferEntity setDebitorAccountEntity(AccountEntity debitorAccountEntity) {
        this.debitorAccountEntity = debitorAccountEntity;
        return this;
    }


    public CardEntity getDebitorCardEntity() {
        return debitorCardEntity;
    }

    public TransferEntity setDebitorCardEntity(CardEntity debitorCardEntity) {
        this.debitorCardEntity = debitorCardEntity;
        return this;
    }

    public CurrencyEnum getDebitorCurrency() {
        return debitorCurrency;
    }

    public TransferEntity setDebitorCurrency(CurrencyEnum debitorCurrency) {
        this.debitorCurrency = debitorCurrency;
        return this;
    }

    public TransferStatusEnum getStatus() {
        return status;
    }

    public TransferEntity setStatus(TransferStatusEnum status) {
        this.status = status;
        return this;
    }

    public TransferTypeEnum getTransferTypeEntity() {
        return transferType;
    }

    public TransferEntity setTransferTypeEntity(TransferTypeEnum transferType) {
        this.transferType = transferType;
        return this;
    }
}
