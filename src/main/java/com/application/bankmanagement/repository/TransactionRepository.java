package com.application.bankmanagement.repository;

import com.application.bankmanagement.entity.Transaction;
import org.springframework.data.repository.ListCrudRepository;

public interface TransactionRepository extends ListCrudRepository<Transaction, Long> {
}
