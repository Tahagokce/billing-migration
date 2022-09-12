package com.salesart.billingmigration.scheduler;

import com.salesart.billingmigration.exception.DateFormatException;
import com.salesart.billingmigration.service.CustomerFinancialTransactionMigrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@EnableScheduling
public class CustomerFinancialTransactionScheduler {
    private final CustomerFinancialTransactionMigrationService customerFinancialTransactionMigrationService;

    //@Scheduled(cron = "0 */30 * * * *")
    @Scheduled(fixedRate = 1000)
   public void trigger () {
        try {
            customerFinancialTransactionMigrationService.billingMigrationToCustomerFinancialTransaction();
        } catch (DateFormatException e) {
            e.printStackTrace();
        }
    }
}
