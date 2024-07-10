package com.application.bankmanagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "transaction_types")
public class TransactionType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transtype_id")
    Long id;

    @Column(name = "transtype_name", nullable = false)
    String name;

    @OneToMany(mappedBy = "transactionType")
    @JsonBackReference
    List<Transaction> transactions;
}
