package com.salesart.billingmigration.service;

import com.salesart.billingmigration.exception.DateFormatException;

public interface CustomerFinancialTransactionMigrationService {
    void billingMigrationToCustomerFinancialTransaction() throws DateFormatException;
}
