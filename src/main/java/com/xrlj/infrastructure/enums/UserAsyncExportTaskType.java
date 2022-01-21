package com.xrlj.infrastructure.enums;

import javax.persistence.AttributeConverter;

/**
 * 用户导出异步任务类型
 * @author zmt
 */
public enum UserAsyncExportTaskType {

    DOWNLOAD_PB_FILE_SINGLE(1, "下载单条付款单附件");

    private final int status;
    private final String statusName;

    UserAsyncExportTaskType(int status, String statusName) {
        this.status = status;
        this.statusName = statusName;
    }

    public static final UserAsyncExportTaskType[] all = UserAsyncExportTaskType.values();

    public int getStatus() {
        return this.status;
    }

    public String getStatusName() {
        return this.statusName;
    }

    public static String getStatusName(String name) {
        for (UserAsyncExportTaskType o : all) {
            if (o.name().equals(name)) {
                return o.statusName;
            }
        }
        return null;
    }

    public static UserAsyncExportTaskType getInstance(int status) {
        for (UserAsyncExportTaskType o : all) {
            if (o.getStatus() == status) {
                return o;
            }
        }
        return null;
    }

    public static class Converter implements AttributeConverter<UserAsyncExportTaskType, Integer> {

        @Override
        public Integer convertToDatabaseColumn(UserAsyncExportTaskType o) {
            return o == null ? 0 : o.getStatus();
        }

        @Override
        public UserAsyncExportTaskType convertToEntityAttribute(Integer dbData) {
            if (dbData != null) {
                for (UserAsyncExportTaskType o : UserAsyncExportTaskType.all) {
                    if (o.getStatus() == dbData.intValue()) {
                        return o;
                    }
                }
            }
            return null;
        }
    }
}
