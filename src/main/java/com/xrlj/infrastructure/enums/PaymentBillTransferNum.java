package com.xrlj.infrastructure.enums;

import javax.persistence.AttributeConverter;

/**
 * 应收应付款在系统中转让次数
 * @author zmt
 */
public enum PaymentBillTransferNum {

    ONE_TRANSFER(1, "一次转让"),
    TWO_TRANSFER(2, "二次转让"),
    NONE_TRANSFER(3, "无");

    private final int status;
    private final String statusName;

    PaymentBillTransferNum(int status, String statusName) {
        this.status = status;
        this.statusName = statusName;
    }

    public String getStatusName() {
        return this.statusName;
    }

    public int getStatus() {
        return this.status;
    }

    public static final PaymentBillTransferNum[] productStagingStatuses = PaymentBillTransferNum.values();

    public static PaymentBillTransferNum getInstance(int status) {
        for (PaymentBillTransferNum productStagingStatus : productStagingStatuses) {
            if (productStagingStatus.getStatus() == status) {
                return productStagingStatus;
            }
        }
        return null;

    }

    public static class Converter implements AttributeConverter<PaymentBillTransferNum, Integer> {

        @Override
        public Integer convertToDatabaseColumn(PaymentBillTransferNum productStagingStatus) {
            if (productStagingStatus == null)
                return 0;
            else
                return productStagingStatus.getStatus();
        }

        @Override
        public PaymentBillTransferNum convertToEntityAttribute(Integer dbData) {
            if (dbData != null) {
                for (PaymentBillTransferNum checkStatus : PaymentBillTransferNum.productStagingStatuses) {
                    if (checkStatus.getStatus() == dbData.intValue()) {
                        return checkStatus;
                    }
                }
            }
            return null;
        }
    }
}
