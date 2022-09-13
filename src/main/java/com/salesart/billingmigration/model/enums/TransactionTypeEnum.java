package com.salesart.billingmigration.model.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
public enum TransactionTypeEnum {

    BUYING(1, TransactionTypeGroup.INVOICE, "Alım Faturası", 1, 0, -1, TransactionBalanceTypeEnum.CREDIT, true, -1, -1),
    SELLING(2, TransactionTypeGroup.INVOICE, "Satış  Faturası", -1, -1, 0, TransactionBalanceTypeEnum.DEBIT, true, 1, 1),

    BUYING_RETURN(3, TransactionTypeGroup.INVOICE, "Alım İade Faturası", -1, 0, 0, TransactionBalanceTypeEnum.DEBIT, true, 1, 1),
    SELLING_RETURN(4, TransactionTypeGroup.INVOICE, "Satış İade Faturası", 1, 0, 0, TransactionBalanceTypeEnum.CREDIT, true, -1, -1),

    BUYING_WAYBILL(5, TransactionTypeGroup.WAYBILL, "Alım İrsaliyesi", 1, 0, -1, TransactionBalanceTypeEnum.NONE, true, 0, -1),
    SELLING_WAYBILL(6, TransactionTypeGroup.WAYBILL, "Satış  İrsaliyesi", -1, -1, 0, TransactionBalanceTypeEnum.NONE, true, 0, 1),

    BUYING_RETURN_WAYBILL(7, TransactionTypeGroup.WAYBILL, "Alım İade İrsaliyesi", -1, 0, 0,
            TransactionBalanceTypeEnum.NONE, true, 0, 1),
    SELLING_RETURN_WAYBILL(8, TransactionTypeGroup.WAYBILL, "Satış İade İrsaliyesi", 1, 0, 0,
            TransactionBalanceTypeEnum.NONE, true, 0, -1),

    WAREHOUSE_OPENING_VOUCHER(9, TransactionTypeGroup.VOUCHER, "Depo Açılış Fişi", 1, 0, 0,
            TransactionBalanceTypeEnum.NONE, true, 0, 0),
    WAREHOUSE_LACK_OF_COUNT(10, TransactionTypeGroup.VOUCHER, "Depo Sayım Eksiği Fişi", -1, 0, 0,
            TransactionBalanceTypeEnum.NONE, true, 0, 0),
    WAREHOUSE_SURPLUS(11, TransactionTypeGroup.VOUCHER, "Depo Sayım Fazlası Fişi", 1, 0, 0,
            TransactionBalanceTypeEnum.NONE, true, 0, 0),
    WAREHOUSE_INCOMING_VOUCHER(12, TransactionTypeGroup.VOUCHER, "Depo Giriş Fişi", 1, 0, 0,
            TransactionBalanceTypeEnum.NONE, true, 0, 0),
    WAREHOUSE_OUTGOING_VOUCHER(13, TransactionTypeGroup.VOUCHER, "Depo Çıkış Fişi", -1, 0, 0,
            TransactionBalanceTypeEnum.NONE, true, 0, 0),
    WAREHOUSE_OUTGOING_TRANSFER_VOUCHER(14, TransactionTypeGroup.VOUCHER, "Depolar Arası Transfer - Giden Fişi", -1,
            0, 0, TransactionBalanceTypeEnum.NONE, true, 0, 0),
    WAREHOUSE_INCOMING_TRANSFER_VOUCHER(15, TransactionTypeGroup.VOUCHER, "Depolar Arası Transfer - Gelen Fişi", 1, 0
            , 0, TransactionBalanceTypeEnum.NONE, true, 0, 0),

    BUYING_ORDER(16, TransactionTypeGroup.ORDER, "Alım Siparişi", 0, 0, 1, TransactionBalanceTypeEnum.NONE, true, 0, 0),
    SELLING_ORDER(17, TransactionTypeGroup.ORDER, "Satış Siparişi", 0, 1, 0, TransactionBalanceTypeEnum.NONE, true, 0, 0),
    COLLECTION(18, TransactionTypeGroup.COLLECTION, "Tahsilat", 0, 0, 0, TransactionBalanceTypeEnum.CREDIT, true, 0, 0),

    DAMAGED_BUYING_RETURN_WAYBILL(19, TransactionTypeGroup.WAYBILL, "Hasarlı Alım İade İrsaliyesi", -1, 0, 0,
            TransactionBalanceTypeEnum.NONE, true, 0, 1),
    DAMAGED_SELLING_RETURN_WAYBILL(20, TransactionTypeGroup.WAYBILL, "Hasarlı Satış İade İrsaliyesi", 1, 0, 0,
            TransactionBalanceTypeEnum.NONE, true, 0, -1),

    CANCEL_SELLING(21, TransactionTypeGroup.INVOICE, "Satış Faturası İptali", 1, 1, 0,
            TransactionBalanceTypeEnum.CREDIT, true, -1, -1),
    CANCEL_SELLING_WAYBILL(22, TransactionTypeGroup.WAYBILL, "Satış İrsaliyesi İptali", 1, 1, 0,
            TransactionBalanceTypeEnum.NONE, true, 0, -1),

    BUYING_SERVICE_INVOICE(23, TransactionTypeGroup.SERVICE_INVOICE, "Alınan Hizmet Faturası", 0, 0, 0,
            TransactionBalanceTypeEnum.CREDIT, true, -1, -1),
    SELLING_SERVICE_INVOICE(24, TransactionTypeGroup.SERVICE_INVOICE, "Verilen Hizmet Faturası", 0, 0, 0,
            TransactionBalanceTypeEnum.DEBIT, true, 1, 1),
    CANCEL_BUYING_SERVICE_INVOICE(25, TransactionTypeGroup.SERVICE_INVOICE, "Alınan Hizmet Faturası İptali", 0, 0, 0,
            TransactionBalanceTypeEnum.DEBIT, true, 1, 1),
    CANCEL_SELLING_SERVICE_INVOICE(26, TransactionTypeGroup.SERVICE_INVOICE, "Verilen Hizmet Faturası İptali", 0, 0, 0,
            TransactionBalanceTypeEnum.CREDIT, true, -1, -1),


    MANUAL_BUYING(27, TransactionTypeGroup.INVOICE, "Alım Faturası", 1, 0, 0,
            TransactionBalanceTypeEnum.CREDIT, true,0,0),
    MANUAL_SELLING(28, TransactionTypeGroup.INVOICE, "Satış  Faturası", -1, 0, 0,
            TransactionBalanceTypeEnum.DEBIT, true,0,0),
    MANUAL_BUYING_WAYBILL(29, TransactionTypeGroup.WAYBILL, "Alım İrsaliyesi", 1, 0, 0,
            TransactionBalanceTypeEnum.NONE, true,0,0),
    MANUAL_SELLING_WAYBILL(30, TransactionTypeGroup.WAYBILL, "Satış  İrsaliyesi", -1, 0, 0,
            TransactionBalanceTypeEnum.NONE, true,0,0),

    CANCEL_MANUAL_BUYING(31, TransactionTypeGroup.INVOICE, "Alım Faturası İptali", -1, 0, 0,
            TransactionBalanceTypeEnum.DEBIT, true,0,0),
    CANCEL_MANUAL_SELLING(32, TransactionTypeGroup.INVOICE, "Satış  Faturası İptali", 1, 0, 0,
            TransactionBalanceTypeEnum.CREDIT, true,0,0),
    CANCEL_MANUAL_BUYING_WAYBILL(33, TransactionTypeGroup.WAYBILL, "Alım İrsaliyesi İptali", -1, 0, 0,
            TransactionBalanceTypeEnum.NONE, true,0,0),
    CANCEL_MANUAL_SELLING_WAYBILL(34, TransactionTypeGroup.WAYBILL, "Satış  İrsaliyesi İptali", 1, 0, 0,
            TransactionBalanceTypeEnum.NONE, true,0,0),

    MANUAL_COLLECTION_CREDIT(35, TransactionTypeGroup.COLLECTION, "Müşteri Bakiyesi Düzenleme - Bakiye Azaltma", 0, 0
            , 0, TransactionBalanceTypeEnum.CREDIT, false,0,0),
    MANUAL_COLLECTION_DEBIT(36, TransactionTypeGroup.COLLECTION, "Müşteri Bakiyesi Düzenleme - Bakiye Arttırma", 0, 0
            , 0, TransactionBalanceTypeEnum.DEBIT, false,0,0),

    WAREHOUSE_TRANSFER_VOUCHER(37, TransactionTypeGroup.VOUCHER, "Depolar Arası Transfer", 0, 0, 0,
            TransactionBalanceTypeEnum.NONE, true, 0, 0),

    DAMAGED_BUYING_RETURN(38, TransactionTypeGroup.INVOICE, "Hasarlı Alım İade Faturası", -1, 0, 0,
            TransactionBalanceTypeEnum.DEBIT, true, 1, 1),
    DAMAGED_SELLING_RETURN(39, TransactionTypeGroup.INVOICE, "Hasarlı Satış İade Faturası", 1, 0, 0,
            TransactionBalanceTypeEnum.CREDIT, true, -1, -1),

    CANCEL_BUYING(40, TransactionTypeGroup.INVOICE, "Alım Faturası İptali", -1, 0, 0, TransactionBalanceTypeEnum.DEBIT, true, 1, 1),
    CANCEL_BUYING_WAYBILL(41, TransactionTypeGroup.WAYBILL, "Alım İrsaliyesi İptali", -1, 0, 0,
            TransactionBalanceTypeEnum.NONE, true, 0, 1),

    CANCEL_BUYING_RETURN(42, TransactionTypeGroup.INVOICE, "Alım İade Faturası İptali", 1, 0, 0,
            TransactionBalanceTypeEnum.CREDIT, true, -1, -1),
    CANCEL_BUYING_WAYBILL_RETURN(43, TransactionTypeGroup.WAYBILL, "Alım İade İrsaliyesi İptali", 1, 0, 0,
            TransactionBalanceTypeEnum.NONE, true, 0, -1),

    CANCEL_SELLING_RETURN(44, TransactionTypeGroup.INVOICE, "Satış İade Faturası İptali", -1, 0, 0,
            TransactionBalanceTypeEnum.DEBIT, true, 1, 1),
    CANCEL_SELLING_WAYBILL_RETURN(45, TransactionTypeGroup.WAYBILL, "Satış İade İrsaliyesi İptali", -1, 0, 0,
            TransactionBalanceTypeEnum.NONE, true, 0, 1),

    CANCEL_DAMAGED_BUYING_RETURN_WAYBILL(46, TransactionTypeGroup.WAYBILL, "Hasarlı Alım İade İrsaliyesi İptali", 1,
            0, 0, TransactionBalanceTypeEnum.NONE, true, 0, -1),
    CANCEL_DAMAGED_SELLING_RETURN_WAYBILL(47, TransactionTypeGroup.WAYBILL, "Hasarlı Satış İade İrsaliyesi İptali",
            -1, 0, 0, TransactionBalanceTypeEnum.NONE, true, 0, 1),

    CANCEL_DAMAGED_BUYING_RETURN(48, TransactionTypeGroup.INVOICE, "Hasarlı Alım İade Faturası İptali", 1,
            0, 0, TransactionBalanceTypeEnum.CREDIT, true, -1, -1),
    CANCEL_DAMAGED_SELLING_RETURN(49, TransactionTypeGroup.INVOICE, "Hasarlı Satış İade Faturası İptali",
            -1, 0, 0, TransactionBalanceTypeEnum.DEBIT, true, 1, 1),
    INCREASE_EDIT_BUYING_ORDER(50, TransactionTypeGroup.ORDER, "Alım Siparişi Düzenleme Stok Artışı", 0, 0, 1,
            TransactionBalanceTypeEnum.NONE, false,0,0),
    DECREASE_EDIT_BUYING_ORDER(51, TransactionTypeGroup.ORDER, "Alım Siparişi Düzenleme Stok Azalışı", 0, 0, -1,
            TransactionBalanceTypeEnum.NONE, false,0,0),
    INCREASE_EDIT_SELLING_ORDER(52, TransactionTypeGroup.ORDER, "Satış Siparişi Düzenleme Stok Artışı", 0, 1, 0,
            TransactionBalanceTypeEnum.NONE, false,0,0),
    DECREASE_EDIT_SELLING_ORDER(53, TransactionTypeGroup.ORDER, "Satış Siparişi Düzenleme Stok Azalışı", 0, -1, 0,
            TransactionBalanceTypeEnum.NONE, false,0,0),
    CANCEL_BUYING_ORDER(54, TransactionTypeGroup.ORDER, "Alım Siparişi İptali", 0, 0, -1,
            TransactionBalanceTypeEnum.NONE, true,0,0),
    CANCEL_SELLING_ORDER(55, TransactionTypeGroup.ORDER, "Satış Siparişi İptali ", 0, -1, 0,
            TransactionBalanceTypeEnum.NONE, true,0,0),

    ROLLBACK_CANCEL_SELLING(56, TransactionTypeGroup.INVOICE, "Satış Faturası İptalinin Geri Alınması", 0, 0,
            0, TransactionBalanceTypeEnum.NONE, false,0,0),

    VEHICLE_LOADING_VOUCHER(57, TransactionTypeGroup.VOUCHER, "Araç Yükleme Fişi", 0, 0, 0,
            TransactionBalanceTypeEnum.NONE, true,0,0),

    VEHICLE_UNLOADING_VOUCHER(58, TransactionTypeGroup.VOUCHER, "Araç İndirme Fişi", 0, 0, 0,
            TransactionBalanceTypeEnum.NONE, true,0,0),

    VEHICLE_WAREHOUSE_TRANSFER_VOUCHER(59, TransactionTypeGroup.VOUCHER, "Araç Depoları Arası Transfer", 0, 0, 0,
            TransactionBalanceTypeEnum.NONE, true,0,0),

    VEHICLE_WAREHOUSE_OUTGOING_TRANSFER_VOUCHER(60, TransactionTypeGroup.VOUCHER, "Araç Depoları Arası Transfer - Giden Fişi", -1,
            0, 0, TransactionBalanceTypeEnum.NONE, true,0,0),

    VEHICLE_WAREHOUSE_INCOMING_TRANSFER_VOUCHER(61, TransactionTypeGroup.VOUCHER, "Araç Depoları Arası Transfer - Gelen Fişi", 1, 0
            , 0, TransactionBalanceTypeEnum.NONE, true,0,0),

    CASH_COLLECTION(62, TransactionTypeGroup.COLLECTION, "Nakit Tahsilat", 0, 0, 0,
            TransactionBalanceTypeEnum.CREDIT, true,-1,-1),


    CREDIT_CARD_COLLECTION(62, TransactionTypeGroup.COLLECTION, "Kredi Kartı Tahsilatı", 0, 0, 0,
            TransactionBalanceTypeEnum.CREDIT, true,-1,-1),


    CHECK_COLLECTION(62, TransactionTypeGroup.COLLECTION, "Çek Tahsilatı", 0, 0, 0,
            TransactionBalanceTypeEnum.CREDIT, true,-1,-1),


    BOND_COLLECTION(62, TransactionTypeGroup.COLLECTION, "Senet Tahsilatı", 0, 0, 0,
            TransactionBalanceTypeEnum.CREDIT, true,-1,-1),


    BANK_TRANSFER_COLLECTION(62, TransactionTypeGroup.COLLECTION, "Banka Havale/EFT Tahsilatı", 0, 0, 0,
            TransactionBalanceTypeEnum.CREDIT, true,-1,-1),

    CASH_PAYMENT(63,TransactionTypeGroup.PAYMENT,"Nakit Ödeme",0,0,0,
            TransactionBalanceTypeEnum.DEBIT,true,1,1),


    CREDIT_CARD_PAYMENT(64,TransactionTypeGroup.PAYMENT,"Kredi Kartı Ödemesi",0,0,0,
            TransactionBalanceTypeEnum.DEBIT,true,1,1),


    CHECK_PAYMENT(65,TransactionTypeGroup.PAYMENT,"Çek Ödemesi",0,0,0,
            TransactionBalanceTypeEnum.DEBIT,true,1,1),


    BOND_PAYMENT(66,TransactionTypeGroup.PAYMENT,"Senet Ödemesi",0,0,0,
            TransactionBalanceTypeEnum.DEBIT,true,1,1),


    BANK_TRANSFER_PAYMENT(67,TransactionTypeGroup.PAYMENT,"Banka Havale/EFT Ödemesi",0,0,0,
            TransactionBalanceTypeEnum.DEBIT,true,1,1);

    private Integer id;
    private TransactionTypeGroup transactionTypeGroup;
    private String name;
    private Integer stockFactor;
    private Integer pendingCustomerStockFactor;
    private Integer pendingProviderStockFactor;
    private TransactionBalanceTypeEnum transactionBalanceType;
    private boolean requirePermission;
    private Integer balanceEfect;
    private Integer riskEfect;


    TransactionTypeEnum(Integer id,
                        TransactionTypeGroup transactionTypeGroup,
                        String name,
                        Integer stockFactor,
                        Integer pendingCustomerStockFactor,
                        Integer pendingProviderStockFactor,
                        TransactionBalanceTypeEnum transactionBalanceType,
                        boolean requirePermission,
                        Integer balanceEfect,
                        Integer riskEfect
    ) {
        this.id = id;
        this.transactionTypeGroup = transactionTypeGroup;
        this.name = name;
        this.stockFactor = stockFactor;
        this.transactionBalanceType = transactionBalanceType;
        this.pendingCustomerStockFactor = pendingCustomerStockFactor;
        this.pendingProviderStockFactor = pendingProviderStockFactor;
        this.requirePermission = requirePermission;
        this.balanceEfect = balanceEfect;
        this.riskEfect = riskEfect;

    }

    @Deprecated
    public static boolean isEligibleToWriteStockTransaction(TransactionTypeEnum transactionTypeEnum) {
        return !transactionTypeEnum.getStockFactor().equals(0) ||
                !transactionTypeEnum.getPendingCustomerStockFactor().equals(0) ||
                !transactionTypeEnum.getPendingProviderStockFactor().equals(0);
    }

    public boolean isEligibleToWriteStockTransaction() {
        return !stockFactor.equals(0) || !pendingCustomerStockFactor.equals(0) || !pendingProviderStockFactor.equals(0);
    }

    public boolean isEligibleToWriteBalanceTransaction() {
        return !TransactionBalanceTypeEnum.NONE.equals(getTransactionBalanceType());
    }

    public static TransactionTypeEnum findById(Integer id) {
        Optional<TransactionTypeEnum> transactionTypeEnum = Arrays.stream(values())
                .filter(tte -> tte.getId().equals(id)).findAny();
        return transactionTypeEnum.orElseThrow(UnsupportedOperationException::new);
    }

    public static List<TransactionTypeEnum> getDebitTransactionTypes(){
        return Arrays.stream(values()).filter(tte -> tte.getTransactionBalanceType().equals(TransactionBalanceTypeEnum.DEBIT)).collect(Collectors.toList());
    }

    public static List<TransactionTypeEnum> getCreditTransactionTypes(){
        return Arrays.stream(values()).filter(tte -> tte.getTransactionBalanceType().equals(TransactionBalanceTypeEnum.CREDIT)).collect(Collectors.toList());
    }
}
