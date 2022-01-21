package com.xrlj.infrastructure.enums;

import javax.persistence.AttributeConverter;

/**
 * 用户导入异步任务类型
 * @author zmt
 */
public enum UserAsyncImportTaskType {

    IMPORT_PB_API(1, "接口导入付款单"),
    IMPORT_PB_EXCEL(2, "EXCEL导入付款单");

    private final int status;
    private final String statusName;

    UserAsyncImportTaskType(int status, String statusName) {
        this.status = status;
        this.statusName = statusName;
    }

    public static final UserAsyncImportTaskType[] all = UserAsyncImportTaskType.values();

    public int getStatus() {
        return this.status;
    }

    public String getStatusName() {
        return this.statusName;
    }

    public static String getStatusName(String name) {
        for (UserAsyncImportTaskType o : all) {
            if (o.name().equals(name)) {
                return o.statusName;
            }
        }
        return null;
    }

    public static UserAsyncImportTaskType getInstance(int status) {
        for (UserAsyncImportTaskType o : all) {
            if (o.getStatus() == status) {
                return o;
            }
        }
        return null;
    }

    public static class Converter implements AttributeConverter<UserAsyncImportTaskType, Integer> {

        @Override
        public Integer convertToDatabaseColumn(UserAsyncImportTaskType o) {
            return o == null ? 0 : o.getStatus();
        }

        @Override
        public UserAsyncImportTaskType convertToEntityAttribute(Integer dbData) {
            if (dbData != null) {
                for (UserAsyncImportTaskType o : UserAsyncImportTaskType.all) {
                    if (o.getStatus() == dbData.intValue()) {
                        return o;
                    }
                }
            }
            return null;
        }
    }
}
