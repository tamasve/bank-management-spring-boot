package com.application.bankmanagement.service.bankaccount;

import com.application.bankmanagement.entity.AccountType;
import com.application.bankmanagement.entity.BankAccountData;
import com.application.bankmanagement.entity.Client;

/**
 *   Bank account behaviour and data together
 *   Every bank account behaves as BankAccount and has the  data of 1 DB record in the form of a wrapped BankAccountData (Entity)
 */

public abstract class AbstractBankAccount implements BankAccount {

    // the inner Entity object holding the account data stored in DB
    final protected BankAccountData bankAccountData;

    protected AbstractBankAccount(BankAccountData  bankAccountData) {
        this.bankAccountData = bankAccountData;
    }


    public String getAccNum() {
        return bankAccountData.getAccNum();
    }

    public AccountType getAccType() {
        return bankAccountData.getAccType();
    }

    public Long getBalance() {
        return bankAccountData.getBalance();
    }

    public void setBalance(Long amount) {
        bankAccountData.setBalance( amount );
    }

    public Client getAccOwner() {
        return bankAccountData.getClient();
    }

    public void debit(Long amount) {
        setBalance( getBalance() + amount );
    }

    public void credit(Long amount) {
        setBalance( getBalance() - amount );
    }

    // calculate interest and deposit it, then return it for Bank Service so that it can credit it to a central Bank account
    public  Long addInterest() {
        Long interest = getBalance() * interestRate() / 10000L;
        debit( interest );
        return interest;
    }

    protected Long interestRate() {
        return bankAccountData.getAccType().getInterest();
    }

    public Long settleFee(Long transType) {
        return 0L;
    }

    // Object methods' overrides
    // so that BankAccounts can be collected into a Set
    public boolean equals(Object obj) {
        if (! (obj instanceof BankAccount))  return false;
        return getAccNum().equals(  ((BankAccount) obj).getAccNum() );
    }

    public int hashCode() {
        return bankAccountData.hashCode();
    }

    // a summarizing text info about BankAccount
    public String toString() {
        StringBuilder description = new StringBuilder();
        description.append("Acc.number: ");
        description.append(bankAccountData.getAccNum());
        description.append(" *** ");
        description.append("Acc.type: ");
        description.append(bankAccountData.getAccType().getName());
        description.append(" *** ");
        description.append("Owner: ");
        description.append(bankAccountData.getClient().getName());
        description.append(" *** ");
        description.append("Balance: ");
        description.append(bankAccountData.getBalance());
        return description.toString();
    }


}
