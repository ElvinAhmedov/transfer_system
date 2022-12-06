package com.company.transfersystem.repository;

import com.company.transfersystem.entity.CustomerEntity;
import com.company.transfersystem.entity.TransferEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TransferRepository  extends JpaRepository<TransferEntity,Long> {
    Optional<List<TransferEntity>> findAllByActive (Byte active);

    Optional<TransferEntity> findByIdAndActive(Long id, Byte active);
}
