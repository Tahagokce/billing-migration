package com.salesart.billingmigration.model.dto;

import com.salesart.billingmigration.entity.PaymentType;
import com.salesart.billingmigration.entity.User;
import com.salesart.billingmigration.model.enums.CustomerTransactionStatusEnum;
import com.salesart.billingmigration.model.enums.ModuleEnum;
import com.salesart.billingmigration.model.enums.RequestSourceEnum;
import com.salesart.billingmigration.model.enums.TransactionTypeEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Builder
public class CreateCustomerTransactionDto {

    private boolean affectRisk;

    private Date date;

    private Date dueDate;

    private BigDecimal amount;

    private TransactionTypeEnum transactionType;

    private CustomerTransactionStatusEnum status;

    private RequestSourceEnum createdVia;

    private String description;

    private Long customerId;

    private boolean enable;

    private String documentNo;

    private Long sourceId;

    private ModuleEnum module;

    private Long distributorId;

    private PaymentType paymentType;

    private User createdBy;

    private User updatedBy;
}
