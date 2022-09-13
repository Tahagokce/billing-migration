package com.salesart.billingmigration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
public class BillingMigrationApplication {
    public static void main(String[] args) {
        SpringApplication.run(BillingMigrationApplication.class, args);
    }
}
