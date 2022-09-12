package com.salesart.billingmigration.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CustomerFinancialTransactionClientException extends Exception{
    public CustomerFinancialTransactionClientException(String message) {
        super(message);
    }
}
