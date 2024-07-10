package com.application.bankmanagement.service;

import com.application.bankmanagement.entity.AccountType;
import com.application.bankmanagement.entity.BankAccountData;
import com.application.bankmanagement.entity.Client;
import com.application.bankmanagement.repository.AccountTypeRepository;
import com.application.bankmanagement.repository.BankAccountDataRepository;
import com.application.bankmanagement.repository.ClientRepository;
import com.application.bankmanagement.service.accountfactory.AccountFactories;
import com.application.bankmanagement.service.bankaccount.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BankService {

    private BankAccountDataRepository bankAccountDataRepository;
    private AccountTypeRepository accountTypeRepository;
    private ClientRepository clientRepository;
    private Map<String, BankAccount> accountMap;          // all  bank accounts in a Map: account number - account

    @Autowired
    public BankService(BankAccountDataRepository bankAccountDataRepository,
                       AccountTypeRepository accountTypeRepository,
                       ClientRepository clientRepository) {
        this.bankAccountDataRepository = bankAccountDataRepository;
        this.accountTypeRepository = accountTypeRepository;
        this.clientRepository = clientRepository;
        refreshAccountMap();
    }

    // Refresh the map of all bank account - it is not effective: it always creates a new BankAccount class object for every Entity!
    public void refreshAccountMap() {
        accountMap = new HashMap<>();
        for (BankAccountData ba : bankAccountDataRepository.findAll()) {
            String type = ba.getAccType().getName();
            accountMap.put( ba.getAccNum(),
                                                AccountFactories.createAccount(type, ba) );
        }
    }

    // Create new account - returns the new account number / "0" indicates failure
    public String newAccount(Long clientId, String type, boolean isForeign) {

        String accNum = generateAccNum();

        AccountType accType = accountTypeRepository.findByName(type);

        Client client = clientRepository.findById(clientId).orElse(null);
        if (client == null)  return "0";                        // client not found, indicate that no account generated

        String currency;
        if (isForeign)  currency = "EUR";
        else currency = "HUF";

        // Create Entity and save it into DB, then create BankAccount object in memory
        BankAccountData bankAccountData = bankAccountDataRepository.save( new BankAccountData(accNum, accType, client, 0L, currency) );
        BankAccount bankAccount = AccountFactories.createAccount(type, bankAccountData);

        return bankAccount.getAccNum();
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // Management of a concrete account

    public Long getBalance(String acctNum) {
        BankAccount bankAccount = accountMap.get(acctNum);
        return bankAccount.getBalance();
    }

    public void deposit(String acctNum, Long amount) {
        BankAccount bankAccount = accountMap.get(acctNum);
        bankAccount.debit(amount);
    }

    public boolean authorizeLoan(String acctNum, Long loanAmount) {
        BankAccount bankAccount = accountMap.get(acctNum);
        // ****
        return false;
    }
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // Central massive account handling

    // each BA calculates the interest based on its own rate, deposit it, and return it to be summarized so that it can later be credited to a central account
    public String interestSettlement() {
        Long amount = 0L;
        for (BankAccount bankAccount : accountMap.values())
            amount += bankAccount.addInterest();

        // credit this "amount" to a central account
        // ....
        return "Interest settlement done successfully";
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // Utilities

    // Account number generator
    public String generateAccNum() {
        StringBuilder number = new StringBuilder("477");
        Random random = new Random(10);
        for (int i = 1; i <= 21; i++)  number.append( String.valueOf( random.nextInt() ) );
        return number.toString();
    }

    // Bankservice presence tester
    public String test() {
        return "-- Bankservice presence debug test --";
    }
}
