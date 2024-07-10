package com.application.bankmanagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 *  The data related to an account that needs to be stored in DB:
 *    - account number
 *    - client (id)
 *    - balance
 *    - currency
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "bank_accounts")
public class BankAccountData {

    @Id
    @Column(name = "account_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "account_number", unique = true)
    String accNum;

    @ManyToOne
    @JoinColumn(name = "account_type_id")
    @Column(name = "account_type", unique = true)
    AccountType accType;

    @ManyToOne
    @JoinColumn(name = "client_id")
    Client client;

    Long balance;

    String currency;

    @OneToMany(mappedBy = "bankAccountData")
    @JsonBackReference
    List<Card> cards;

    @OneToMany(mappedBy = "account")
    @JsonBackReference
    List<Notification> notifications;

    @OneToMany(mappedBy = "account")
    @JsonBackReference
    List<Deposit> deposits;

    @OneToMany(mappedBy = "account")
    @JsonBackReference
    List<Investment> investments;

    @OneToMany(mappedBy = "debit")
    @JsonBackReference
    List<Transaction> debitTransactions;

    @OneToMany(mappedBy = "credit")
    @JsonBackReference
    List<Transaction> creditTransactions;


    public BankAccountData(String accNum, AccountType accType, Client client, Long balance, String currency) {
        this.accNum = accNum;
        this.accType = accType;
        this.client = client;
        this.balance = balance;
        this.currency = currency;
    }
}
