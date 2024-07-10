package com.application.bankmanagement.repository;

import com.application.bankmanagement.entity.UserData;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDataRepository extends ListCrudRepository<UserData, Long> {

    UserData findByUsername(String username);

    UserData findByEmail(String email);

    UserData findByActivationCode(String activationCode);
}
