package com.application.bankmanagement.service.bankaccount;

import com.application.bankmanagement.entity.AccountType;
import com.application.bankmanagement.entity.Client;

/**
 *  What can we do to a bank account?
 */

public interface BankAccount {
    String getAccNum();
    AccountType getAccType();
    Client getAccOwner();
    Long getBalance();
    void setBalance(Long amount);
    void debit(Long amount);
    void credit(Long amount);
    Long addInterest();
    Long settleFee(Long transType);

    default boolean isEmpty() {
        return getBalance() == 0L;
    }

}
