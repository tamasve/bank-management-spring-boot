package com.application.bankmanagement.repository;

import com.application.bankmanagement.entity.Investment;
import org.springframework.data.repository.ListCrudRepository;

public interface InvestmentRepository extends ListCrudRepository<Investment, Long> {
}
