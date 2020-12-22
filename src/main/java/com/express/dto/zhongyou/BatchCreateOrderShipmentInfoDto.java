package com.express.dto.zhongyou;

/**
 * 重邮·批量下单·货运信息
 */
public class BatchCreateOrderShipmentInfoDto {

    // 揽件方式 1- 上门揽件（默认）2 - 自送
    private Integer pickupType = 1;

    // 派送方式 1-送货上门（默认）2-自提
    private Integer deliveryType = 1;

    // 期望揽件开始时间 格式:yyyy-MM-dd HH:mm:ss(24H)
    private String expectPickupStartTime;

    // 期望揽件结束时间 格式:yyyy-MM-dd HH:mm:ss(24H)
    private String expectPickupEndTime;

    // 预约送达开始时间 格式:yyyy-MM-dd HH:mm:ss(24H)
    private String expectDeliveryStartTime;

    // 预约送达结束时间 格式:yyyy-MM-dd HH:mm:ss(24H)
    private String expectDeliveryEndTime;

    public Integer getPickupType() {
        return pickupType;
    }

    public void setPickupType(Integer pickupType) {
        this.pickupType = pickupType;
    }

    public Integer getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(Integer deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getExpectPickupStartTime() {
        return expectPickupStartTime;
    }

    public void setExpectPickupStartTime(String expectPickupStartTime) {
        this.expectPickupStartTime = expectPickupStartTime;
    }

    public String getExpectPickupEndTime() {
        return expectPickupEndTime;
    }

    public void setExpectPickupEndTime(String expectPickupEndTime) {
        this.expectPickupEndTime = expectPickupEndTime;
    }

    public String getExpectDeliveryStartTime() {
        return expectDeliveryStartTime;
    }

    public void setExpectDeliveryStartTime(String expectDeliveryStartTime) {
        this.expectDeliveryStartTime = expectDeliveryStartTime;
    }

    public String getExpectDeliveryEndTime() {
        return expectDeliveryEndTime;
    }

    public void setExpectDeliveryEndTime(String expectDeliveryEndTime) {
        this.expectDeliveryEndTime = expectDeliveryEndTime;
    }
}
