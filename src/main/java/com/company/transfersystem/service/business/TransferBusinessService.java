package com.company.transfersystem.service.business;

import com.company.transfersystem.dto.request.TransferRequest;
import com.company.transfersystem.entity.AccountEntity;
import com.company.transfersystem.entity.CardEntity;
import com.company.transfersystem.entity.TransferEntity;
import com.company.transfersystem.enums.TransferStatusEnum;
import com.company.transfersystem.repository.AccountRepository;
import com.company.transfersystem.service.functional.AccountFunctionalService;
import com.company.transfersystem.service.functional.CardFunctionalService;
import com.company.transfersystem.service.functional.TransferFunctionalService;
import org.springframework.stereotype.Service;

import javax.smartcardio.Card;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransferBusinessService {
    private final TransferFunctionalService transferFunctionalService;
    private final CardFunctionalService cardFunctionalService;
    private final AccountFunctionalService accountFunctionalService;


    public TransferBusinessService(TransferFunctionalService transferFunctionalService, CardFunctionalService cardFunctionalService, AccountRepository accountRepository, AccountFunctionalService accountFunctionalService) {
        this.transferFunctionalService = transferFunctionalService;
        this.cardFunctionalService = cardFunctionalService;
        this.accountFunctionalService = accountFunctionalService;
    }

    public void saveTransfer(TransferRequest transferRequest) {

        transferFunctionalService.saveTransfer(convertRequestToTransfer(transferRequest).setStatus(TransferStatusEnum.CREATED));
    }


    public void doTransfer(TransferRequest request) {
        AccountEntity accountDebitorEntity = accountFunctionalService.findByIban(request.getDebitorIban());
        BigDecimal debitorBalance = accountDebitorEntity.getBalance().subtract(request.getAmount());
        accountDebitorEntity.setBalance(debitorBalance);
        List<CardEntity> debitorCards = getCard(accountDebitorEntity, debitorBalance);
        AccountEntity accountCreditorEntity = accountFunctionalService.findByIban(request.getCreditorIban());
        BigDecimal creditorBalance = accountCreditorEntity.getBalance().add(request.getAmount());
        accountCreditorEntity.setBalance(creditorBalance);
        List<CardEntity> CreditorCards = getCard(accountCreditorEntity, creditorBalance);
        accountFunctionalService.saveAccount(accountDebitorEntity);
        accountFunctionalService.saveAccount(accountCreditorEntity);



    }

    private List<CardEntity> getCard(AccountEntity accountEntity, BigDecimal balance) {
        List<CardEntity> cards = cardFunctionalService.findByAccountId(accountEntity.getId());
        for (CardEntity card : cards) {
            card.setBalance(balance);
            cardFunctionalService.saveCard(card);
        }
        return cards;
    }


    private TransferEntity convertRequestToTransfer(TransferRequest request) {
        TransferEntity entity = new TransferEntity()
                .setAmount(request.getAmount())
                .setDebitorCurrency(request.getDebitorCurrency())
                .setTransferTypeEntity(request.getTransfertype())
                .setCreditorAccountEntity(accountFunctionalService.findByIban(request.getDebitorIban()))
                .setDebitorAccountEntity(accountFunctionalService.findByIban(request.getCreditorIban()))
                .setCreditorCardEntity(cardFunctionalService.findByIdAndByActiveOrElseNull(request.getCreditorCardId()))
                .setDebitorCardEntity(cardFunctionalService.findByIdAndByActiveOrElseNull(request.getDebitorCardId()))
                .setActive((byte) 1)
                .setCreateDate(LocalDateTime.now())
                .setTransferTypeEntity(request.getTransfertype());
        return entity;

    }


}
