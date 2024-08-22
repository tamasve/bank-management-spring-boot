package com.application.bankmanagement.repository;

import com.application.bankmanagement.entity.Client;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends ListCrudRepository<Client, Long> {
}
