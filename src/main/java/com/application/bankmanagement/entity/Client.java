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
@Table(name = "clients")
public class Client {

    @Id
    @Column(name = "client_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "personal_id", nullable = false)
    String personalId;

    @Column(nullable = false)
    String city;

    @Column(name = "postal_code", nullable = false)
    String postCode;

    @Column(nullable = false)
    String place;

//    @OneToOne()     // ?
//    UserData userData;

    @OneToMany(mappedBy = "client")
    @JsonBackReference
    List<BankAccountData> bankAccounts;

}
