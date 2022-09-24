package com.salesart.billingmigration.controller;

import com.salesart.billingmigration.entity.Customer;
import com.salesart.billingmigration.exception.DateFormatException;
import com.salesart.billingmigration.service.CustomerFinancialTransactionMigrationService;
import com.salesart.billingmigration.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/trigger")
@RequiredArgsConstructor
@Slf4j
public class TriggerController {
    private final CustomerFinancialTransactionMigrationService customerFinancialTransactionMigrationService;
    private final CustomerService customerService;

    @GetMapping("billing-migration")
    public ResponseEntity<Void> billingMigration() throws DateFormatException {
        log.info("[BillingMigrationController] -> [trigger] Request Arrived.");
        this.customerFinancialTransactionMigrationService.billingMigrationToCustomerFinancialTransaction();
        log.info("[BillingMigrationController] -> [trigger] Request Completed Successfully.");
        return ResponseEntity.ok().build();
    }

    @GetMapping("customer-risk-info-create")
    public ResponseEntity<Void> customerRiskInfoCreate()  {
        List<Customer> customer = customerService.createCustomerRiskInfo();
        return ResponseEntity.ok().build();
    }
}
