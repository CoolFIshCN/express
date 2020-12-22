package com.express.dto.zhongyou;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 重邮·批量下单
 */
public class BatchCreateOrderDto extends TreeMap<String,Object> {

    // 增值服务         非必填
    private List<BatchCreateOrderAddedServiceDto> addedServiceList;

    // 托寄物信息
    private BatchCreateOrderConsignInfoDto consignInfo;

    // 客户平台信息
    private BatchCreateOrderCustomerInfoDto customerInfo;

    // 寄件人信息
    private BatchCreateOrderParticipantInfoDto senderInfo;

    // 收件人信息
    private BatchCreateOrderParticipantInfoDto receiverInfo;

    // 货运信息
    private BatchCreateOrderShipmentInfoDto shipmentInfo;

    // 运费支付方式 1.寄付 2.到付 3.月结
    private Integer payType;

    // 运费 精度0.00  寄付、月结时默认0，到付默认0.01      非必填
    private BigDecimal freight;


    // 订单备注         非必填
    private String remark;

    // 扩展信息         非必填
    private Map<String, String> extendMap;



    public BatchCreateOrderCustomerInfoDto getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(BatchCreateOrderCustomerInfoDto customerInfo) {
        this.customerInfo = customerInfo;
    }

    public BatchCreateOrderConsignInfoDto getConsignInfo() {
        return consignInfo;
    }

    public void setConsignInfo(BatchCreateOrderConsignInfoDto consignInfo) {
        this.consignInfo = consignInfo;
    }

    public BatchCreateOrderParticipantInfoDto getSenderInfo() {
        return senderInfo;
    }

    public void setSenderInfo(BatchCreateOrderParticipantInfoDto senderInfo) {
        this.senderInfo = senderInfo;
    }

    public BatchCreateOrderParticipantInfoDto getReceiverInfo() {
        return receiverInfo;
    }

    public void setReceiverInfo(BatchCreateOrderParticipantInfoDto receiverInfo) {
        this.receiverInfo = receiverInfo;
    }

    public BatchCreateOrderShipmentInfoDto getShipmentInfo() {
        return shipmentInfo;
    }

    public void setShipmentInfo(BatchCreateOrderShipmentInfoDto shipmentInfo) {
        this.shipmentInfo = shipmentInfo;
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

    public List<BatchCreateOrderAddedServiceDto> getAddedServiceList() {
        return addedServiceList;
    }

    public void setAddedServiceList(List<BatchCreateOrderAddedServiceDto> addedServiceList) {
        this.addedServiceList = addedServiceList;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Map<String, String> getExtendMap() {
        return extendMap;
    }

    public void setExtendMap(Map<String, String> extendMap) {
        this.extendMap = extendMap;
    }
}
