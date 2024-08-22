package com.application.bankmanagement.service.accountfactory;

import com.application.bankmanagement.entity.BankAccountData;
import com.application.bankmanagement.service.bankaccount.BankAccount;

/**
 * Interface for creating accounts -
 * Holding creator for all types of account
 */
public interface AccountFactory {
    BankAccount create(BankAccountData bankAccountData);

}
