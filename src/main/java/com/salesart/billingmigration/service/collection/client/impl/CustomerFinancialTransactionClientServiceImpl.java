package com.salesart.billingmigration.service.collection.client.impl;

import com.salesart.billingmigration.constant.CollectionServiceConstant;
import com.salesart.billingmigration.entity.PaymentType;
import com.salesart.billingmigration.model.dto.CreateCustomerTransactionDto;
import com.salesart.billingmigration.model.enums.CustomerTransactionStatusEnum;
import com.salesart.billingmigration.model.enums.ModuleEnum;
import com.salesart.billingmigration.model.enums.RequestSourceEnum;
import com.salesart.billingmigration.model.enums.TransactionTypeEnum;
import com.salesart.billingmigration.model.response.GenericResponse;
import com.salesart.billingmigration.service.collection.client.CustomerFinancialTransactionClientService;
import com.salesart.billingmigration.entity.Billing;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerFinancialTransactionClientServiceImpl implements CustomerFinancialTransactionClientService {
    private final RestTemplate restTemplate;

    @Value("${collection.service.uri}")
    private String collectionServiceUri;

    @Override
    @SneakyThrows(HttpClientErrorException.class)
    public GenericResponse create(Billing billing, TransactionTypeEnum transactionTypeEnum) {
        CreateCustomerTransactionDto createCustomerTransactionDto = prepareCustomerTransaction(billing, transactionTypeEnum);
        HttpEntity<CreateCustomerTransactionDto> request = new HttpEntity<>(createCustomerTransactionDto);

        try {
            log.info("[CustomerFinancialTransactionClientServiceImpl] -> [create] : Request Sending {}", collectionServiceUri + CollectionServiceConstant.CUSTOMER_TRANSACTION_URL);
            ResponseEntity<GenericResponse> response = restTemplate.postForEntity(collectionServiceUri + CollectionServiceConstant.CUSTOMER_TRANSACTION_URL, request, GenericResponse.class);
            if (response.getStatusCode().equals(HttpStatus.OK)) {
                log.info("[CustomerFinancialTransactionClientServiceImpl] -> [create] : Request Successful, Response Body -> {}" , response.getBody());
                return response.getBody();
            } else {
                throw new HttpClientErrorException(response.getStatusCode(), "Request Error");
            }

        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), "Server Error : " + e);
        }

    }
    private CreateCustomerTransactionDto prepareCustomerTransaction(Billing billing, TransactionTypeEnum transactionTypeEnum) {
        return CreateCustomerTransactionDto.builder()
                .affectRisk(true)
                .amount(billing.getVatIncludedTotal())
                .createdVia(RequestSourceEnum.MANAGEMENT)
                .distributorId(billing.getDistributor().getId())
                .customerId(billing.getCustomer().getId())
                .description(billing.getDescription())
                .documentNo(billing.getNumber())
                .date(new Timestamp(billing.getDate().getTime()))
                .dueDate(new Timestamp(Objects.nonNull(billing.getMaturityDate()) ? billing.getMaturityDate().getTime() : billing.getDate().getTime()))
                .paymentType(new PaymentType(billing.getPaymentType().getId()))
                .module(ModuleEnum.BILLING)
                .enable(true)
                .sourceId(billing.getId())
                .createdBy(null)
                .status(CustomerTransactionStatusEnum.APPROVED)
                .transactionType(transactionTypeEnum)
                .build();

    }
}
