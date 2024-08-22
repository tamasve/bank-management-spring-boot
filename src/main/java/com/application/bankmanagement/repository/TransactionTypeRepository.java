package com.application.bankmanagement.repository;

import com.application.bankmanagement.entity.TransactionType;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionTypeRepository extends ListCrudRepository<TransactionType, Long> {
}
