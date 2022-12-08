package com.company.transfersystem.service.business;

import com.company.transfersystem.dto.request.CardRequest;
import com.company.transfersystem.dto.response.CardResponse;
import com.company.transfersystem.entity.AccountEntity;
import com.company.transfersystem.entity.CardEntity;
import com.company.transfersystem.enums.AccountStatusEnum;
import com.company.transfersystem.enums.CardStatusEnum;
import com.company.transfersystem.service.functional.AccountFunctionalService;
import com.company.transfersystem.service.functional.CardFunctionalService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CardBusinessService {
    private final CardFunctionalService cardFunctionalService;
    private final AccountFunctionalService accountFunctionalService;

    public CardBusinessService(CardFunctionalService cardFunctionalService, AccountFunctionalService accountFunctionalService) {
        this.cardFunctionalService = cardFunctionalService;
        this.accountFunctionalService = accountFunctionalService;
    }

    public CardResponse saveCard(CardRequest cardRequest) {

        AccountEntity accountEntity = accountFunctionalService.findByIdAndActiveOrElseNull(cardRequest.getAccountId());
        CardEntity cardEntity = convertRequestToCard(cardRequest);
        cardEntity.setAccount(accountEntity);
        cardFunctionalService.saveCard(cardEntity);
        CardResponse response = convertCardToResponse(cardEntity);
        return response;
    }

    public CardResponse getCard(Long id) {
        CardEntity cardEntity = cardFunctionalService.findByIdAndByActiveOrElseNull(id);
        CardResponse response = convertCardToResponse(cardEntity);
        return response;
    }

    public List<CardResponse> getCards() {
        List<CardEntity> cardEntities = cardFunctionalService.findAllByActiveOrElseNull((byte) 1);
        List<CardResponse> responses = cardEntities.stream()
                .map((CardEntity cardEntity) -> (convertCardToResponse(cardEntity)))
                .collect(Collectors.toList());
        return responses;
    }


    public CardResponse updateCard(Long id, CardRequest request) {
        CardEntity cardEntity = cardFunctionalService.findByIdAndByActiveOrElseNull(id);
        cardFunctionalService.saveCard(checkCard(cardEntity, request));
        CardResponse response = convertCardToResponse(cardEntity);

        return response;
    }

    public Integer checkCardId(Long id) {
        if (cardFunctionalService.findByIdAndByActiveOrElseNull(id) == null)
            return 0;
        else
            return 1;
    }

    public Integer checkStatus(Long id) {
        CardEntity cardEntity = cardFunctionalService.findByIdAndByActiveOrElseNull(id);
        if (cardEntity.getStatus() == CardStatusEnum.ACTIVE)
            return 1;
        else
            return 0;
    }

    private CardEntity checkCard(CardEntity cardEntity, CardRequest request) {
        if (StringUtils.hasText(request.getCardNumber()))
            cardEntity.setCardNumber(request.getCardNumber());
        if (request.getBalance() != null)
            cardEntity.setBalance(request.getBalance());
        if (StringUtils.hasText(request.getCurrency().toString()))
            cardEntity.setCurrency(request.getCurrency());
        return cardEntity;
    }

    private CardEntity convertRequestToCard(CardRequest request) {
        CardEntity card = new CardEntity()
                .setCardNumber(request.getCardNumber())
                .setBalance(request.getBalance())
                .setCurrency(request.getCurrency());
        return card;
    }

    private CardResponse convertCardToResponse(CardEntity cardEntity) {
        return new CardResponse()
                .setBalance(cardEntity.getBalance())
                .setCardNumber(cardEntity.getCardNumber())
                .setCurrency(cardEntity.getCurrency())
                .setId(cardEntity.getId())
                .setStatus(cardEntity.getStatus());
    }


}
