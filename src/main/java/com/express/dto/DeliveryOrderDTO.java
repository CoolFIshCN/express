package com.express.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 *  外部传入发货单
 */
public class DeliveryOrderDTO {
    private  String customerCode;
    private  String customerOrderNo;
    private  String platformNo;
    private  Integer warehouseType;
    private  Integer consignCount;
    private  String consignWare;
    private  Integer consignType;
    private  BigDecimal length;
    private  BigDecimal width;
    private  BigDecimal height;
    private  BigDecimal weight;
    private  BigDecimal volume;
    private  String startProvinceName;
    private  String startCityName;
    private  String startCountyName;
    private  String startTownName;
    private  String startAddress;
    private  String startContact;
    private  String startPhone;
    private  String startMobile;
    private  String startCompany;
    private  String terminusProvinceName;
    private  String terminusCityName;
    private  String terminusCountyName;
    private  String terminusTownName;
    private  String terminusAddress;
    private  String terminusContact;
    private  String terminusPhone;
    private  String terminusMobile;
    private  String terminusCompany;
    private  Integer pickupType;
    private  Integer deliveryType;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private  Date expectPickupStartTime;

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private  Date expectPickupEndTime;

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private  Date expectDeliveryStartTime;

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private  Date expectDeliveryEndTime;
    private  Integer payType;
    private  BigDecimal freight;
    private  String remark;

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

    public Integer getConsignCount() {
        return consignCount;
    }

    public void setConsignCount(Integer consignCount) {
        this.consignCount = consignCount;
    }

    public String getConsignWare() {
        return consignWare;
    }

    public void setConsignWare(String consignWare) {
        this.consignWare = consignWare;
    }

    public Integer getConsignType() {
        return consignType;
    }

    public void setConsignType(Integer consignType) {
        this.consignType = consignType;
    }

    public BigDecimal getLength() {
        return length;
    }

    public void setLength(BigDecimal length) {
        this.length = length;
    }

    public BigDecimal getWidth() {
        return width;
    }

    public void setWidth(BigDecimal width) {
        this.width = width;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public String getStartProvinceName() {
        return startProvinceName;
    }

    public void setStartProvinceName(String startProvinceName) {
        this.startProvinceName = startProvinceName;
    }

    public String getStartCityName() {
        return startCityName;
    }

    public void setStartCityName(String startCityName) {
        this.startCityName = startCityName;
    }

    public String getStartCountyName() {
        return startCountyName;
    }

    public void setStartCountyName(String startCountyName) {
        this.startCountyName = startCountyName;
    }

    public String getStartTownName() {
        return startTownName;
    }

    public void setStartTownName(String startTownName) {
        this.startTownName = startTownName;
    }

    public String getStartAddress() {
        return startAddress;
    }

    public void setStartAddress(String startAddress) {
        this.startAddress = startAddress;
    }

    public String getStartContact() {
        return startContact;
    }

    public void setStartContact(String startContact) {
        this.startContact = startContact;
    }

    public String getStartPhone() {
        return startPhone;
    }

    public void setStartPhone(String startPhone) {
        this.startPhone = startPhone;
    }

    public String getStartMobile() {
        return startMobile;
    }

    public void setStartMobile(String startMobile) {
        this.startMobile = startMobile;
    }

    public String getStartCompany() {
        return startCompany;
    }

    public void setStartCompany(String startCompany) {
        this.startCompany = startCompany;
    }

    public String getTerminusProvinceName() {
        return terminusProvinceName;
    }

    public void setTerminusProvinceName(String terminusProvinceName) {
        this.terminusProvinceName = terminusProvinceName;
    }

    public String getTerminusCityName() {
        return terminusCityName;
    }

    public void setTerminusCityName(String terminusCityName) {
        this.terminusCityName = terminusCityName;
    }

    public String getTerminusCountyName() {
        return terminusCountyName;
    }

    public void setTerminusCountyName(String terminusCountyName) {
        this.terminusCountyName = terminusCountyName;
    }

    public String getTerminusTownName() {
        return terminusTownName;
    }

    public void setTerminusTownName(String terminusTownName) {
        this.terminusTownName = terminusTownName;
    }

    public String getTerminusAddress() {
        return terminusAddress;
    }

    public void setTerminusAddress(String terminusAddress) {
        this.terminusAddress = terminusAddress;
    }

    public String getTerminusContact() {
        return terminusContact;
    }

    public void setTerminusContact(String terminusContact) {
        this.terminusContact = terminusContact;
    }

    public String getTerminusPhone() {
        return terminusPhone;
    }

    public void setTerminusPhone(String terminusPhone) {
        this.terminusPhone = terminusPhone;
    }

    public String getTerminusMobile() {
        return terminusMobile;
    }

    public void setTerminusMobile(String terminusMobile) {
        this.terminusMobile = terminusMobile;
    }

    public String getTerminusCompany() {
        return terminusCompany;
    }

    public void setTerminusCompany(String terminusCompany) {
        this.terminusCompany = terminusCompany;
    }

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

    public Date getExpectPickupStartTime() {
        return expectPickupStartTime;
    }

    public void setExpectPickupStartTime(Date expectPickupStartTime) {
        this.expectPickupStartTime = expectPickupStartTime;
    }

    public Date getExpectPickupEndTime() {
        return expectPickupEndTime;
    }

    public void setExpectPickupEndTime(Date expectPickupEndTime) {
        this.expectPickupEndTime = expectPickupEndTime;
    }

    public Date getExpectDeliveryStartTime() {
        return expectDeliveryStartTime;
    }

    public void setExpectDeliveryStartTime(Date expectDeliveryStartTime) {
        this.expectDeliveryStartTime = expectDeliveryStartTime;
    }

    public Date getExpectDeliveryEndTime() {
        return expectDeliveryEndTime;
    }

    public void setExpectDeliveryEndTime(Date expectDeliveryEndTime) {
        this.expectDeliveryEndTime = expectDeliveryEndTime;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public BigDecimal getFreight() {
        return freight;
    }

    public void setFreight(BigDecimal freight) {
        this.freight = freight;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
