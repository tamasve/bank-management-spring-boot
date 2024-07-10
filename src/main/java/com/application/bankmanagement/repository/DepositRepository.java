package com.application.bankmanagement.repository;

import com.application.bankmanagement.entity.Deposit;
import org.springframework.data.repository.ListCrudRepository;

public interface DepositRepository extends ListCrudRepository<Deposit, Long> {
}
