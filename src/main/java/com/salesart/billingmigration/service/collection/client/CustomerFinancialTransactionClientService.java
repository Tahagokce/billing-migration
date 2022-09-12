package com.salesart.billingmigration.service.collection.client;

import io.salesart.core.entities.Billing;
import io.salesart.core.enums.TransactionTypeEnum;

public interface CustomerFinancialTransactionClientService {
    Long create(Billing billing, TransactionTypeEnum transactionTypeEnum);
}
