package com.application.bankmanagement.repository;

import com.application.bankmanagement.entity.AccountType;
import org.springframework.data.repository.ListCrudRepository;

public interface AccountTypeRepository extends ListCrudRepository<AccountType, Long> {

    AccountType findByName(String name);
}
