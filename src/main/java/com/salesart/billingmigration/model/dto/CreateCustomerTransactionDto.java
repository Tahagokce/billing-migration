package com.salesart.billingmigration.model.dto;

import io.salesart.core.entities.PaymentType;
import io.salesart.core.entities.user.User;
import io.salesart.core.enums.CustomerTransactionStatusEnum;
import io.salesart.core.enums.ModuleEnum;
import io.salesart.core.enums.RequestSourceEnum;
import io.salesart.core.enums.TransactionTypeEnum;
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
