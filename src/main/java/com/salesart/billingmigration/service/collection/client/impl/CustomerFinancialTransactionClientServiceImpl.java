package com.salesart.billingmigration.service.collection.client.impl;

import com.salesart.billingmigration.exception.CustomerFinancialTransactionClientException;
import com.salesart.billingmigration.model.dto.CreateCustomerTransactionDto;
import com.salesart.billingmigration.service.collection.client.CustomerFinancialTransactionClientService;
import io.salesart.core.entities.Billing;
import io.salesart.core.enums.CustomerTransactionStatusEnum;
import io.salesart.core.enums.ModuleEnum;
import io.salesart.core.enums.RequestSourceEnum;
import io.salesart.core.enums.TransactionTypeEnum;
import io.salesart.core.response.GenericResponse;
import io.salesart.core.rest.BaseRestTemplate;
import io.salesart.core.util.RestServiceConfig;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CustomerFinancialTransactionClientServiceImpl implements CustomerFinancialTransactionClientService {
    private final BaseRestTemplate baseRestTemplate;

    private static final String CUSTOMER_TRANSACTION = RestServiceConfig.COLLECTION_SERVICE_URL + "/customer-transactions";


    @Override
    @SneakyThrows(CustomerFinancialTransactionClientException.class)
    public Long create(Billing billing, TransactionTypeEnum transactionTypeEnum) {
        CreateCustomerTransactionDto createCustomerTransactionDto = prepareCustomerTransaction(billing, transactionTypeEnum);


        GenericResponse<Long> response = baseRestTemplate.post(CUSTOMER_TRANSACTION, createCustomerTransactionDto, Long.class);

        if (response.getResponseStatus() != HttpStatus.OK.value()) {
            throw new CustomerFinancialTransactionClientException();
        }
        return response.getData();
    }

    private CreateCustomerTransactionDto prepareCustomerTransaction(Billing billing, TransactionTypeEnum transactionTypeEnum){
        return  CreateCustomerTransactionDto.builder()
                .affectRisk(true)
                .amount(billing.getVatIncludedTotal())
                .createdVia(RequestSourceEnum.MANAGEMENT)
                .distributorId(billing.getDistributor().getId())
                .customerId(billing.getCustomer().getId())
                .description(billing.getDescription())
                .documentNo(billing.getNumber())
                .date(new Timestamp(billing.getDate().getTime()))
                .dueDate(new Timestamp(Objects.nonNull(billing.getMaturityDate())?billing.getMaturityDate().getTime() : billing.getDate().getTime()))
                .paymentType(billing.getPaymentType())
                .module(ModuleEnum.BILLING)
                .enable(true)
                .sourceId(billing.getId())
                .createdBy(null)
                .status(CustomerTransactionStatusEnum.APPROVED)
                .transactionType(transactionTypeEnum)
                .build();

    }
}
