package com.company.transfersystem.service.functional;

import com.company.transfersystem.entity.CardEntity;
import com.company.transfersystem.repository.CardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardFunctionalService {
    private final CardRepository cardRepository;

    public CardFunctionalService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }
    public CardEntity saveCard(CardEntity entity){
        return cardRepository.save(entity);
    }
    public CardEntity findByIdAndByActiveOrElseNull(Long id){
        return cardRepository.findByIdAndActive(id,(byte)1).orElse(null);
    }
    public List<CardEntity> findAllByActiveOrElseNull(Byte active){
        return cardRepository.findAllByActive(active).orElse(null);
    }

    public List<CardEntity> findByAccountId(Long id) {
        return cardRepository.findByAccountId(id).orElse(null);
    }
}
