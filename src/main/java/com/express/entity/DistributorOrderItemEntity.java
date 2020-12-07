package com.express.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单详情
 * 
 * @author Rock.Zhou
 * @email cool_fish@aliyun.com
 * @date 2020-12-03 15:12:09
 */
@TableName("distributor_order_item")
public class DistributorOrderItemEntity implements Serializable {
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
	private Double deliveredAmount;
	/**
	 * $column.comments
	 */
	private Date deliveryDate;
	/**
	 * $column.comments
	 */
	private String itemName;
	/**
	 * $column.comments
	 */
	private String itemNumber;
	/**
	 * $column.comments
	 */
	private Date modifyDate;
	/**
	 * $column.comments
	 */
	private Date orderAcceptedDate;
	/**
	 * $column.comments
	 */
	private Integer orderAmount;
	/**
	 * $column.comments
	 */
	private Date orderItemClosedDate;
	/**
	 * $column.comments
	 */
	private Date orderItemDeliveredDate;
	/**
	 * $column.comments
	 */
	private Date ordeItemrDeliveringDate;
	/**
	 * $column.comments
	 */
	private Date orderItemPaidDate;
	/**
	 * $column.comments
	 */
	private Date orderItemProducingDate;
	/**
	 * $column.comments
	 */
	private Date orderItemReadyForShippingDate;
	/**
	 * $column.comments
	 */
	private Date orderItemShippingDate;
	/**
	 * $column.comments
	 */
	private Date orderReceivedDate;
	/**
	 * $column.comments
	 */
	private Date orderWaitForVerifyDate;
	/**
	 * $column.comments
	 */
	private Double sellPrice;
	/**
	 * $column.comments
	 */
	private Double subTotal;
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
	private Long distributorOrderId;
	/**
	 * $column.comments
	 */
	private Long statusId;
	/**
	 * $column.comments
	 */
	private Long distributorProductId;
	/**
	 * $column.comments
	 */
	private Long modifierId;
	/**
	 * $column.comments
	 */
	private String skuUnit;
	/**
	 * $column.comments
	 */
	private String spec;
	/**
	 * $column.comments
	 */
	private String erpDeliveryProductKey;
	/**
	 * $column.comments
	 */
	private String erpOrderProductKey;
	/**
	 * $column.comments
	 */
	private Double orderAmountKg;
	/**
	 * $column.comments
	 */
	private Date version;
	/**
	 * $column.comments
	 */
	private Long ecDistributorProductId;
	/**
	 * $column.comments
	 */
	private Double fromDistributorSellPrice;
	/**
	 * $column.comments
	 */
	private Double fromDistributorSubTotal;

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

	public Double getDeliveredAmount() {
		return deliveredAmount;
	}

	public void setDeliveredAmount(Double deliveredAmount) {
		this.deliveredAmount = deliveredAmount;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(String itemNumber) {
		this.itemNumber = itemNumber;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Date getOrderAcceptedDate() {
		return orderAcceptedDate;
	}

	public void setOrderAcceptedDate(Date orderAcceptedDate) {
		this.orderAcceptedDate = orderAcceptedDate;
	}

	public Integer getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(Integer orderAmount) {
		this.orderAmount = orderAmount;
	}

	public Date getOrderItemClosedDate() {
		return orderItemClosedDate;
	}

	public void setOrderItemClosedDate(Date orderItemClosedDate) {
		this.orderItemClosedDate = orderItemClosedDate;
	}

	public Date getOrderItemDeliveredDate() {
		return orderItemDeliveredDate;
	}

	public void setOrderItemDeliveredDate(Date orderItemDeliveredDate) {
		this.orderItemDeliveredDate = orderItemDeliveredDate;
	}

	public Date getOrdeItemrDeliveringDate() {
		return ordeItemrDeliveringDate;
	}

	public void setOrdeItemrDeliveringDate(Date ordeItemrDeliveringDate) {
		this.ordeItemrDeliveringDate = ordeItemrDeliveringDate;
	}

	public Date getOrderItemPaidDate() {
		return orderItemPaidDate;
	}

	public void setOrderItemPaidDate(Date orderItemPaidDate) {
		this.orderItemPaidDate = orderItemPaidDate;
	}

	public Date getOrderItemProducingDate() {
		return orderItemProducingDate;
	}

	public void setOrderItemProducingDate(Date orderItemProducingDate) {
		this.orderItemProducingDate = orderItemProducingDate;
	}

	public Date getOrderItemReadyForShippingDate() {
		return orderItemReadyForShippingDate;
	}

	public void setOrderItemReadyForShippingDate(Date orderItemReadyForShippingDate) {
		this.orderItemReadyForShippingDate = orderItemReadyForShippingDate;
	}

	public Date getOrderItemShippingDate() {
		return orderItemShippingDate;
	}

	public void setOrderItemShippingDate(Date orderItemShippingDate) {
		this.orderItemShippingDate = orderItemShippingDate;
	}

	public Date getOrderReceivedDate() {
		return orderReceivedDate;
	}

	public void setOrderReceivedDate(Date orderReceivedDate) {
		this.orderReceivedDate = orderReceivedDate;
	}

	public Date getOrderWaitForVerifyDate() {
		return orderWaitForVerifyDate;
	}

	public void setOrderWaitForVerifyDate(Date orderWaitForVerifyDate) {
		this.orderWaitForVerifyDate = orderWaitForVerifyDate;
	}

	public Double getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(Double sellPrice) {
		this.sellPrice = sellPrice;
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
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

	public Long getDistributorOrderId() {
		return distributorOrderId;
	}

	public void setDistributorOrderId(Long distributorOrderId) {
		this.distributorOrderId = distributorOrderId;
	}

	public Long getStatusId() {
		return statusId;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	public Long getDistributorProductId() {
		return distributorProductId;
	}

	public void setDistributorProductId(Long distributorProductId) {
		this.distributorProductId = distributorProductId;
	}

	public Long getModifierId() {
		return modifierId;
	}

	public void setModifierId(Long modifierId) {
		this.modifierId = modifierId;
	}

	public String getSkuUnit() {
		return skuUnit;
	}

	public void setSkuUnit(String skuUnit) {
		this.skuUnit = skuUnit;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public String getErpDeliveryProductKey() {
		return erpDeliveryProductKey;
	}

	public void setErpDeliveryProductKey(String erpDeliveryProductKey) {
		this.erpDeliveryProductKey = erpDeliveryProductKey;
	}

	public String getErpOrderProductKey() {
		return erpOrderProductKey;
	}

	public void setErpOrderProductKey(String erpOrderProductKey) {
		this.erpOrderProductKey = erpOrderProductKey;
	}

	public Double getOrderAmountKg() {
		return orderAmountKg;
	}

	public void setOrderAmountKg(Double orderAmountKg) {
		this.orderAmountKg = orderAmountKg;
	}

	public Date getVersion() {
		return version;
	}

	public void setVersion(Date version) {
		this.version = version;
	}

	public Long getEcDistributorProductId() {
		return ecDistributorProductId;
	}

	public void setEcDistributorProductId(Long ecDistributorProductId) {
		this.ecDistributorProductId = ecDistributorProductId;
	}

	public Double getFromDistributorSellPrice() {
		return fromDistributorSellPrice;
	}

	public void setFromDistributorSellPrice(Double fromDistributorSellPrice) {
		this.fromDistributorSellPrice = fromDistributorSellPrice;
	}

	public Double getFromDistributorSubTotal() {
		return fromDistributorSubTotal;
	}

	public void setFromDistributorSubTotal(Double fromDistributorSubTotal) {
		this.fromDistributorSubTotal = fromDistributorSubTotal;
	}
}
