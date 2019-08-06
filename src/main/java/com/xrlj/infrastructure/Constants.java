package com.xrlj.infrastructure;

import com.xrlj.utils.authenticate.JwtUtils;

import java.util.Objects;

public final class Constants {

    private static final String TOKEN_NOT_NULL_MSG = "token不能为null";

    public interface JWT {
        String JWT_REDIS_KEY = "jwt:"; //后面加上用户名

        String JWT_ISSUER = "xrlj";
        String JWT_CLAIM_KEY_USERNAME = "username";
        String JWT_CLAIM_KEY_USER_TYPE = "userType";
        String JWT_CLAIM_KEY_USER_ID = "userId";
        String JWT_CLAIM_KEY_CLIENT_ID = "clientid";
        String JWT_CLAIM_KEY_CLIENT_DEVICE_TYPE = "clientDeviceType";
    }

    public static Long getUserId(String token) {
        Objects.requireNonNull(token, TOKEN_NOT_NULL_MSG);
        Long userId = JwtUtils.getPubClaimValue(token, JWT.JWT_CLAIM_KEY_USER_ID, Long.class);
        return userId;
    }

    public static String getUsername(String token) {
        Objects.requireNonNull(token, TOKEN_NOT_NULL_MSG);
        String username = JwtUtils.getPubClaimValue(token, JWT.JWT_CLAIM_KEY_USERNAME, String.class);
        return username;
    }

    public static int getUserType(String token) {
        Objects.requireNonNull(token, TOKEN_NOT_NULL_MSG);
        int userType = JwtUtils.getPubClaimValue(token, JWT.JWT_CLAIM_KEY_USER_TYPE, Integer.class);
        return userType;
    }

    public static String getClientId(String token) {
        Objects.requireNonNull(token, TOKEN_NOT_NULL_MSG);
        String clientId = JwtUtils.getPubClaimValue(token, JWT.JWT_CLAIM_KEY_CLIENT_ID, String.class);
        return clientId;
    }

    public static String getClientDeviceType(String token) {
        Objects.requireNonNull(token, TOKEN_NOT_NULL_MSG);
        String clientDeviceType = JwtUtils.getPubClaimValue(token, JWT.JWT_CLAIM_KEY_CLIENT_DEVICE_TYPE, String.class);
        return clientDeviceType;
    }
}
