package com.xrlj.infrastructure.enums;

import javax.persistence.AttributeConverter;

/**
 * 用户异步任务状态
 * @author zmt
 */
public enum UserAsyncTaskStatus {

    TASK_PROCESSING(1, "执行中"),
    TASK_SUCCESS(2, "任务成功"),
    TASK_FAIL(3, "任务失败");

    private final int status;
    private final String statusName;

    UserAsyncTaskStatus(int status, String statusName) {
        this.status = status;
        this.statusName = statusName;
    }

    public static final UserAsyncTaskStatus[] all = UserAsyncTaskStatus.values();

    public int getStatus() {
        return this.status;
    }

    public String getStatusName() {
        return this.statusName;
    }

    public static String getStatusName(String name) {
        for (UserAsyncTaskStatus o : all) {
            if (o.name().equals(name)) {
                return o.statusName;
            }
        }
        return null;
    }

    public static UserAsyncTaskStatus getInstance(int status) {
        for (UserAsyncTaskStatus o : all) {
            if (o.getStatus() == status) {
                return o;
            }
        }
        return null;
    }

    public static class Converter implements AttributeConverter<UserAsyncTaskStatus, Integer> {

        @Override
        public Integer convertToDatabaseColumn(UserAsyncTaskStatus o) {
            return o == null ? 0 : o.getStatus();
        }

        @Override
        public UserAsyncTaskStatus convertToEntityAttribute(Integer dbData) {
            if (dbData != null) {
                for (UserAsyncTaskStatus o : UserAsyncTaskStatus.all) {
                    if (o.getStatus() == dbData.intValue()) {
                        return o;
                    }
                }
            }
            return null;
        }
    }
}
