package com.express.dto.zhongyou;

/**
 * 重邮
 */
public class CommonParam {

    /**
     * 系统code 众邮系统分配(上线前向对接人获取)
     */
    private String appCode;

    /**
     * 系统来源 上游订单来源
     */
    private String source;

    /**
     * 商家授权码 客户自己在oms系统中获取
     */
    private String token;

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
