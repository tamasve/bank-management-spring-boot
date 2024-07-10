package com.application.bankmanagement.service.bankaccount;

import com.application.bankmanagement.entity.BankAccountData;
import com.application.bankmanagement.entity.Card;
import com.application.bankmanagement.entity.Notification;
import com.application.bankmanagement.entity.Transaction;
import com.application.bankmanagement.service.command.AccountDTO;

import java.util.List;

public class CurrentAccount extends AbstractBankAccount {

    public CurrentAccount(BankAccountData bankAccountData) {
        super(bankAccountData);
    }

    // return success flag
    public boolean newTransaction(AccountDTO accountDTO) {
        return false;
    }

    public Card showCardData() {
        return null;
    }

    public List<Notification> showNotifications() {
        return null;
    }

    // return success flag
    public boolean approveTransaction(Transaction transaction) {
        return false;
    }

}
