package com.salesart.billingmigration.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class Billing extends BaseIdEntity {
    @Column(unique = true)
    private String number;

    private Date date;

    @Enumerated(EnumType.STRING)
    private BillingStatusEnum status = BillingStatusEnum.CREATED;

    @Enumerated(EnumType.STRING)
    private BillingTypeEnum billingType;

    private BigDecimal grossTotal;

    private BigDecimal vatIncludedTotal;

    private String description;

    private Date maturityDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    private Distributor distributor;

    @ManyToOne(fetch = FetchType.LAZY)
    private PaymentType paymentType;
}