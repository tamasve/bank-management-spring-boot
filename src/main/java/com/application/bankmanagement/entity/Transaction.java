package com.application.bankmanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "transactions")
public class Transaction {

    @Id
    @Column(name = "transaction_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "account_id", insertable = false, updatable = false)
    BankAccountData debit;

    @ManyToOne
    @JoinColumn(name = "account_id", insertable = false, updatable = false)
    BankAccountData credit;

    @Column(nullable = false)
    LocalDate date;

    @Column(nullable = false)
    Long sum;

    @Column(nullable = false)
    String comment;

    @ManyToOne
    @JoinColumn(name = "transtype_id")
    TransactionType transactionType;
}
