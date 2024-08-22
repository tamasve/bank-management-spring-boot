package com.application.bankmanagement.repository;

import com.application.bankmanagement.entity.BankAccountData;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountDataRepository extends ListCrudRepository<BankAccountData, Long> {
}
