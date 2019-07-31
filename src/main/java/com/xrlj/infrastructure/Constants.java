package com.xrlj.infrastructure;

public final class Constants {

    public interface JWT {
        String JWT_REDIS_KEY = "jwt:"; //后面加上用户名

        String JWT_ISSUER = "xrlj";
        String JWT_CLAIM_KEY_USERNAME = "username";
        String JWT_CLAIM_KEY_USER_TYPE = "userType";
        String JWT_CLAIM_KEY_USER_ID = "userId";
        String JWT_CLAIM_KEY_CLIENT_ID = "clientid";
    }
}
