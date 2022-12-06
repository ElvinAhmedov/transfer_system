package com.company.transfersystem.repository;

import com.company.transfersystem.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CardRepository extends JpaRepository<CardEntity, Long> {

    Optional<List<CardEntity>> findAllByActive(Byte active);

    Optional<CardEntity> findByIdAndActive(Long id, Byte active);

    Optional<List<CardEntity>> findByAccountId(Long id);
}
