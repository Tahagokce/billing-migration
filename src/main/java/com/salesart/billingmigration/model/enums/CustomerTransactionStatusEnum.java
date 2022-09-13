package com.salesart.billingmigration.model.enums;

public enum CustomerTransactionStatusEnum {

    APPROVED("customer.transaction.status.approved"),
    CANCELED("customer.transaction.status.canceled"),
    WAITING_FOR_APPROVAL("customer.transaction.status.send.to.approve");

    private String messageKey;

    CustomerTransactionStatusEnum(String messageKey) {
        this.messageKey = messageKey;
    }

    @Override
    public String toString() {
        return messageKey;
    }
}