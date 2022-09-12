package com.salesart.billingmigration.service.impl;

import com.salesart.billingmigration.repository.BillingRepository;
import com.salesart.billingmigration.service.BillingService;
import io.salesart.core.entities.Billing;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BillingServiceImpl implements BillingService {
    private final BillingRepository billingRepository;

    @Override
    public List<Billing> findAllByDateLessThen(Date date) {
        return this.billingRepository.findAllByDateLessThan(date);
    }
}
