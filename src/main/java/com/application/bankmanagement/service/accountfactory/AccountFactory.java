package com.application.bankmanagement.service.accountfactory;

import com.application.bankmanagement.entity.BankAccountData;
import com.application.bankmanagement.service.bankaccount.BankAccount;


public interface AccountFactory {
    BankAccount create(BankAccountData bankAccountData);

}
