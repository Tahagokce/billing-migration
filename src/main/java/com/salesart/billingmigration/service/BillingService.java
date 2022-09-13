package com.salesart.billingmigration.service;



import com.salesart.billingmigration.entity.Billing;

import java.util.Date;
import java.util.List;

public interface BillingService  {
    List<Billing> findAllByDateLessThen (Date date);
}
