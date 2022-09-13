package com.salesart.billingmigration.service.impl;

import com.salesart.billingmigration.entity.BillingTypeEnum;
import com.salesart.billingmigration.exception.DateFormatException;
import com.salesart.billingmigration.model.enums.TransactionTypeEnum;
import com.salesart.billingmigration.model.enums.TransactionTypeGroup;
import com.salesart.billingmigration.service.BillingService;
import com.salesart.billingmigration.service.CustomerFinancialTransactionMigrationService;
import com.salesart.billingmigration.service.collection.client.CustomerFinancialTransactionClientService;
import com.salesart.billingmigration.util.DateUtil;
import com.salesart.billingmigration.entity.Billing;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerFinancialTransactionMigrationServiceImpl implements CustomerFinancialTransactionMigrationService {
    private final BillingService billingService;
    private final CustomerFinancialTransactionClientService customerFinancialTransactionClientService;

    @Value("${search.date}")
    private String billingDate;

    public void billingMigrationToCustomerFinancialTransaction() throws DateFormatException {
        List<Billing> allBilling = billingService.findAllByDateLessThen(DateUtil.convert(billingDate));
        if (CollectionUtils.isEmpty(allBilling)) {
            log.info("[CustomerFinancialTransactionMigrationServiceImpl] -> [billingMigrationToCustomerFinancialTransaction] : Not Found Billing To Be Migrated.");
        } else {
            log.info("[CustomerFinancialTransactionMigrationServiceImpl] -> [billingMigrationToCustomerFinancialTransaction] : Migration Starting, number of invoices to be migrated {}", allBilling.size());
            allBilling.forEach(billing -> {
                customerFinancialTransactionClientService.create(billing, transactionTypeSelector(billing.getBillingType()));
            });
        }
    }

    private TransactionTypeEnum transactionTypeSelector(BillingTypeEnum billingTypeEnum) {
        final TransactionTypeEnum[] transactionTypeEnum = new TransactionTypeEnum[1];
        Arrays.stream(TransactionTypeEnum.values()).collect(Collectors.toList()).forEach(transactionType -> {
            if (transactionType.getTransactionTypeGroup().equals(TransactionTypeGroup.INVOICE)) {
                if (transactionType.toString().equals(billingTypeEnum.toString())) {
                    transactionTypeEnum[0] = transactionType;
                }
            }
        });
        return transactionTypeEnum[0];
    }
}
