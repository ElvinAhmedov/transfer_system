package com.company.transfersystem.service.functional;

import com.company.transfersystem.entity.TransferEntity;
import com.company.transfersystem.repository.TransferRepository;
import org.springframework.stereotype.Service;

@Service
public class TransferFunctionalService {
    private  final TransferRepository transferRepository;

    public TransferFunctionalService(TransferRepository transferRepository) {
        this.transferRepository = transferRepository;
    }
    public TransferEntity saveTransfer(TransferEntity entity){
        return transferRepository.save(entity);
    }
}
