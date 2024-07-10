package com.application.bankmanagement.controller;

import com.application.bankmanagement.service.BankService;
import com.application.bankmanagement.service.command.AccountDTO;
import com.application.bankmanagement.service.command.BankCommand;
import com.application.bankmanagement.service.command.BankCommands;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

// only for data transfer debug tests
@RestController
@RequestMapping("test")
public class DataTransferTest {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    private BankService bankService;
    @Autowired
    public DataTransferTest(BankService bankService) {
        this.bankService = bankService;
    }


    @GetMapping("")
    public String start() {
        return "*******  TEST AREA  ********";
    }

    @GetMapping("/read")
    public String read() {
        return "-- Read rights area --";
    }

    @GetMapping("/admin")
    public String admin() {
        return "-- Admin area --";
    }

    @GetMapping("commands")
    public Map<String, BankCommand> commands() {
        return BankCommands.commandsMap;
    }

    @GetMapping("command/{command}")
    public String testCommand(@PathVariable String command) {
        Map<String, BankCommand> commandsMap = BankCommands.commandsMap;
        try {
            if (commandsMap.containsKey(command)) {
                commandsMap.get(command).execute(new AccountDTO("", 0L, "", false, 0L, ""), bankService);
                return "\"" + command + "\" command was executed";
            } else {
                return "\"" + command + "\" is not a valid command!";
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return "The execution of \"" + command + "\" command FAILED DUE TO  " + e.getMessage();
        }
    }

    @GetMapping("bankservicetest")
    public String bankServiceTest() {
        return BankCommands.TEST.execute(null, bankService).getMessage();
    }

}
