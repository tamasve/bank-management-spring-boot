package com.application.bankmanagement.repository;

import com.application.bankmanagement.entity.Client;
import org.springframework.data.repository.ListCrudRepository;

public interface ClientRepository extends ListCrudRepository<Client, Long> {
}
