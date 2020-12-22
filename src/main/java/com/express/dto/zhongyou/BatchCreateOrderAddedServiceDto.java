package com.express.dto.zhongyou;

/**
 * 重邮·批量下单·增值服务
 * addedService
 */
public class BatchCreateOrderAddedServiceDto {

    // 增值服务编码  代收货款：ZY_DSHK 保价服务：ZY_BJFW
    private String serviceCode;

    // 增值服务值
    private String serviceValue;

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getServiceValue() {
        return serviceValue;
    }

    public void setServiceValue(String serviceValue) {
        this.serviceValue = serviceValue;
    }
}
