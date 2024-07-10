package com.application.bankmanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

// Investment from an investment bank account, endDate is null until it is closed

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "investments")
public class Investment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "identifier")
    InvestmentProduct product;

    @Column(name = "start_date", nullable = false)
    LocalDate startDate;

    @Column(name = "end_date")
    LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "account_id")
    BankAccountData account;
}
