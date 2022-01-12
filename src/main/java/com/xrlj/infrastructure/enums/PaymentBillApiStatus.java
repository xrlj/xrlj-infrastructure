package com.xrlj.infrastructure.enums;

import javax.persistence.AttributeConverter;

/**
 * 付款单在核心企业系统中的状态
 * @author zmt
 */
public enum PaymentBillApiStatus {

    INITIAL(0, "资产初始化状态"),
    FINANCIAL_CHECKING(1, "金融机构审核中"),
    FINANCIAL_CHECK_SUCCESS(2, "金融机构审核通过"),
    LAW_CHECK_SUCCESS(3, "律所审核通过"),
    APPLY_LOANING(4, "申请放款中"),
    LOANED(5, "已放款"),
    FINANCIAL_CHECK_FAIL(6, "审核失败"), // 出池
    LOANED_FAIL(7, "放款失败");

    private final int status;
    private final String statusName;

    PaymentBillApiStatus(int status, String statusName) {
        this.status = status;
        this.statusName = statusName;
    }

    public static final PaymentBillApiStatus[] all = PaymentBillApiStatus.values();

    public int getStatus() {
        return this.status;
    }

    public String getStatusName() {
        return this.statusName;
    }

    public static String getStatusName(String name) {
        for (PaymentBillApiStatus o : all) {
            if (o.name().equals(name)) {
                return o.statusName;
            }
        }
        return null;
    }

    public static PaymentBillApiStatus getInstance(int status) {
        for (PaymentBillApiStatus o : all) {
            if (o.getStatus() == status) {
                return o;
            }
        }
        return null;
    }

    public static class Converter implements AttributeConverter<PaymentBillApiStatus, Integer> {

        @Override
        public Integer convertToDatabaseColumn(PaymentBillApiStatus o) {
            return o == null ? 0 : o.getStatus();
        }

        @Override
        public PaymentBillApiStatus convertToEntityAttribute(Integer dbData) {
            if (dbData != null) {
                for (PaymentBillApiStatus o : PaymentBillApiStatus.all) {
                    if (o.getStatus() == dbData.intValue()) {
                        return o;
                    }
                }
            }
            return null;
        }
    }
}
