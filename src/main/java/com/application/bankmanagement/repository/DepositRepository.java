package com.application.bankmanagement.repository;

import com.application.bankmanagement.entity.Deposit;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepositRepository extends ListCrudRepository<Deposit, Long> {
}
