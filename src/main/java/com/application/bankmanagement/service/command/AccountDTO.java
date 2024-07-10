package com.application.bankmanagement.service.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *   Data Transfer Object for transferring data between the controllers and the services, during account related transactions
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {

    private String acctNum;
    private Long clientId;
    private String type;
    private boolean isForeign;
    private Long amount;
    private String message;
}
