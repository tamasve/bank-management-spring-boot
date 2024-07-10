package com.application.bankmanagement.repository;

import com.application.bankmanagement.entity.Card;
import org.springframework.data.repository.ListCrudRepository;

public interface CardRepository extends ListCrudRepository<Card, Long> {
}
