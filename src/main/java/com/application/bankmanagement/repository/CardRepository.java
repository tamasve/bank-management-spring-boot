package com.application.bankmanagement.repository;

import com.application.bankmanagement.entity.Card;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends ListCrudRepository<Card, Long> {
}
