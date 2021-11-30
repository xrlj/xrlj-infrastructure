package com.xrlj.infrastructure.enums;

import javax.persistence.AttributeConverter;

/**
 * 应收应付款数据源枚举。
 * @author zmt
 */
public enum PaymentBillDbSource {

    EXCEL_IMPORT(1, "Excel导入"),
    API_INTERFACE(2, "Api接口");

    private final int status;
    private final String statusName;

    PaymentBillDbSource(int status, String statusName) {
        this.status = status;
        this.statusName = statusName;
    }

    public static final PaymentBillDbSource[] paymentBillDbSources = PaymentBillDbSource.values();

    public int getStatus() {
        return this.status;
    }

    public String getStatusName() {
        return this.statusName;
    }

    public static String getStatusName(String name) {
        for (PaymentBillDbSource paymentBillDbSource : paymentBillDbSources) {
            if (paymentBillDbSource.name().equals(name)) {
                return paymentBillDbSource.statusName;
            }
        }
        return null;
    }

    public static PaymentBillDbSource getInstance(int status) {
        for (PaymentBillDbSource paymentBillDbSource : paymentBillDbSources) {
            if (paymentBillDbSource.getStatus() == status) {
                return paymentBillDbSource;
            }
        }
        return null;
    }

    public static class Converter implements AttributeConverter<PaymentBillDbSource, Integer> {

        @Override
        public Integer convertToDatabaseColumn(PaymentBillDbSource paymentBillDbSource) {
            return paymentBillDbSource == null ? 0 : paymentBillDbSource.getStatus();
        }

        @Override
        public PaymentBillDbSource convertToEntityAttribute(Integer dbData) {
            if (dbData != null) {
                for (PaymentBillDbSource paymentBillDbSource : PaymentBillDbSource.paymentBillDbSources) {
                    if (paymentBillDbSource.getStatus() == dbData.intValue()) {
                        return paymentBillDbSource;
                    }
                }
            }
            return null;
        }
    }
}
