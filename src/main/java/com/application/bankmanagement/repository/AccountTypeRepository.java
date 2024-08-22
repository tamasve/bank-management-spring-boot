package com.application.bankmanagement.repository;

import com.application.bankmanagement.entity.AccountType;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTypeRepository extends ListCrudRepository<AccountType, Long> {

    AccountType findByName(String name);
}
