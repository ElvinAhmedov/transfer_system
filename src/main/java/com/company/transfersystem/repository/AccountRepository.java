package com.company.transfersystem.repository;

import com.company.transfersystem.entity.AccountEntity;
import com.company.transfersystem.enums.AccountStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
    Optional<List<AccountEntity>> findAllByActive(Byte active);

    Optional<AccountEntity> findByIdAndActive(Long id, Byte active);

    Optional<AccountEntity> findByIban(String iban);

    Optional<AccountEntity> findByStatus(AccountStatusEnum statusEnum);
}
