package com.xrlj.infrastructure;

import com.xrlj.framework.spring.mvc.api.APIs;
import com.xrlj.framework.spring.mvc.api.ApiException;

import java.util.Objects;

/**
 * 通用的统一api错误提示。
 */
public final class APIsAssert {

    public static void paymentBillGetError() {
        throw APIs.error(APIsErrorStatus.PAYMENT_BILL_GET_ERROR.status(), APIsErrorStatus.PAYMENT_BILL_GET_ERROR.msg(), null);
    }

    public static ApiException getThirdOpenApiConfFail() {
        throw APIs.error(APIsErrorStatus.THIRD_OPEN_API_CONF_FAIL.status(), APIsErrorStatus.THIRD_OPEN_API_CONF_FAIL.msg(), null);
    }

    public static ApiException captChaError() {
        throw APIs.error(APIsErrorStatus.CAPTCHA_ERROR.status(), APIsErrorStatus.CAPTCHA_ERROR.msg(), null);
    }

    public static ApiException notExitRecord(Long id) {
        throw APIs.error(APIsErrorStatus.RECORD_NOT_EXIST.status(), id != null ? String.format(APIsErrorStatus.RECORD_NOT_EXIST.msg(), id) : "记录不存在", null);
    }

    public static ApiException unknownError() {
        throw APIs.error(APIsErrorStatus.UN_KNOWN.status(), APIsErrorStatus.UN_KNOWN.msg(), null);
    }

    public static ApiException smsAuthCodeEqNot() {
        throw APIs.error(APIsErrorStatus.SMS_AUTH_CODE_EQ_NOT.status(), APIsErrorStatus.SMS_AUTH_CODE_EQ_NOT.msg(), null);
    }

    public static ApiException smsAuthCodeExpired() {
        throw APIs.error(APIsErrorStatus.SMS_AUTH_CODE_EXPIRED.status(), APIsErrorStatus.SMS_AUTH_CODE_EXPIRED.msg(), null);
    }

    public static ApiException smsAuthCodeError() {
        throw APIs.error(APIsErrorStatus.SMS_AUTH_CODE_ERROR.status(), APIsErrorStatus.SMS_AUTH_CODE_ERROR.msg(), null);
    }

    public static ApiException fieldNotFind(String fieldName) {
        throw APIs.error(APIsErrorStatus.FIELD_NOT_FIND.status(), String.format(APIsErrorStatus.FIELD_NOT_FIND.msg(), fieldName), null);
    }

    public static void fieldNotNull(Object field, String filedName) {
        if (field != null && field instanceof String && !"".equals(field)) {
            return;
        }

        if (field != null) {
            return;
        }

        throw APIs.error(APIsErrorStatus.FIELD_NOT_NULL.status(), String.format(APIsErrorStatus.FIELD_NOT_NULL.msg(), filedName), null);
    }

    public static ApiException appNotFind() {
        throw APIs.error(APIsErrorStatus.APP_NOT_FIND.status(), APIsErrorStatus.APP_NOT_FIND.msg(), null);
    }

    public static ApiException appNotFindOrCheck() {
        throw APIs.error(APIsErrorStatus.APP_NOT_FIND_OR_CHECK.status(), APIsErrorStatus.APP_NOT_FIND_OR_CHECK.msg(), null);
    }

    public static ApiException loginError() {
        throw APIs.error(APIsErrorStatus.LOGIN_USERNAME_OR_PWD_ERROR.status(), APIsErrorStatus.LOGIN_USERNAME_OR_PWD_ERROR.msg(), null);
    }

    public static ApiException fileNotFind() {
        throw APIs.error(APIsErrorStatus.FILE_NOT_FIND.status(), APIsErrorStatus.FILE_NOT_FIND.msg(), null);
    }

    public static ApiException fileUploadError() {
        throw APIs.error(APIsErrorStatus.FILE_UPLOAD_ERROR.status(), APIsErrorStatus.FILE_UPLOAD_ERROR.msg(), null);
    }

    public static ApiException clientRequestFailError() {
        throw APIs.error(APIsErrorStatus.CLIENT_REQUEST_FAIL.status(), APIsErrorStatus.CLIENT_REQUEST_FAIL.msg(), null);
    }

    public static ApiException authorizationNotSupport() {
        throw APIs.error(APIsErrorStatus.AUTHORIZATION_NOT_SUPPORT.status(), APIsErrorStatus.AUTHORIZATION_NOT_SUPPORT.msg(), null);
    }
}
