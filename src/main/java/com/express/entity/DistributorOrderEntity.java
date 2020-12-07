package com.express.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * ${comments}
 * 
 * @author Rock.Zhou
 * @email cool_fish@aliyun.com
 * @date 2020-12-03 15:07:56
 */
@TableName("distributor_order")
public class DistributorOrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * $column.comments
	 */
	@TableId
	private Long id;
	/**
	 * $column.comments
	 */
	private Date createDate;
	/**
	 * $column.comments
	 */
	private Integer ePaySerial;
	/**
	 * $column.comments
	 */
	private Date modifyDate;
	/**
	 * $column.comments
	 */
	private String orderNumberCustom;
	/**
	 * $column.comments
	 */
	private String orderNumberForPay;
	/**
	 * $column.comments
	 */
	private Date erpOrderVerifiedDeliveryDate;
	/**
	 * $column.comments
	 */
	private Date erpOrderUnverifiedDeliveryDate;
	/**
	 * $column.comments
	 */
	private Double sellPrice;
	/**
	 * $column.comments
	 */
	private Long creatorId;
	/**
	 * $column.comments
	 */
	private Long distributorId;
	/**
	 * $column.comments
	 */
	private Long distributorAccountId;
	/**
	 * $column.comments
	 */
	private Long statusId;
	/**
	 * $column.comments
	 */
	private Long distributorOrderTypeId;
	/**
	 * $column.comments
	 */
	private Long modifierId;
	/**
	 * $column.comments
	 */
	private Long paymentGatewayId;
	/**
	 * $column.comments
	 */
	private Long paymentTypeId;
	/**
	 * $column.comments
	 */
	private Date erpOrderBillOfSaleDate;
	/**
	 * $column.comments
	 */
	private String erpOrderBillOfSaleNumber;
	/**
	 * $column.comments
	 */
	private Date erpOrderUnverifiedDate;
	/**
	 * $column.comments
	 */
	private String erpOrderUnverifiedDeliveryNumber;
	/**
	 * $column.comments
	 */
	private String erpOrderUnverifiedNumber;
	/**
	 * $column.comments
	 */
	private Date erpOrderVerifiedDate;
	/**
	 * $column.comments
	 */
	private String erpOrderVerifiedDeliveryNumber;
	/**
	 * $column.comments
	 */
	private String erpOrderVerifiedNumber;
	/**
	 * $column.comments
	 */
	private Date version;
	/**
	 * $column.comments
	 */
	private Date orderArrivedDate;
	/**
	 * $column.comments
	 */
	private Date orderDeliveringDate;
	/**
	 * $column.comments
	 */
	private Date orderFailDate;
	/**
	 * $column.comments
	 */
	private Date orderShippingDate;
	/**
	 * $column.comments
	 */
	private Date orderSignBackDate;
	/**
	 * $column.comments
	 */
	private Long logisticsStatusId;
	/**
	 * $column.comments
	 */
	private String logisticsOrderNumber;
	/**
	 * $column.comments
	 */
	private Long invoiceTypeId;
	/**
	 * $column.comments
	 */
	private String deliveryAddressDetail;
	/**
	 * $column.comments
	 */
	private Long deliveryAreaId;
	/**
	 * $column.comments
	 */
	private Long deliveryCityId;
	/**
	 * $column.comments
	 */
	private Long deliveryProvinceId;
	/**
	 * $column.comments
	 */
	private Date logisticsConfirmDate;
	/**
	 * $column.comments
	 */
	private Date logisticsOrderNumberDate;
	/**
	 * $column.comments
	 */
	private String subLogisticsOrderNumber;
	/**
	 * $column.comments
	 */
	private Long logisticsTypeId;
	/**
	 * $column.comments
	 */
	private Long channelId;
	/**
	 * $column.comments
	 */
	private Date erpPaymentReceivedDate;
	/**
	 * $column.comments
	 */
	private String erpPaymentReceivedNumber;
	/**
	 * $column.comments
	 */
	private Long erpStatusId;
	/**
	 * $column.comments
	 */
	private String receiverFullName;
	/**
	 * $column.comments
	 */
	private String receiverMobileNumber;
	/**
	 * $column.comments
	 */
	private Date logisticsPayDate;
	/**
	 * $column.comments
	 */
	private Double logisticsFee;
	/**
	 * $column.comments
	 */
	private Long distributorStoreId;
	/**
	 * $column.comments
	 */
	private String fromDistributorLogisticsRemark;
	/**
	 * $column.comments
	 */
	private String fromDistributorOrderNumber;
	/**
	 * $column.comments
	 */
	private String fromDistributorOrderPayer;
	/**
	 * $column.comments
	 */
	private Double fromDistributorOrderPrice;
	/**
	 * $column.comments
	 */
	private String fromDistributorReceiveAddress;
	/**
	 * $column.comments
	 */
	private String remark;
	/**
	 * $column.comments
	 */
	private Long dataSourceTypeId;
	/**
	 * $column.comments
	 */
	private Double fromKdFianceReceivedOrderPrice;
	/**
	 * $column.comments
	 */
	private Date erpOrderReturnCompleteDate;
	/**
	 * $column.comments
	 */
	private String erpOrderReturnCompleteNumber;
	/**
	 * $column.comments
	 */
	private Date erpOrderReturnRequestDate;
	/**
	 * $column.comments
	 */
	private String erpOrderReturnRequestNumber;
	/**
	 * $column.comments
	 */
	private Long erpSalesReturnStatusId;
	/**
	 * $column.comments
	 */
	private String orderNumberSalesReturn;
	/**
	 * $column.comments
	 */
	private Date paymentCallBackReceivedDate;

	private Date   deliveryDate;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private String originalDeliveryDateString;

	private String originalOrderNumber;

	private String originalRequestId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getePaySerial() {
		return ePaySerial;
	}

	public void setePaySerial(Integer ePaySerial) {
		this.ePaySerial = ePaySerial;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getOrderNumberCustom() {
		return orderNumberCustom;
	}

	public void setOrderNumberCustom(String orderNumberCustom) {
		this.orderNumberCustom = orderNumberCustom;
	}

	public String getOrderNumberForPay() {
		return orderNumberForPay;
	}

	public void setOrderNumberForPay(String orderNumberForPay) {
		this.orderNumberForPay = orderNumberForPay;
	}

	public Date getErpOrderVerifiedDeliveryDate() {
		return erpOrderVerifiedDeliveryDate;
	}

	public void setErpOrderVerifiedDeliveryDate(Date erpOrderVerifiedDeliveryDate) {
		this.erpOrderVerifiedDeliveryDate = erpOrderVerifiedDeliveryDate;
	}

	public Date getErpOrderUnverifiedDeliveryDate() {
		return erpOrderUnverifiedDeliveryDate;
	}

	public void setErpOrderUnverifiedDeliveryDate(Date erpOrderUnverifiedDeliveryDate) {
		this.erpOrderUnverifiedDeliveryDate = erpOrderUnverifiedDeliveryDate;
	}

	public Double getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(Double sellPrice) {
		this.sellPrice = sellPrice;
	}

	public Long getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}

	public Long getDistributorId() {
		return distributorId;
	}

	public void setDistributorId(Long distributorId) {
		this.distributorId = distributorId;
	}

	public Long getDistributorAccountId() {
		return distributorAccountId;
	}

	public void setDistributorAccountId(Long distributorAccountId) {
		this.distributorAccountId = distributorAccountId;
	}

	public Long getStatusId() {
		return statusId;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	public Long getDistributorOrderTypeId() {
		return distributorOrderTypeId;
	}

	public void setDistributorOrderTypeId(Long distributorOrderTypeId) {
		this.distributorOrderTypeId = distributorOrderTypeId;
	}

	public Long getModifierId() {
		return modifierId;
	}

	public void setModifierId(Long modifierId) {
		this.modifierId = modifierId;
	}

	public Long getPaymentGatewayId() {
		return paymentGatewayId;
	}

	public void setPaymentGatewayId(Long paymentGatewayId) {
		this.paymentGatewayId = paymentGatewayId;
	}

	public Long getPaymentTypeId() {
		return paymentTypeId;
	}

	public void setPaymentTypeId(Long paymentTypeId) {
		this.paymentTypeId = paymentTypeId;
	}

	public Date getErpOrderBillOfSaleDate() {
		return erpOrderBillOfSaleDate;
	}

	public void setErpOrderBillOfSaleDate(Date erpOrderBillOfSaleDate) {
		this.erpOrderBillOfSaleDate = erpOrderBillOfSaleDate;
	}

	public String getErpOrderBillOfSaleNumber() {
		return erpOrderBillOfSaleNumber;
	}

	public void setErpOrderBillOfSaleNumber(String erpOrderBillOfSaleNumber) {
		this.erpOrderBillOfSaleNumber = erpOrderBillOfSaleNumber;
	}

	public Date getErpOrderUnverifiedDate() {
		return erpOrderUnverifiedDate;
	}

	public void setErpOrderUnverifiedDate(Date erpOrderUnverifiedDate) {
		this.erpOrderUnverifiedDate = erpOrderUnverifiedDate;
	}

	public String getErpOrderUnverifiedDeliveryNumber() {
		return erpOrderUnverifiedDeliveryNumber;
	}

	public void setErpOrderUnverifiedDeliveryNumber(String erpOrderUnverifiedDeliveryNumber) {
		this.erpOrderUnverifiedDeliveryNumber = erpOrderUnverifiedDeliveryNumber;
	}

	public String getErpOrderUnverifiedNumber() {
		return erpOrderUnverifiedNumber;
	}

	public void setErpOrderUnverifiedNumber(String erpOrderUnverifiedNumber) {
		this.erpOrderUnverifiedNumber = erpOrderUnverifiedNumber;
	}

	public Date getErpOrderVerifiedDate() {
		return erpOrderVerifiedDate;
	}

	public void setErpOrderVerifiedDate(Date erpOrderVerifiedDate) {
		this.erpOrderVerifiedDate = erpOrderVerifiedDate;
	}

	public String getErpOrderVerifiedDeliveryNumber() {
		return erpOrderVerifiedDeliveryNumber;
	}

	public void setErpOrderVerifiedDeliveryNumber(String erpOrderVerifiedDeliveryNumber) {
		this.erpOrderVerifiedDeliveryNumber = erpOrderVerifiedDeliveryNumber;
	}

	public String getErpOrderVerifiedNumber() {
		return erpOrderVerifiedNumber;
	}

	public void setErpOrderVerifiedNumber(String erpOrderVerifiedNumber) {
		this.erpOrderVerifiedNumber = erpOrderVerifiedNumber;
	}

	public Date getVersion() {
		return version;
	}

	public void setVersion(Date version) {
		this.version = version;
	}

	public Date getOrderArrivedDate() {
		return orderArrivedDate;
	}

	public void setOrderArrivedDate(Date orderArrivedDate) {
		this.orderArrivedDate = orderArrivedDate;
	}

	public Date getOrderDeliveringDate() {
		return orderDeliveringDate;
	}

	public void setOrderDeliveringDate(Date orderDeliveringDate) {
		this.orderDeliveringDate = orderDeliveringDate;
	}

	public Date getOrderFailDate() {
		return orderFailDate;
	}

	public void setOrderFailDate(Date orderFailDate) {
		this.orderFailDate = orderFailDate;
	}

	public Date getOrderShippingDate() {
		return orderShippingDate;
	}

	public void setOrderShippingDate(Date orderShippingDate) {
		this.orderShippingDate = orderShippingDate;
	}

	public Date getOrderSignBackDate() {
		return orderSignBackDate;
	}

	public void setOrderSignBackDate(Date orderSignBackDate) {
		this.orderSignBackDate = orderSignBackDate;
	}

	public Long getLogisticsStatusId() {
		return logisticsStatusId;
	}

	public void setLogisticsStatusId(Long logisticsStatusId) {
		this.logisticsStatusId = logisticsStatusId;
	}

	public String getLogisticsOrderNumber() {
		return logisticsOrderNumber;
	}

	public void setLogisticsOrderNumber(String logisticsOrderNumber) {
		this.logisticsOrderNumber = logisticsOrderNumber;
	}

	public Long getInvoiceTypeId() {
		return invoiceTypeId;
	}

	public void setInvoiceTypeId(Long invoiceTypeId) {
		this.invoiceTypeId = invoiceTypeId;
	}

	public String getDeliveryAddressDetail() {
		return deliveryAddressDetail;
	}

	public void setDeliveryAddressDetail(String deliveryAddressDetail) {
		this.deliveryAddressDetail = deliveryAddressDetail;
	}

	public Long getDeliveryAreaId() {
		return deliveryAreaId;
	}

	public void setDeliveryAreaId(Long deliveryAreaId) {
		this.deliveryAreaId = deliveryAreaId;
	}

	public Long getDeliveryCityId() {
		return deliveryCityId;
	}

	public void setDeliveryCityId(Long deliveryCityId) {
		this.deliveryCityId = deliveryCityId;
	}

	public Long getDeliveryProvinceId() {
		return deliveryProvinceId;
	}

	public void setDeliveryProvinceId(Long deliveryProvinceId) {
		this.deliveryProvinceId = deliveryProvinceId;
	}

	public Date getLogisticsConfirmDate() {
		return logisticsConfirmDate;
	}

	public void setLogisticsConfirmDate(Date logisticsConfirmDate) {
		this.logisticsConfirmDate = logisticsConfirmDate;
	}

	public Date getLogisticsOrderNumberDate() {
		return logisticsOrderNumberDate;
	}

	public void setLogisticsOrderNumberDate(Date logisticsOrderNumberDate) {
		this.logisticsOrderNumberDate = logisticsOrderNumberDate;
	}

	public String getSubLogisticsOrderNumber() {
		return subLogisticsOrderNumber;
	}

	public void setSubLogisticsOrderNumber(String subLogisticsOrderNumber) {
		this.subLogisticsOrderNumber = subLogisticsOrderNumber;
	}

	public Long getLogisticsTypeId() {
		return logisticsTypeId;
	}

	public void setLogisticsTypeId(Long logisticsTypeId) {
		this.logisticsTypeId = logisticsTypeId;
	}

	public Long getChannelId() {
		return channelId;
	}

	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}

	public Date getErpPaymentReceivedDate() {
		return erpPaymentReceivedDate;
	}

	public void setErpPaymentReceivedDate(Date erpPaymentReceivedDate) {
		this.erpPaymentReceivedDate = erpPaymentReceivedDate;
	}

	public String getErpPaymentReceivedNumber() {
		return erpPaymentReceivedNumber;
	}

	public void setErpPaymentReceivedNumber(String erpPaymentReceivedNumber) {
		this.erpPaymentReceivedNumber = erpPaymentReceivedNumber;
	}

	public Long getErpStatusId() {
		return erpStatusId;
	}

	public void setErpStatusId(Long erpStatusId) {
		this.erpStatusId = erpStatusId;
	}

	public String getReceiverFullName() {
		return receiverFullName;
	}

	public void setReceiverFullName(String receiverFullName) {
		this.receiverFullName = receiverFullName;
	}

	public String getReceiverMobileNumber() {
		return receiverMobileNumber;
	}

	public void setReceiverMobileNumber(String receiverMobileNumber) {
		this.receiverMobileNumber = receiverMobileNumber;
	}

	public Date getLogisticsPayDate() {
		return logisticsPayDate;
	}

	public void setLogisticsPayDate(Date logisticsPayDate) {
		this.logisticsPayDate = logisticsPayDate;
	}

	public Double getLogisticsFee() {
		return logisticsFee;
	}

	public void setLogisticsFee(Double logisticsFee) {
		this.logisticsFee = logisticsFee;
	}

	public Long getDistributorStoreId() {
		return distributorStoreId;
	}

	public void setDistributorStoreId(Long distributorStoreId) {
		this.distributorStoreId = distributorStoreId;
	}

	public String getFromDistributorLogisticsRemark() {
		return fromDistributorLogisticsRemark;
	}

	public void setFromDistributorLogisticsRemark(String fromDistributorLogisticsRemark) {
		this.fromDistributorLogisticsRemark = fromDistributorLogisticsRemark;
	}

	public String getFromDistributorOrderNumber() {
		return fromDistributorOrderNumber;
	}

	public void setFromDistributorOrderNumber(String fromDistributorOrderNumber) {
		this.fromDistributorOrderNumber = fromDistributorOrderNumber;
	}

	public String getFromDistributorOrderPayer() {
		return fromDistributorOrderPayer;
	}

	public void setFromDistributorOrderPayer(String fromDistributorOrderPayer) {
		this.fromDistributorOrderPayer = fromDistributorOrderPayer;
	}

	public Double getFromDistributorOrderPrice() {
		return fromDistributorOrderPrice;
	}

	public void setFromDistributorOrderPrice(Double fromDistributorOrderPrice) {
		this.fromDistributorOrderPrice = fromDistributorOrderPrice;
	}

	public String getFromDistributorReceiveAddress() {
		return fromDistributorReceiveAddress;
	}

	public void setFromDistributorReceiveAddress(String fromDistributorReceiveAddress) {
		this.fromDistributorReceiveAddress = fromDistributorReceiveAddress;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getDataSourceTypeId() {
		return dataSourceTypeId;
	}

	public void setDataSourceTypeId(Long dataSourceTypeId) {
		this.dataSourceTypeId = dataSourceTypeId;
	}

	public Double getFromKdFianceReceivedOrderPrice() {
		return fromKdFianceReceivedOrderPrice;
	}

	public void setFromKdFianceReceivedOrderPrice(Double fromKdFianceReceivedOrderPrice) {
		this.fromKdFianceReceivedOrderPrice = fromKdFianceReceivedOrderPrice;
	}

	public Date getErpOrderReturnCompleteDate() {
		return erpOrderReturnCompleteDate;
	}

	public void setErpOrderReturnCompleteDate(Date erpOrderReturnCompleteDate) {
		this.erpOrderReturnCompleteDate = erpOrderReturnCompleteDate;
	}

	public String getErpOrderReturnCompleteNumber() {
		return erpOrderReturnCompleteNumber;
	}

	public void setErpOrderReturnCompleteNumber(String erpOrderReturnCompleteNumber) {
		this.erpOrderReturnCompleteNumber = erpOrderReturnCompleteNumber;
	}

	public Date getErpOrderReturnRequestDate() {
		return erpOrderReturnRequestDate;
	}

	public void setErpOrderReturnRequestDate(Date erpOrderReturnRequestDate) {
		this.erpOrderReturnRequestDate = erpOrderReturnRequestDate;
	}

	public String getErpOrderReturnRequestNumber() {
		return erpOrderReturnRequestNumber;
	}

	public void setErpOrderReturnRequestNumber(String erpOrderReturnRequestNumber) {
		this.erpOrderReturnRequestNumber = erpOrderReturnRequestNumber;
	}

	public Long getErpSalesReturnStatusId() {
		return erpSalesReturnStatusId;
	}

	public void setErpSalesReturnStatusId(Long erpSalesReturnStatusId) {
		this.erpSalesReturnStatusId = erpSalesReturnStatusId;
	}

	public String getOrderNumberSalesReturn() {
		return orderNumberSalesReturn;
	}

	public void setOrderNumberSalesReturn(String orderNumberSalesReturn) {
		this.orderNumberSalesReturn = orderNumberSalesReturn;
	}

	public Date getPaymentCallBackReceivedDate() {
		return paymentCallBackReceivedDate;
	}

	public void setPaymentCallBackReceivedDate(Date paymentCallBackReceivedDate) {
		this.paymentCallBackReceivedDate = paymentCallBackReceivedDate;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getOriginalDeliveryDateString() {
		return originalDeliveryDateString;
	}

	public void setOriginalDeliveryDateString(String originalDeliveryDateString) {
		this.originalDeliveryDateString = originalDeliveryDateString;
	}

	public String getOriginalOrderNumber() {
		return originalOrderNumber;
	}

	public void setOriginalOrderNumber(String originalOrderNumber) {
		this.originalOrderNumber = originalOrderNumber;
	}

	public String getOriginalRequestId() {
		return originalRequestId;
	}

	public void setOriginalRequestId(String originalRequestId) {
		this.originalRequestId = originalRequestId;
	}

}
