package com.xrlj.infrastructure;

import com.xrlj.framework.base.BaseEntity;
import com.xrlj.utils.authenticate.JwtUtils;

import java.util.Objects;

public final class TokenUtils {

    private static final String TOKEN_NOT_NULL_MSG = "token不能为null";

    private TokenUtils() {
    }

    public static Long getUserId(String token) {
        Objects.requireNonNull(token, TOKEN_NOT_NULL_MSG);
        Long userId = JwtUtils.getPubClaimValue(token, IConstants.JWT.JWT_CLAIM_KEY_USER_ID, Long.class);
        return userId;
    }

    public static Long getEptId(String token) {
        Objects.requireNonNull(token, TOKEN_NOT_NULL_MSG);
        Long eptId = JwtUtils.getPubClaimValue(token, IConstants.JWT.JWT_CLAIM_KEY_ETP_ID, Long.class);
        return eptId;
    }

    public static String getUsername(String token) {
        Objects.requireNonNull(token, TOKEN_NOT_NULL_MSG);
        String username = JwtUtils.getPubClaimValue(token, IConstants.JWT.JWT_CLAIM_KEY_USERNAME, String.class);
        return username;
    }

    public static int getUserType(String token) {
        Objects.requireNonNull(token, TOKEN_NOT_NULL_MSG);
        int userType = JwtUtils.getPubClaimValue(token, IConstants.JWT.JWT_CLAIM_KEY_USER_TYPE, Integer.class);
        return userType;
    }

    public static int getAppType(String token) {
        Objects.requireNonNull(token);
        int appType = JwtUtils.getPubClaimValue(token, IConstants.JWT.JWT_CLAIM_KEY_APP_TYPE, Integer.class);
        return appType;
    }

    public static String getClientId(String token) {
        Objects.requireNonNull(token, TOKEN_NOT_NULL_MSG);
        String clientId = JwtUtils.getPubClaimValue(token, IConstants.JWT.JWT_CLAIM_KEY_CLIENT_ID, String.class);
        return clientId;
    }

    public static String getClientDeviceType(String token) {
        Objects.requireNonNull(token, TOKEN_NOT_NULL_MSG);
        String clientDeviceType = JwtUtils.getPubClaimValue(token, IConstants.JWT.JWT_CLAIM_KEY_CLIENT_DEVICE_TYPE, String.class);
        return clientDeviceType;
    }

    public static BaseEntity.ClientDeviceType getClientDeviceTypeEnum(String token) {
        Objects.requireNonNull(token, TOKEN_NOT_NULL_MSG);
        String clientDeviceType = JwtUtils.getPubClaimValue(token, IConstants.JWT.JWT_CLAIM_KEY_CLIENT_DEVICE_TYPE, String.class);
        return BaseEntity.ClientDeviceType.getInstance(clientDeviceType);
    }
}
