package com.salesart.billingmigration.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class PaymentType extends BaseIdEntity {
    public PaymentType(Long id) {
        super(id);
    }
}
