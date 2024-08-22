package com.application.bankmanagement.service.command;

import com.application.bankmanagement.service.BankService;


/**
 *  Command interface for the enum of inner bank services -
 *  So that we can have all functionalities of the inner bank services in the form of a list, and with effective extension opportunity (observing Open/Close principle)
  */

public interface BankCommand {

    /**
     *  Method signature:
     * @param accountDTO - common data transfer object
     * @param bankService - the service center object
     * @return accountDTO - common data transfer object
     */
    AccountDTO execute(AccountDTO accountDTO, BankService bankService);

}