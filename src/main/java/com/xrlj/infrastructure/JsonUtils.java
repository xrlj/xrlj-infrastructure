package com.xrlj.infrastructure;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public final class JsonUtils {

    private JsonUtils(){}

    /**
     * java对象转json对象。
     * @param o
     * @return
     */
    public static JSON fromObject(Object o) {
        String jsonStr = JSON.toJSONString(o);
        return JSON.parseObject(jsonStr);
    }
}
