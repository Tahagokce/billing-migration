package com.salesart.billingmigration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("io.salesart")
@EnableJpaRepositories("io.salesart")
@EntityScan(value = {"io.salesart"})
public class BillingMigrationApplication {
    public static void main(String[] args) {
        SpringApplication.run(BillingMigrationApplication.class, args);
    }
}
