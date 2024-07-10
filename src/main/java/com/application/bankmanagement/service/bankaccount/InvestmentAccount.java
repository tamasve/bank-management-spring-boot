package com.application.bankmanagement.service.bankaccount;

import com.application.bankmanagement.entity.BankAccountData;
import com.application.bankmanagement.entity.Investment;

import java.util.List;

public class InvestmentAccount extends AbstractBankAccount {

    public InvestmentAccount(BankAccountData bankAccountData) {
        super(bankAccountData);
    }

    public void newInvestment(Long invId, Long amount) {}

    // return success flag
    public boolean drawMoneyFromInvestment(Long invId, Long amount) {
        return false;
    }

    public List<Investment> showInvestments() {
        return null;
    }

}
