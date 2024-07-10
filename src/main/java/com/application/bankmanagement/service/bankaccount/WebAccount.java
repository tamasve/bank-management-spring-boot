package com.application.bankmanagement.service.bankaccount;

import com.application.bankmanagement.entity.BankAccountData;
import com.application.bankmanagement.entity.Card;
import com.application.bankmanagement.entity.Notification;
import com.application.bankmanagement.entity.Transaction;

import java.util.List;

public class WebAccount extends AbstractBankAccount {
    public WebAccount(BankAccountData bankAccountData) {
        super(bankAccountData);
    }

    public Card showCardData() {
        return null;
    }

    public List<Notification> showNotifications() {
        return null;
    }

    public boolean approveTransaction(Transaction transaction) {
        return false;
    }

}
