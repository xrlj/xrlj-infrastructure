package com.xrlj.infrastructure;

import org.springframework.lang.Nullable;

/**
 * 全系统共用的业务提醒状态。
 */
public enum APIsErrorStatus {

    UN_KNOWN(500, "未知错误"),
    APP_NOT_FIND(2000, "应用程序未注册"),
    APP_NOT_CHECK(2001, "应用程序未审核通过"),
    APP_NOT_FIND_OR_CHECK(2002, "应用程序未注册或未审核"),
    FIELD_NOT_FIND(2003, "缺少必传参数%s"),
    FIELD_NOT_NULL(2004, "必传参数[%s]非空"),
    RECORD_NOT_EXIST(2005, "记录[%d]不存在"),
    LOGIN_USERNAME_OR_PWD_ERROR(2010, "登录名或密码错误"),
    FILE_NOT_FIND(2015, "文件不存在"),
    FILE_UPLOAD_ERROR(2016, "上传文件失败"),
    SMS_AUTH_CODE_ERROR(2017, "短信验证码已发送,请勿重复操作"),
    SMS_AUTH_CODE_EXPIRED(2018, "短信验证码已过期"),
    SMS_AUTH_CODE_EQ_NOT(2019, "短信验证码错误"),
    CLIENT_REQUEST_FAIL(3000, "服务请求失败，稍后再试！"),
    CAPTCHA_ERROR(3600, "图形验证码错误，或已失效"),
    THIRD_OPEN_API_CONF_FAIL(20001, "无法获取第三方开放接口配置信息"),
    PAYMENT_BILL_GET_ERROR(20301, "获取付款单信息失败"),
    AUTHORIZATION_NOT_SUPPORT(403, "没有访问权限");

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
