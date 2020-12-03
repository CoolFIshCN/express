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

}
