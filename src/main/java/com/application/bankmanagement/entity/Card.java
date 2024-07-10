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
@Table(name = "cards")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "card_id", nullable = false, unique = true)
    String cardNumber;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    LocalDate expiration;

    @Column(nullable = false)
    Long secretCode;

    @ManyToOne
    @JoinColumn(name = "account_id")
    @Column(name = "bank_account")
    BankAccountData bankAccountData;
}
