package com.salesart.billingmigration.controller;

import com.salesart.billingmigration.exception.DateFormatException;
import com.salesart.billingmigration.service.CustomerFinancialTransactionMigrationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/billing-migration")
@RequiredArgsConstructor
@Slf4j
public class BillingMigrationController {
    private final CustomerFinancialTransactionMigrationService customerFinancialTransactionMigrationService;

    @GetMapping("trigger")
    public ResponseEntity<Void> trigger() throws DateFormatException {
        log.info("[BillingMigrationController] -> [trigger] Request Arrived.");
        this.customerFinancialTransactionMigrationService.billingMigrationToCustomerFinancialTransaction();
        log.info("[BillingMigrationController] -> [trigger] Request Completed Successfully.");
        return ResponseEntity.ok().build();
    }
}
