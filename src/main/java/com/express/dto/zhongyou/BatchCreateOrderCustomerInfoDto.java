package com.express.dto.zhongyou;

/**
 * 重邮·批量下单
 * 客户平台信息
 */
public class BatchCreateOrderCustomerInfoDto {

    // 客户编码 线下网点签约时分配
    private String customerCode;

    // 客户订单号 唯一性校验
    private String customerOrderNo;

    // 渠道单号 渠道的单号
    private String platformNo;

    // 仓类型 1-经济仓 2-云仓 3-试用品专仓
    private Integer warehouseType;

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerOrderNo() {
        return customerOrderNo;
    }

    public void setCustomerOrderNo(String customerOrderNo) {
        this.customerOrderNo = customerOrderNo;
    }

    public String getPlatformNo() {
        return platformNo;
    }

    public void setPlatformNo(String platformNo) {
        this.platformNo = platformNo;
    }

    public Integer getWarehouseType() {
        return warehouseType;
    }

    public void setWarehouseType(Integer warehouseType) {
        this.warehouseType = warehouseType;
    }
}
