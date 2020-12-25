package com.express.util;

import java.util.HashMap;
import java.util.Map;

/**
 * token返回数据
 *
 * @author Rock
 * @email cool_fish@aliyun.com
 * @date 2020-12-25
 */
public class Response extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;

    /**
     * 空参构造
     */
    public Response() {
        put("status", "200").put("result","success");
    }
    public static Response error() {
        return error("500", "作業失敗，服務器發生例外錯誤");
    }

    public static Response error(String msg) {
        return error("500", msg);
    }

    public static Response error(String code, String msg) {
        Response r = new Response();
        r.put("status", code);
        r.put("result", msg);
        return r;
    }
    public static Response ok(String msg) {
        Response r = new Response();
        r.put("result", msg);
        return r;
    }

    public static Response ok(Map<String, Object> map) {
        Response r = new Response();
        r.putAll(map);
        return r;
    }

    @Override
    public Response put(String key, Object value) {
        super.put(key, value);
        return this;
    }

}
