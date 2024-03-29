package com.salesart.billingmigration.entity;

import com.salesart.billingmigration.enums.OverRiskLimitEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Customer extends BaseIdEntity {
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "risk_info_id")
    private CustomerRiskInfo customerRiskInfo;

    @Column(columnDefinition = "DECIMAL(19,8)")
    private BigDecimal riskLimit = BigDecimal.valueOf(0);

    @Enumerated(EnumType.STRING)
    private OverRiskLimitEnum overRiskLimit;

}
