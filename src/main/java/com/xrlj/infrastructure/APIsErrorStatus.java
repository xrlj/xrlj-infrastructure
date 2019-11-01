package com.xrlj.infrastructure;

import org.springframework.lang.Nullable;

/**
 * 全系统共用的业务提醒状态。
 */
public enum APIsErrorStatus {

    APP_NOT_FIND(2000, "应用程序未注册"),
    APP_NOT_CHECK(2001, "应用程序未审核通过"),
    APP_NOT_FIND_OR_CHECK(2002, "应用程序未注册或未审核"),
    LOGIN_USERNAME_OR_PWD_ERROR(2010, "用户名或者密码错误"),
    FILE_NOT_FIND(2015, "文件不存在"),
    FILE_UPLOAD_ERROR(2016, "上传文件失败");

    private final int status;
    private final String msg;

    APIsErrorStatus(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public int status() {
        return status;
    }

    public String msg() {
        return msg;
    }

    public static APIsErrorStatus valueOf(int statusCode) {
        APIsErrorStatus apIsErrorStatus = resolve(statusCode);
        if (apIsErrorStatus == null) {
            throw new IllegalArgumentException("No matching constant for [" + statusCode + "]");
        } else {
            return apIsErrorStatus;
        }
    }

    @Nullable
    public static APIsErrorStatus resolve(int statusCode) {
        APIsErrorStatus[] apIsErrorStatuses = values();
        int size = apIsErrorStatuses.length;

        for (int i = 0; i < size; i++) {
            APIsErrorStatus apIsErrorStatus = apIsErrorStatuses[i];
            if (apIsErrorStatus.status == statusCode) {
                return apIsErrorStatus;
            }
        }

        return null;
    }
}
