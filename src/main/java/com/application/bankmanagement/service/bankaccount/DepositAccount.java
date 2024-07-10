package com.application.bankmanagement.service.bankaccount;

import com.application.bankmanagement.entity.BankAccountData;
import com.application.bankmanagement.entity.Deposit;

import java.util.List;

public class DepositAccount extends AbstractBankAccount {

    public DepositAccount(BankAccountData bankAccountData) {
        super(bankAccountData);
    }

    public Long newDeposit(Long amount) {
        return 0L;
    }

    public void closeDeposit(Long id) {

    }

    public List<Deposit> showDeposits() {
        return null;
    }


}
