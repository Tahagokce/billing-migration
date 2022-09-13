package com.salesart.billingmigration.helper;

import com.salesart.billingmigration.entity.BillingTypeEnum;
import com.salesart.billingmigration.model.enums.OrderTypeEnum;
import com.salesart.billingmigration.model.enums.TransactionTypeEnum;
import com.salesart.billingmigration.model.enums.TransactionTypeGroup;
import com.salesart.billingmigration.model.enums.TransactionTypeGroupForCampaign;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class TransactionTypeHelper {

    public enum TransactionTypeMapKey {
        WAYBILL, INVOICE, CANCEL_MANUAL_WAYBILL, CANCEL_MANUAL_INVOICE, CANCEL_WAYBILL, CANCEL_INVOICE,
        SERVICE_INVOICE, CANCEL_SERVICE_INVOICE
    }

    public static final Set<TransactionTypeEnum> PRICE_FROM_REQUEST_TRANSACTION_TYPES = new HashSet<>();
    public static final Set<TransactionTypeEnum> CAMPAIGN_APPLICABLE_TRANSACTION_TYPES = new HashSet<>();
    public static final List<TransactionTypeEnum> SELLING_TRANSACTION_TYPES = new ArrayList<>();
    public static final List<TransactionTypeEnum> BUYING_TRANSACTION_TYPES = new ArrayList<>();
    public static final List<TransactionTypeEnum> RETURN_TRANSACTION_TYPES = new ArrayList<>();
    public static final List<TransactionTypeEnum> BUYING_PRICE_TRANSACTION_TYPES = new ArrayList<>();
    public static final Set<BillingTypeEnum> NOT_WAYBILLABLE_TYPES = new HashSet<>();
    public static final Set<BillingTypeEnum> CHECK_FOR_STOCK_BILLING_TYPES = new HashSet<>();
    public static final Set<BillingTypeEnum> SELLING_BILLING_TYPES = new HashSet<>();

    public static final Map<TransactionTypeEnum, OrderTypeEnum> ORDER_TYPE_PER_TRANSACTION_TYPE =
            new EnumMap<>(TransactionTypeEnum.class);
    public static final Map<OrderTypeEnum, TransactionTypeEnum> INVOICE_TRANSACTION_TYPE_PER_ORDER_TYPE =
            new EnumMap<>(OrderTypeEnum.class);
    public static final Map<OrderTypeEnum, TransactionTypeEnum> WAYBILL_TRANSACTION_TYPE_PER_ORDER_TYPE =
            new EnumMap<>(OrderTypeEnum.class);

    public static final Map<TransactionTypeGroupForCampaign, List<TransactionTypeEnum>> TRANSACTION_TYPE_MAP_FOR_CAMPAIGN =
            new EnumMap<>(TransactionTypeGroupForCampaign.class);


    public static final Map<TransactionTypeEnum, BillingTypeEnum> BILLING_TYPE_PER_TRANSACTION_TYPE =
            new EnumMap<>(TransactionTypeEnum.class);

    public static final Map<TransactionTypeMapKey, Map<BillingTypeEnum, TransactionTypeEnum>>
            TRANSACTION_TYPE_PER_BILLING_TYPE_MAP_PER_KEY = new EnumMap<>(TransactionTypeMapKey.class);

    static {
        ORDER_TYPE_PER_TRANSACTION_TYPE.put(TransactionTypeEnum.BUYING, OrderTypeEnum.BUYING);
        ORDER_TYPE_PER_TRANSACTION_TYPE.put(TransactionTypeEnum.SELLING, OrderTypeEnum.SELLING);
        ORDER_TYPE_PER_TRANSACTION_TYPE.put(TransactionTypeEnum.BUYING_WAYBILL, OrderTypeEnum.BUYING);
        ORDER_TYPE_PER_TRANSACTION_TYPE.put(TransactionTypeEnum.SELLING_WAYBILL, OrderTypeEnum.SELLING);

        INVOICE_TRANSACTION_TYPE_PER_ORDER_TYPE.put(OrderTypeEnum.BUYING, TransactionTypeEnum.BUYING);
        INVOICE_TRANSACTION_TYPE_PER_ORDER_TYPE.put(OrderTypeEnum.SELLING, TransactionTypeEnum.SELLING);
        WAYBILL_TRANSACTION_TYPE_PER_ORDER_TYPE.put(OrderTypeEnum.BUYING, TransactionTypeEnum.BUYING_WAYBILL);
        WAYBILL_TRANSACTION_TYPE_PER_ORDER_TYPE.put(OrderTypeEnum.SELLING, TransactionTypeEnum.SELLING_WAYBILL);

        BILLING_TYPE_PER_TRANSACTION_TYPE.put(TransactionTypeEnum.BUYING, BillingTypeEnum.BUYING);
        BILLING_TYPE_PER_TRANSACTION_TYPE.put(TransactionTypeEnum.SELLING, BillingTypeEnum.SELLING);
        BILLING_TYPE_PER_TRANSACTION_TYPE.put(TransactionTypeEnum.BUYING_WAYBILL, BillingTypeEnum.BUYING);
        BILLING_TYPE_PER_TRANSACTION_TYPE.put(TransactionTypeEnum.SELLING_WAYBILL, BillingTypeEnum.SELLING);
        BILLING_TYPE_PER_TRANSACTION_TYPE.put(TransactionTypeEnum.MANUAL_BUYING, BillingTypeEnum.BUYING);
        BILLING_TYPE_PER_TRANSACTION_TYPE.put(TransactionTypeEnum.MANUAL_BUYING_WAYBILL, BillingTypeEnum.BUYING);
        BILLING_TYPE_PER_TRANSACTION_TYPE.put(TransactionTypeEnum.MANUAL_SELLING, BillingTypeEnum.SELLING);
        BILLING_TYPE_PER_TRANSACTION_TYPE.put(TransactionTypeEnum.MANUAL_SELLING_WAYBILL, BillingTypeEnum.SELLING);
        BILLING_TYPE_PER_TRANSACTION_TYPE.put(TransactionTypeEnum.BUYING_RETURN, BillingTypeEnum.BUYING_RETURN);
        BILLING_TYPE_PER_TRANSACTION_TYPE.put(TransactionTypeEnum.BUYING_RETURN_WAYBILL, BillingTypeEnum.BUYING_RETURN);
        BILLING_TYPE_PER_TRANSACTION_TYPE.put(TransactionTypeEnum.SELLING_RETURN, BillingTypeEnum.SELLING_RETURN);
        BILLING_TYPE_PER_TRANSACTION_TYPE.put(TransactionTypeEnum.SELLING_RETURN_WAYBILL,
                BillingTypeEnum.SELLING_RETURN);
        BILLING_TYPE_PER_TRANSACTION_TYPE.put(TransactionTypeEnum.DAMAGED_BUYING_RETURN_WAYBILL,
                BillingTypeEnum.DAMAGED_BUYING_RETURN);
        BILLING_TYPE_PER_TRANSACTION_TYPE.put(TransactionTypeEnum.DAMAGED_SELLING_RETURN_WAYBILL,
                BillingTypeEnum.DAMAGED_SELLING_RETURN);
        BILLING_TYPE_PER_TRANSACTION_TYPE.put(TransactionTypeEnum.DAMAGED_BUYING_RETURN,
                BillingTypeEnum.DAMAGED_BUYING_RETURN);
        BILLING_TYPE_PER_TRANSACTION_TYPE.put(TransactionTypeEnum.DAMAGED_SELLING_RETURN,
                BillingTypeEnum.DAMAGED_SELLING_RETURN);
        BILLING_TYPE_PER_TRANSACTION_TYPE.put(TransactionTypeEnum.BUYING_SERVICE_INVOICE,
                BillingTypeEnum.BUYING_SERVICE);
        BILLING_TYPE_PER_TRANSACTION_TYPE.put(TransactionTypeEnum.SELLING_SERVICE_INVOICE,
                BillingTypeEnum.SELLING_SERVICE);

        TRANSACTION_TYPE_MAP_FOR_CAMPAIGN.put(TransactionTypeGroupForCampaign.SELLING, SELLING_TRANSACTION_TYPES);
        TRANSACTION_TYPE_MAP_FOR_CAMPAIGN.put(TransactionTypeGroupForCampaign.BUYING, BUYING_TRANSACTION_TYPES);
        TRANSACTION_TYPE_MAP_FOR_CAMPAIGN.put(TransactionTypeGroupForCampaign.RETURN, RETURN_TRANSACTION_TYPES);

        PRICE_FROM_REQUEST_TRANSACTION_TYPES.add(TransactionTypeEnum.BUYING_RETURN);
        PRICE_FROM_REQUEST_TRANSACTION_TYPES.add(TransactionTypeEnum.BUYING_RETURN_WAYBILL);
        PRICE_FROM_REQUEST_TRANSACTION_TYPES.add(TransactionTypeEnum.SELLING_RETURN);
        PRICE_FROM_REQUEST_TRANSACTION_TYPES.add(TransactionTypeEnum.SELLING_RETURN_WAYBILL);
        PRICE_FROM_REQUEST_TRANSACTION_TYPES.add(TransactionTypeEnum.DAMAGED_BUYING_RETURN_WAYBILL);
        PRICE_FROM_REQUEST_TRANSACTION_TYPES.add(TransactionTypeEnum.DAMAGED_SELLING_RETURN_WAYBILL);
        PRICE_FROM_REQUEST_TRANSACTION_TYPES.add(TransactionTypeEnum.DAMAGED_BUYING_RETURN);
        PRICE_FROM_REQUEST_TRANSACTION_TYPES.add(TransactionTypeEnum.DAMAGED_SELLING_RETURN);
        PRICE_FROM_REQUEST_TRANSACTION_TYPES.add(TransactionTypeEnum.BUYING_SERVICE_INVOICE);
        PRICE_FROM_REQUEST_TRANSACTION_TYPES.add(TransactionTypeEnum.SELLING_SERVICE_INVOICE);

        CHECK_FOR_STOCK_BILLING_TYPES.add(BillingTypeEnum.SELLING);
        CHECK_FOR_STOCK_BILLING_TYPES.add(BillingTypeEnum.BUYING_RETURN);
        CHECK_FOR_STOCK_BILLING_TYPES.add(BillingTypeEnum.DAMAGED_BUYING_RETURN);

        CAMPAIGN_APPLICABLE_TRANSACTION_TYPES.add(TransactionTypeEnum.SELLING);
        CAMPAIGN_APPLICABLE_TRANSACTION_TYPES.add(TransactionTypeEnum.SELLING_WAYBILL);
        CAMPAIGN_APPLICABLE_TRANSACTION_TYPES.add(TransactionTypeEnum.BUYING);
        CAMPAIGN_APPLICABLE_TRANSACTION_TYPES.add(TransactionTypeEnum.BUYING_WAYBILL);
        CAMPAIGN_APPLICABLE_TRANSACTION_TYPES.add(TransactionTypeEnum.SELLING_RETURN);
        CAMPAIGN_APPLICABLE_TRANSACTION_TYPES.add(TransactionTypeEnum.SELLING_RETURN_WAYBILL);
        CAMPAIGN_APPLICABLE_TRANSACTION_TYPES.add(TransactionTypeEnum.BUYING_RETURN);
        CAMPAIGN_APPLICABLE_TRANSACTION_TYPES.add(TransactionTypeEnum.BUYING_RETURN_WAYBILL);
        CAMPAIGN_APPLICABLE_TRANSACTION_TYPES.add(TransactionTypeEnum.DAMAGED_BUYING_RETURN);
        CAMPAIGN_APPLICABLE_TRANSACTION_TYPES.add(TransactionTypeEnum.DAMAGED_SELLING_RETURN);
        CAMPAIGN_APPLICABLE_TRANSACTION_TYPES.add(TransactionTypeEnum.DAMAGED_BUYING_RETURN_WAYBILL);
        CAMPAIGN_APPLICABLE_TRANSACTION_TYPES.add(TransactionTypeEnum.DAMAGED_SELLING_RETURN_WAYBILL);
        CAMPAIGN_APPLICABLE_TRANSACTION_TYPES.add(TransactionTypeEnum.BUYING_SERVICE_INVOICE);
        CAMPAIGN_APPLICABLE_TRANSACTION_TYPES.add(TransactionTypeEnum.SELLING_SERVICE_INVOICE);

        SELLING_TRANSACTION_TYPES.add(TransactionTypeEnum.SELLING);
        SELLING_TRANSACTION_TYPES.add(TransactionTypeEnum.SELLING_WAYBILL);
        SELLING_TRANSACTION_TYPES.add(TransactionTypeEnum.SELLING_ORDER);

        BUYING_TRANSACTION_TYPES.add(TransactionTypeEnum.BUYING);
        BUYING_TRANSACTION_TYPES.add(TransactionTypeEnum.BUYING_WAYBILL);
        BUYING_TRANSACTION_TYPES.add(TransactionTypeEnum.BUYING_ORDER);

        RETURN_TRANSACTION_TYPES.add(TransactionTypeEnum.SELLING_RETURN);
        RETURN_TRANSACTION_TYPES.add(TransactionTypeEnum.SELLING_RETURN_WAYBILL);
        RETURN_TRANSACTION_TYPES.add(TransactionTypeEnum.BUYING_RETURN);
        RETURN_TRANSACTION_TYPES.add(TransactionTypeEnum.BUYING_RETURN_WAYBILL);
        RETURN_TRANSACTION_TYPES.add(TransactionTypeEnum.DAMAGED_BUYING_RETURN);
        RETURN_TRANSACTION_TYPES.add(TransactionTypeEnum.DAMAGED_SELLING_RETURN);
        RETURN_TRANSACTION_TYPES.add(TransactionTypeEnum.DAMAGED_BUYING_RETURN_WAYBILL);
        RETURN_TRANSACTION_TYPES.add(TransactionTypeEnum.DAMAGED_SELLING_RETURN_WAYBILL);

        BUYING_PRICE_TRANSACTION_TYPES.addAll(BUYING_TRANSACTION_TYPES);
        BUYING_PRICE_TRANSACTION_TYPES.add(TransactionTypeEnum.BUYING_RETURN);
        BUYING_PRICE_TRANSACTION_TYPES.add(TransactionTypeEnum.DAMAGED_BUYING_RETURN);
        BUYING_PRICE_TRANSACTION_TYPES.add(TransactionTypeEnum.BUYING_RETURN_WAYBILL);
        BUYING_PRICE_TRANSACTION_TYPES.add(TransactionTypeEnum.DAMAGED_BUYING_RETURN_WAYBILL);


        NOT_WAYBILLABLE_TYPES.add(BillingTypeEnum.SELLING_SERVICE);
        NOT_WAYBILLABLE_TYPES.add(BillingTypeEnum.BUYING_SERVICE);

        SELLING_BILLING_TYPES.add(BillingTypeEnum.SELLING);
        SELLING_BILLING_TYPES.add(BillingTypeEnum.SELLING_RETURN);
        SELLING_BILLING_TYPES.add(BillingTypeEnum.DAMAGED_SELLING_RETURN);

        TRANSACTION_TYPE_PER_BILLING_TYPE_MAP_PER_KEY.put(TransactionTypeMapKey.WAYBILL,
                new EnumMap<>(BillingTypeEnum.class));
        TRANSACTION_TYPE_PER_BILLING_TYPE_MAP_PER_KEY.put(TransactionTypeMapKey.INVOICE,
                new EnumMap<>(BillingTypeEnum.class));
        TRANSACTION_TYPE_PER_BILLING_TYPE_MAP_PER_KEY.put(TransactionTypeMapKey.CANCEL_MANUAL_WAYBILL,
                new EnumMap<>(BillingTypeEnum.class));
        TRANSACTION_TYPE_PER_BILLING_TYPE_MAP_PER_KEY.put(TransactionTypeMapKey.CANCEL_MANUAL_INVOICE,
                new EnumMap<>(BillingTypeEnum.class));
        TRANSACTION_TYPE_PER_BILLING_TYPE_MAP_PER_KEY.put(TransactionTypeMapKey.CANCEL_WAYBILL,
                new EnumMap<>(BillingTypeEnum.class));
        TRANSACTION_TYPE_PER_BILLING_TYPE_MAP_PER_KEY.put(TransactionTypeMapKey.CANCEL_INVOICE,
                new EnumMap<>(BillingTypeEnum.class));
        TRANSACTION_TYPE_PER_BILLING_TYPE_MAP_PER_KEY.put(TransactionTypeMapKey.SERVICE_INVOICE,
                new EnumMap<>(BillingTypeEnum.class));
        TRANSACTION_TYPE_PER_BILLING_TYPE_MAP_PER_KEY.put(TransactionTypeMapKey.CANCEL_SERVICE_INVOICE,
                new EnumMap<>(BillingTypeEnum.class));

        TRANSACTION_TYPE_PER_BILLING_TYPE_MAP_PER_KEY.get(TransactionTypeMapKey.WAYBILL).put(BillingTypeEnum.BUYING,
                TransactionTypeEnum.BUYING_WAYBILL);
        TRANSACTION_TYPE_PER_BILLING_TYPE_MAP_PER_KEY.get(TransactionTypeMapKey.WAYBILL).put(BillingTypeEnum.SELLING,
                TransactionTypeEnum.SELLING_WAYBILL);
        TRANSACTION_TYPE_PER_BILLING_TYPE_MAP_PER_KEY.get(TransactionTypeMapKey.WAYBILL).put(BillingTypeEnum.BUYING_RETURN,
                TransactionTypeEnum.BUYING_RETURN_WAYBILL);
        TRANSACTION_TYPE_PER_BILLING_TYPE_MAP_PER_KEY.get(TransactionTypeMapKey.WAYBILL).put(BillingTypeEnum.SELLING_RETURN,
                TransactionTypeEnum.SELLING_RETURN_WAYBILL);
        TRANSACTION_TYPE_PER_BILLING_TYPE_MAP_PER_KEY.get(TransactionTypeMapKey.WAYBILL).put(BillingTypeEnum.DAMAGED_BUYING_RETURN,
                TransactionTypeEnum.DAMAGED_BUYING_RETURN_WAYBILL);
        TRANSACTION_TYPE_PER_BILLING_TYPE_MAP_PER_KEY.get(TransactionTypeMapKey.WAYBILL).put(BillingTypeEnum.DAMAGED_SELLING_RETURN,
                TransactionTypeEnum.DAMAGED_SELLING_RETURN_WAYBILL);

        TRANSACTION_TYPE_PER_BILLING_TYPE_MAP_PER_KEY.get(TransactionTypeMapKey.INVOICE).put(BillingTypeEnum.BUYING,
                TransactionTypeEnum.BUYING);
        TRANSACTION_TYPE_PER_BILLING_TYPE_MAP_PER_KEY.get(TransactionTypeMapKey.INVOICE).put(BillingTypeEnum.SELLING,
                TransactionTypeEnum.SELLING);
        TRANSACTION_TYPE_PER_BILLING_TYPE_MAP_PER_KEY.get(TransactionTypeMapKey.INVOICE).put(BillingTypeEnum.BUYING_RETURN, TransactionTypeEnum.BUYING_RETURN);
        TRANSACTION_TYPE_PER_BILLING_TYPE_MAP_PER_KEY.get(TransactionTypeMapKey.INVOICE).put(BillingTypeEnum.SELLING_RETURN, TransactionTypeEnum.SELLING_RETURN);
        TRANSACTION_TYPE_PER_BILLING_TYPE_MAP_PER_KEY.get(TransactionTypeMapKey.INVOICE).put(BillingTypeEnum.DAMAGED_BUYING_RETURN,
                TransactionTypeEnum.DAMAGED_BUYING_RETURN);
        TRANSACTION_TYPE_PER_BILLING_TYPE_MAP_PER_KEY.get(TransactionTypeMapKey.INVOICE).put(BillingTypeEnum.DAMAGED_SELLING_RETURN,
                TransactionTypeEnum.DAMAGED_SELLING_RETURN);

        TRANSACTION_TYPE_PER_BILLING_TYPE_MAP_PER_KEY.get(TransactionTypeMapKey.CANCEL_MANUAL_WAYBILL).put(BillingTypeEnum.BUYING,
                TransactionTypeEnum.CANCEL_MANUAL_BUYING_WAYBILL);
        TRANSACTION_TYPE_PER_BILLING_TYPE_MAP_PER_KEY.get(TransactionTypeMapKey.CANCEL_MANUAL_WAYBILL).put(BillingTypeEnum.SELLING,
                TransactionTypeEnum.CANCEL_MANUAL_SELLING_WAYBILL);
        TRANSACTION_TYPE_PER_BILLING_TYPE_MAP_PER_KEY.get(TransactionTypeMapKey.CANCEL_MANUAL_WAYBILL).put(BillingTypeEnum.BUYING_RETURN,
                TransactionTypeEnum.CANCEL_BUYING_WAYBILL_RETURN);
        TRANSACTION_TYPE_PER_BILLING_TYPE_MAP_PER_KEY.get(TransactionTypeMapKey.CANCEL_MANUAL_WAYBILL).put(BillingTypeEnum.SELLING_RETURN,
                TransactionTypeEnum.CANCEL_SELLING_WAYBILL_RETURN);
        TRANSACTION_TYPE_PER_BILLING_TYPE_MAP_PER_KEY.get(TransactionTypeMapKey.CANCEL_MANUAL_WAYBILL).put(BillingTypeEnum.DAMAGED_BUYING_RETURN,
                TransactionTypeEnum.CANCEL_DAMAGED_BUYING_RETURN_WAYBILL);
        TRANSACTION_TYPE_PER_BILLING_TYPE_MAP_PER_KEY.get(TransactionTypeMapKey.CANCEL_MANUAL_WAYBILL).put(BillingTypeEnum.DAMAGED_SELLING_RETURN,
                TransactionTypeEnum.CANCEL_DAMAGED_SELLING_RETURN_WAYBILL);

        TRANSACTION_TYPE_PER_BILLING_TYPE_MAP_PER_KEY.get(TransactionTypeMapKey.CANCEL_MANUAL_INVOICE).put(BillingTypeEnum.BUYING,
                TransactionTypeEnum.CANCEL_MANUAL_BUYING);
        TRANSACTION_TYPE_PER_BILLING_TYPE_MAP_PER_KEY.get(TransactionTypeMapKey.CANCEL_MANUAL_INVOICE).put(BillingTypeEnum.SELLING,
                TransactionTypeEnum.CANCEL_MANUAL_SELLING);
        TRANSACTION_TYPE_PER_BILLING_TYPE_MAP_PER_KEY.get(TransactionTypeMapKey.CANCEL_MANUAL_INVOICE).put(BillingTypeEnum.BUYING_RETURN,
                TransactionTypeEnum.CANCEL_BUYING_RETURN);
        TRANSACTION_TYPE_PER_BILLING_TYPE_MAP_PER_KEY.get(TransactionTypeMapKey.CANCEL_MANUAL_INVOICE).put(BillingTypeEnum.SELLING_RETURN,
                TransactionTypeEnum.CANCEL_SELLING_RETURN);
        TRANSACTION_TYPE_PER_BILLING_TYPE_MAP_PER_KEY.get(TransactionTypeMapKey.CANCEL_MANUAL_INVOICE).put(BillingTypeEnum.DAMAGED_BUYING_RETURN,
                TransactionTypeEnum.CANCEL_DAMAGED_BUYING_RETURN);
        TRANSACTION_TYPE_PER_BILLING_TYPE_MAP_PER_KEY.get(TransactionTypeMapKey.CANCEL_MANUAL_INVOICE).put(BillingTypeEnum.DAMAGED_SELLING_RETURN,
                TransactionTypeEnum.CANCEL_DAMAGED_SELLING_RETURN);
        TRANSACTION_TYPE_PER_BILLING_TYPE_MAP_PER_KEY.get(TransactionTypeMapKey.CANCEL_MANUAL_INVOICE).put(BillingTypeEnum.SELLING_SERVICE,
                TransactionTypeEnum.CANCEL_SELLING_SERVICE_INVOICE);
        TRANSACTION_TYPE_PER_BILLING_TYPE_MAP_PER_KEY.get(TransactionTypeMapKey.CANCEL_MANUAL_INVOICE).put(BillingTypeEnum.BUYING_SERVICE,
                TransactionTypeEnum.CANCEL_BUYING_SERVICE_INVOICE);

        TRANSACTION_TYPE_PER_BILLING_TYPE_MAP_PER_KEY.get(TransactionTypeMapKey.CANCEL_WAYBILL).put(BillingTypeEnum.BUYING,
                TransactionTypeEnum.CANCEL_BUYING_WAYBILL);
        TRANSACTION_TYPE_PER_BILLING_TYPE_MAP_PER_KEY.get(TransactionTypeMapKey.CANCEL_WAYBILL).put(BillingTypeEnum.SELLING,
                TransactionTypeEnum.CANCEL_SELLING_WAYBILL);
        TRANSACTION_TYPE_PER_BILLING_TYPE_MAP_PER_KEY.get(TransactionTypeMapKey.CANCEL_WAYBILL).put(BillingTypeEnum.BUYING_RETURN,
                TransactionTypeEnum.CANCEL_BUYING_WAYBILL_RETURN);
        TRANSACTION_TYPE_PER_BILLING_TYPE_MAP_PER_KEY.get(TransactionTypeMapKey.CANCEL_WAYBILL).put(BillingTypeEnum.SELLING_RETURN,
                TransactionTypeEnum.CANCEL_SELLING_WAYBILL_RETURN);
        TRANSACTION_TYPE_PER_BILLING_TYPE_MAP_PER_KEY.get(TransactionTypeMapKey.CANCEL_WAYBILL).put(BillingTypeEnum.DAMAGED_BUYING_RETURN,
                TransactionTypeEnum.CANCEL_DAMAGED_BUYING_RETURN_WAYBILL);
        TRANSACTION_TYPE_PER_BILLING_TYPE_MAP_PER_KEY.get(TransactionTypeMapKey.CANCEL_WAYBILL).put(BillingTypeEnum.DAMAGED_SELLING_RETURN,
                TransactionTypeEnum.CANCEL_DAMAGED_SELLING_RETURN_WAYBILL);

        TRANSACTION_TYPE_PER_BILLING_TYPE_MAP_PER_KEY.get(TransactionTypeMapKey.CANCEL_INVOICE).put(BillingTypeEnum.BUYING,
                TransactionTypeEnum.CANCEL_BUYING);
        TRANSACTION_TYPE_PER_BILLING_TYPE_MAP_PER_KEY.get(TransactionTypeMapKey.CANCEL_INVOICE).put(BillingTypeEnum.SELLING,
                TransactionTypeEnum.CANCEL_SELLING);
        TRANSACTION_TYPE_PER_BILLING_TYPE_MAP_PER_KEY.get(TransactionTypeMapKey.CANCEL_INVOICE).put(BillingTypeEnum.BUYING_RETURN,
                TransactionTypeEnum.CANCEL_BUYING_RETURN);
        TRANSACTION_TYPE_PER_BILLING_TYPE_MAP_PER_KEY.get(TransactionTypeMapKey.CANCEL_INVOICE).put(BillingTypeEnum.SELLING_RETURN,
                TransactionTypeEnum.CANCEL_SELLING_RETURN);
        TRANSACTION_TYPE_PER_BILLING_TYPE_MAP_PER_KEY.get(TransactionTypeMapKey.CANCEL_INVOICE).put(BillingTypeEnum.DAMAGED_BUYING_RETURN,
                TransactionTypeEnum.CANCEL_DAMAGED_BUYING_RETURN);
        TRANSACTION_TYPE_PER_BILLING_TYPE_MAP_PER_KEY.get(TransactionTypeMapKey.CANCEL_INVOICE).put(BillingTypeEnum.DAMAGED_SELLING_RETURN,
                TransactionTypeEnum.CANCEL_DAMAGED_SELLING_RETURN);

        TRANSACTION_TYPE_PER_BILLING_TYPE_MAP_PER_KEY.get(TransactionTypeMapKey.SERVICE_INVOICE).put(BillingTypeEnum.BUYING,
                TransactionTypeEnum.BUYING_SERVICE_INVOICE);
        TRANSACTION_TYPE_PER_BILLING_TYPE_MAP_PER_KEY.get(TransactionTypeMapKey.SERVICE_INVOICE).put(BillingTypeEnum.SELLING,
                TransactionTypeEnum.SELLING_SERVICE_INVOICE);

        TRANSACTION_TYPE_PER_BILLING_TYPE_MAP_PER_KEY.get(TransactionTypeMapKey.CANCEL_SERVICE_INVOICE).put(BillingTypeEnum.BUYING_SERVICE,
                TransactionTypeEnum.CANCEL_BUYING_SERVICE_INVOICE);
        TRANSACTION_TYPE_PER_BILLING_TYPE_MAP_PER_KEY.get(TransactionTypeMapKey.CANCEL_SERVICE_INVOICE).put(BillingTypeEnum.SELLING_SERVICE,
                TransactionTypeEnum.CANCEL_SELLING_SERVICE_INVOICE);

    }

    private TransactionTypeHelper() {
    }

    public static boolean isInvoice(TransactionTypeEnum transactionType) {
        return transactionType.getTransactionTypeGroup().equals(TransactionTypeGroup.INVOICE) ||
                transactionType.getTransactionTypeGroup().equals(TransactionTypeGroup.SERVICE_INVOICE);
    }

    public static boolean isWaybill(TransactionTypeEnum transactionType) {
        return transactionType.getTransactionTypeGroup().equals(TransactionTypeGroup.WAYBILL);
    }

    public static boolean isSelling(BillingTypeEnum billingType) {
        return SELLING_BILLING_TYPES.contains(billingType);
    }

    public static boolean isBuyingTransaction(TransactionTypeEnum transactionType) {
        return TransactionTypeHelper.BUYING_PRICE_TRANSACTION_TYPES.contains(transactionType);
    }

    public static boolean shouldCheckStock(BillingTypeEnum billingType) {
        return CHECK_FOR_STOCK_BILLING_TYPES.contains(billingType);
    }

    public static boolean isServiceInvoice(TransactionTypeEnum transactionType) {
        return transactionType.getTransactionTypeGroup().equals(TransactionTypeGroup.SERVICE_INVOICE);
    }

    public static boolean isCampaignApplicableForTransactionType(TransactionTypeEnum transactionType) {
        return CAMPAIGN_APPLICABLE_TRANSACTION_TYPES.contains(transactionType);
    }

    public static TransactionTypeEnum getInvoiceTransactionTypeByOrderType(OrderTypeEnum orderType) {
        return TransactionTypeHelper.INVOICE_TRANSACTION_TYPE_PER_ORDER_TYPE
                .get(orderType);
    }

    public static TransactionTypeEnum getWaybillTransactionTypeByOrderType(OrderTypeEnum orderType) {
        return TransactionTypeHelper.WAYBILL_TRANSACTION_TYPE_PER_ORDER_TYPE
                .get(orderType);
    }

    public static List<TransactionTypeEnum> getTransactionTypesForCampaign(TransactionTypeGroupForCampaign transactionTypeGroupForCampaign) {
        return TransactionTypeHelper.TRANSACTION_TYPE_MAP_FOR_CAMPAIGN
                .get(transactionTypeGroupForCampaign);
    }

    public static boolean hasSellingTransactions(List<TransactionTypeEnum> transactionTypes) {
        return new HashSet<>(transactionTypes).containsAll(TransactionTypeHelper.SELLING_TRANSACTION_TYPES);
    }

    public static boolean hasBuyingTransactions(List<TransactionTypeEnum> transactionTypes) {
        return new HashSet<>(transactionTypes).containsAll(TransactionTypeHelper.BUYING_TRANSACTION_TYPES);
    }

    public static boolean hasReturnTransactions(List<TransactionTypeEnum> transactionTypes) {
        return new HashSet<>(transactionTypes).containsAll(TransactionTypeHelper.RETURN_TRANSACTION_TYPES);
    }
}
