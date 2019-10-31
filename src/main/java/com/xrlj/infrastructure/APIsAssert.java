package com.xrlj.infrastructure;

import com.xrlj.framework.spring.mvc.api.APIs;
import com.xrlj.framework.spring.mvc.api.ApiException;

/**
 * 通用的统一api错误提示。
 */
public final class APIsAssert {

    public static ApiException appNotFind() {
        throw APIs.error(APIsErrorStatus.APP_NOT_FIND.status(),APIsErrorStatus.APP_NOT_FIND.msg(), null);
    }

    public static ApiException appNotFindOrCheck() {
        throw APIs.error(APIsErrorStatus.APP_NOT_FIND_OR_CHECK.status(),APIsErrorStatus.APP_NOT_FIND_OR_CHECK.msg(), null);
    }

    public static ApiException loginError() {
        throw APIs.error(APIsErrorStatus.LOGIN_USERNAME_OR_PWD_ERROR.status(),APIsErrorStatus.LOGIN_USERNAME_OR_PWD_ERROR.msg(), null);
    }
}
