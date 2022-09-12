package com.salesart.billingmigration.service;



import io.salesart.core.entities.Billing;

import java.util.Date;
import java.util.List;

public interface BillingService  {
    List<Billing> findAllByDateLessThen (Date date);
}
