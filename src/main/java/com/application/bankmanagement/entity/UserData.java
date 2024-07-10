package com.application.bankmanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class UserData {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", unique = true, nullable = false)        // in case of bank clients it is the middle 8 digits of acc.number
    private String username;

    @Column(name = "user_pwd", nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;           // ?

    private String roles;

    private String activationCode;

    private Boolean enabled;

//    @OneToOne
//    Client client;

}
