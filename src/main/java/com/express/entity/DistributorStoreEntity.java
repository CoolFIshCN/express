package com.express.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 进销商门店
 *
 * @author Rock.Zhou
 * @email cool_fish@aliyun.com
 * @date 2020-12-02 11:02:17
 */
@TableName("distributor_store")
public class DistributorStoreEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
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
	private String deliveryAddressDetail;
	/**
	 * $column.comments
	 */
	private String remark;
	/**
	 * $column.comments
	 */
	private String storeAddressOriginal;
	/**
	 * $column.comments
	 */
	private String storeCityOriginal;
	/**
	 * $column.comments
	 */
	private String storeCountyOriginal;
	/**
	 * $column.comments
	 */
	private String storeNameKd;
	/**
	 * $column.comments
	 */
	private String storeNameOriginal;
	/**
	 * $column.comments
	 */
	private String storeNumberKd;
	/**
	 * $column.comments
	 */
	private String storeNumberOriginal;
	/**
	 * $column.comments
	 */
	private String storeProvinceOriginal;
	/**
	 * $column.comments
	 */
	private String storeTownshipOriginal;
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
	private Long distributorId;
	/**
	 * $column.comments
	 */
	private Long statusId;
	/**
	 * $column.comments
	 */
	private Long loginAccountId;
	/**
	 * $column.comments
	 */
	private String storePhoneNumberOriginal;
	/**
	 * $column.comments
	 */
	private String storeReceiverNameOriginal;
	/**
	 * $column.comments
	 */
	private Long distributorAccountId;
	/**
	 * $column.comments
	 */
	private String originalRequestId;

	@TableField(exist = false)
	private int statusIdOriginal;

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

	public String getDeliveryAddressDetail() {
		return deliveryAddressDetail;
	}

	public void setDeliveryAddressDetail(String deliveryAddressDetail) {
		this.deliveryAddressDetail = deliveryAddressDetail;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStoreAddressOriginal() {
		return storeAddressOriginal;
	}

	public void setStoreAddressOriginal(String storeAddressOriginal) {
		this.storeAddressOriginal = storeAddressOriginal;
	}

	public String getStoreCityOriginal() {
		return storeCityOriginal;
	}

	public void setStoreCityOriginal(String storeCityOriginal) {
		this.storeCityOriginal = storeCityOriginal;
	}

	public String getStoreCountyOriginal() {
		return storeCountyOriginal;
	}

	public void setStoreCountyOriginal(String storeCountyOriginal) {
		this.storeCountyOriginal = storeCountyOriginal;
	}

	public String getStoreNameKd() {
		return storeNameKd;
	}

	public void setStoreNameKd(String storeNameKd) {
		this.storeNameKd = storeNameKd;
	}

	public String getStoreNameOriginal() {
		return storeNameOriginal;
	}

	public void setStoreNameOriginal(String storeNameOriginal) {
		this.storeNameOriginal = storeNameOriginal;
	}

	public String getStoreNumberKd() {
		return storeNumberKd;
	}

	public void setStoreNumberKd(String storeNumberKd) {
		this.storeNumberKd = storeNumberKd;
	}

	public String getStoreNumberOriginal() {
		return storeNumberOriginal;
	}

	public void setStoreNumberOriginal(String storeNumberOriginal) {
		this.storeNumberOriginal = storeNumberOriginal;
	}

	public String getStoreProvinceOriginal() {
		return storeProvinceOriginal;
	}

	public void setStoreProvinceOriginal(String storeProvinceOriginal) {
		this.storeProvinceOriginal = storeProvinceOriginal;
	}

	public String getStoreTownshipOriginal() {
		return storeTownshipOriginal;
	}

	public void setStoreTownshipOriginal(String storeTownshipOriginal) {
		this.storeTownshipOriginal = storeTownshipOriginal;
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

	public Long getDistributorId() {
		return distributorId;
	}

	public void setDistributorId(Long distributorId) {
		this.distributorId = distributorId;
	}

	public Long getStatusId() {
		return statusId;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	public Long getLoginAccountId() {
		return loginAccountId;
	}

	public void setLoginAccountId(Long loginAccountId) {
		this.loginAccountId = loginAccountId;
	}

	public String getStorePhoneNumberOriginal() {
		return storePhoneNumberOriginal;
	}

	public void setStorePhoneNumberOriginal(String storePhoneNumberOriginal) {
		this.storePhoneNumberOriginal = storePhoneNumberOriginal;
	}

	public String getStoreReceiverNameOriginal() {
		return storeReceiverNameOriginal;
	}

	public void setStoreReceiverNameOriginal(String storeReceiverNameOriginal) {
		this.storeReceiverNameOriginal = storeReceiverNameOriginal;
	}

	public Long getDistributorAccountId() {
		return distributorAccountId;
	}

	public void setDistributorAccountId(Long distributorAccountId) {
		this.distributorAccountId = distributorAccountId;
	}

	public String getOriginalRequestId() {
		return originalRequestId;
	}

	public void setOriginalRequestId(String originalRequestId) {
		this.originalRequestId = originalRequestId;
	}

	public int getStatusIdOriginal() {
		return statusIdOriginal;
	}

	public void setStatusIdOriginal(int statusIdOriginal) {
		this.statusIdOriginal = statusIdOriginal;
	}
}
