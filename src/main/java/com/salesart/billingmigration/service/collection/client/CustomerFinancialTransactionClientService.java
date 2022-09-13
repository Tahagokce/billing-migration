package com.salesart.billingmigration.service.collection.client;

import com.salesart.billingmigration.entity.Billing;
import com.salesart.billingmigration.model.enums.TransactionTypeEnum;
import com.salesart.billingmigration.model.response.GenericResponse;

public interface CustomerFinancialTransactionClientService  {
    GenericResponse create(Billing billing, TransactionTypeEnum transactionTypeEnum);
}
