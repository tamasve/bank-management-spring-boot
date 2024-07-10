package com.application.bankmanagement.service.command;

import com.application.bankmanagement.service.BankService;

import java.util.HashMap;
import java.util.Map;

/**
 *  The commands for using the Bank central logic, as enum - an effective approach for the UI to handle central banking transactions
 *  Technically we can have all functionalities of the inner bank services in the form of a list (<< enum .values() ), and with effective extension opportunity (Open/Close principle)
 */
public enum BankCommands implements BankCommand {


    // Create a new account - newAccount() returns the number of the new account - "0" indicates failure
    NEW_ACCOUNT("New Account", (accountDTO, bankService)->{
        accountDTO.setAcctNum( bankService.newAccount( accountDTO.getClientId(),
                                                                                                                        accountDTO.getType(),
                                                                                                                        accountDTO.isForeign()) );
        if (accountDTO.getAcctNum().equals("0"))  accountDTO.setMessage("Client not found");
        else  accountDTO.setMessage("Account created");
        return accountDTO;
    }),

    // Select an account - ???
    SELECT_AN_ACCOUNT("Select an account", (accountDTO, bankService)->{
        Long balance = bankService.getBalance(accountDTO.getAcctNum());
        System.out.println("The balance of account " + accountDTO.getAcctNum() + " is " + balance);
        return accountDTO;
    }),

    // Make deposit on an account   >> make the effect of a transaction to an account
    DEPOSIT_AN_ACCOUNT("Deposit an account", (accountDTO, bankService)->{
        bankService.deposit( accountDTO.getAcctNum(), accountDTO.getAmount() );
        return accountDTO;
    }),

    // Claim a demand for a loan relating to an account
    AUTHORIZE_LOAN("Authorize Loan", (accountDTO, bankService)->{
        boolean ok = bankService.authorizeLoan( accountDTO.getAcctNum(), accountDTO.getAmount() );
        if (ok)
            accountDTO.setMessage("Your loan is approved");
        else
            accountDTO.setMessage("Your loan is denied, too low collateral");
        return accountDTO;
    }),

    // Show data of an account -- ??
    SHOW_SERVICES("Show Services", (accountDTO, bankService)->{
        accountDTO.setMessage( bankService.toString() );
        return accountDTO;
    }),

    // Regular interest settlement on every client account
    INTEREST_SETTLEMENT("Interest Settlement", (accountDTO, bankService)-> {
        accountDTO.setMessage( bankService.interestSettlement() );
        return accountDTO;
    }),

    TEST("Test", (accountDTO, bankService) -> {
        accountDTO.setMessage( bankService.test() );
        return accountDTO;
    });


    // ~~~~~ The Structure ~~~~~
    
    private String name;
    private BankCommand cmd;

    public static Map<String, BankCommand> commandsMap;     // the map of enum values

    // static block creating the map of enum values
    static {
        commandsMap = new HashMap<>();
        for (BankCommand bc : BankCommands.values()) {
            commandsMap.put(bc.toString(), bc);
        }
    }

    private BankCommands(String name, BankCommand cmd) {
        this.name = name;
        this.cmd = cmd;
    }

    public AccountDTO execute(AccountDTO accountDTO, BankService bankService) {
        return cmd.execute(accountDTO, bankService);
    }

    public String toString() {
        return name;
    }
}
