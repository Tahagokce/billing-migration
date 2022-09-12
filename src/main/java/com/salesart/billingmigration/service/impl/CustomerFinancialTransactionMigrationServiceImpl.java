package com.salesart.billingmigration.service.impl;

import com.salesart.billingmigration.exception.DateFormatException;
import com.salesart.billingmigration.helper.TransactionTypeHelper;
import com.salesart.billingmigration.service.BillingService;
import com.salesart.billingmigration.service.CustomerFinancialTransactionMigrationService;
import com.salesart.billingmigration.service.collection.client.CustomerFinancialTransactionClientService;
import com.salesart.billingmigration.util.DateUtil;
import io.salesart.core.entities.Billing;
import io.salesart.core.enums.TransactionTypeEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerFinancialTransactionMigrationServiceImpl implements CustomerFinancialTransactionMigrationService {
    private final BillingService billingService;
    private final CustomerFinancialTransactionClientService customerFinancialTransactionClientService;

    private TransactionTypeHelper.TransactionTypeMapKey mapKey;

    @Value("${search.date}")
    private String billingDate;

    public void billingMigrationToCustomerFinancialTransaction() throws DateFormatException {
        List<Billing> allBilling = billingService.findAllByDateLessThen(DateUtil.convert(billingDate));

        allBilling.forEach(billing -> {
            TransactionTypeEnum transactionTypeEnum = TransactionTypeHelper.TRANSACTION_TYPE_PER_BILLING_TYPE_MAP_PER_KEY
                    .get(mapKey)
                    .get(billing.getBillingType());
            customerFinancialTransactionClientService.create(billing, transactionTypeEnum);
        });
    }
}
