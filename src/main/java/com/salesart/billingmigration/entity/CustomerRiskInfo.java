package com.salesart.billingmigration.entity;

import com.salesart.billingmigration.enums.OverRiskLimitEnum;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true, exclude = "customer")
public class CustomerRiskInfo extends BaseIdEntity {

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "customerRiskInfo")
    private Customer customer;

    private BigDecimal riskLimit;

    private BigDecimal actualRiskLimit;

    @Enumerated(EnumType.STRING)
    private OverRiskLimitEnum overRiskLimit;

    private Boolean isDeleted;

    private boolean enabled;
}
