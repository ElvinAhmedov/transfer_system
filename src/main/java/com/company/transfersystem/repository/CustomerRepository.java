package com.company.transfersystem.repository;

import com.company.transfersystem.entity.CardEntity;
import com.company.transfersystem.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
    Optional<List<CustomerEntity>> findAllByActive(Byte active);

    Optional<CustomerEntity> findByIdAndActive(Long id, Byte active);
}
