package com.xrlj.infrastructure;

import com.xrlj.utils.security.Base64Utils;
import com.xrlj.utils.security.Md5Utils;

public class IConstants {

    public interface JWT {
        String JWT_REDIS_KEY_PREFIX = "jwt:"; //后面加上用户名

        String JWT_ISSUER = "xrlj";
        String JWT_CLAIM_KEY_USERNAME = "username";
        String JWT_CLAIM_KEY_USER_TYPE = "userType";
        String JWT_CLAIM_KEY_USER_ID = "userId";
        String JWT_CLAIM_KEY_ETP_ID = "etpId"; // 企业id
//        String JWT_CLAIM_KEY_CLIENT_ID = "clientid";
//        String JWT_CLAIM_KEY_CLIENT_DEVICE_TYPE = "clientDeviceType";
        String JWT_CLAIM_KEY_APP_TYPE = "appType";
        String JWT_KEY = "jwt-key";

        static String jwtRedisKey(String username, String password) {
            String jwt_redis_key = JWT_REDIS_KEY_PREFIX.concat(Md5Utils.getCCMD5Str(username+password));
            return jwt_redis_key;
        }

        static String appSecretKey(String clientid) {
            String app_secret_key = new StringBuilder("app:secret:").append(clientid).toString();
            return app_secret_key;
        }
    }
}
