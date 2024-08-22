package com.application.bankmanagement.service.accountfactory;

import com.application.bankmanagement.entity.BankAccountData;
import com.application.bankmanagement.service.bankaccount.*;

import java.util.HashMap;
import java.util.Map;

/**
 *  Fix number of account creators for the fix number of account types -
 *  The names of enum constants correspond to the menu item names on the UI layout >> the name of the chosen menu item in each call from the UI can be the key in the factory map.
  */

public enum AccountFactories implements AccountFactory {
    CURRENT("Current account", CurrentAccount::new),
    DEPOSIT("Deposit account", DepositAccount::new),
    FOREIGN_CURRENCY("Foreign Currency account", ForeignCurrencyAccount::new),
    INVESTMENT("Investment account", InvestmentAccount::new),
    SAVINGS("Savings account", SavingsAccount::new),
    WEB("Web account", WebAccount::new);

   private String name;
   private final AccountFactory accountFactory;

    // static variable  for holding the map of enum values
    public static Map<String, AccountFactory> factoriesMap;

    // static block creating the map of enum values
    static {
        factoriesMap = new HashMap<>();
        for (AccountFactory af : AccountFactories.values()) {
            factoriesMap.put(af.toString(), af);
        }
    }

    // the general static factory creating any account by type (which is the name of the account type, harmonized with the enum names)
    public static BankAccount createAccount(String type, BankAccountData bankAccountData) {
        return factoriesMap.get(type).create(bankAccountData);
    }


   private AccountFactories(String name, AccountFactory accountFactory) {
      this.name = name;
      this.accountFactory = accountFactory;
   }

   @Override
   public BankAccount create(BankAccountData bankAccountData) {
      return accountFactory.create(bankAccountData);
   }

   public String toString() {
      return name;
   }


}
