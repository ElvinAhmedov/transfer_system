package com.company.transfersystem.service.functional;

import com.company.transfersystem.entity.AccountEntity;
import com.company.transfersystem.enums.AccountStatusEnum;
import com.company.transfersystem.enums.ErrorEnum;
import com.company.transfersystem.exception.BaseException;
import com.company.transfersystem.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountFunctionalService {
    private final AccountRepository accountRepository;

    public AccountFunctionalService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public AccountEntity saveAccount(AccountEntity entity) {
        return accountRepository.save(entity);
    }

    public AccountEntity findByIdAndActiveOrElseThrow(Long id) {
        return accountRepository.findByIdAndActive(id, (byte) 1)
                .orElseThrow(() -> BaseException.of(ErrorEnum.ACCOUNT_NOT_FOUND));
    }

    public AccountEntity findByIdAndActiveOrElseNull(Long id) {
        return accountRepository.findByIdAndActive(id, (byte) 1)
                .orElse(null);
    }

    public List<AccountEntity> findAllByActiveOrElseNull(Byte active) {
        return accountRepository.findAllByActive(active).orElse(null);
    }

    public AccountEntity findByIban(String iban) {
        return accountRepository.findByIban(iban).orElse(null);
    }

    public AccountEntity findByStatus(AccountStatusEnum statusEnum) {
        return accountRepository.findByStatus(statusEnum).orElse(null);
    }
}
