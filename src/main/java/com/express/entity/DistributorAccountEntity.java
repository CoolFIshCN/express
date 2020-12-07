package com.express.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * distributor_account
 * 
 * @author Rock.Zhou
 * @email cool_fish@aliyun.com
 * @date 2020-12-07 11:23:08
 */
@TableName("distributor_account")
public class DistributorAccountEntity implements Serializable {
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
	private String email;
	/**
	 * $column.comments
	 */
	private String forgotPasswordKey;
	/**
	 * $column.comments
	 */
	private String fullName;
	/**
	 * $column.comments
	 */
	private String mobileNumber;
	/**
	 * $column.comments
	 */
	private Date modifyDate;
	/**
	 * $column.comments
	 */
	private String password;
	/**
	 * $column.comments
	 */
	private Integer wrongPasswordCount;
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
	private Long statusId;
	/**
	 * $column.comments
	 */
	private Long modifierId;
	/**
	 * $column.comments
	 */
	private Long genericDepartmentId;
	/**
	 * $column.comments
	 */
	private Long genericJobTitleId;
	/**
	 * $column.comments
	 */
	private String selfCreateCommercialType;
	/**
	 * $column.comments
	 */
	private String selfCreateCooperateIntension;
	/**
	 * $column.comments
	 */
	private String selfCreateDepartment;
	/**
	 * $column.comments
	 */
	private String selfCreateInterestedProduct;
	/**
	 * $column.comments
	 */
	private String selfCreateJobTitle;
	/**
	 * $column.comments
	 */
	private String remark;
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
	private String accountName;
	/**
	 * $column.comments
	 */
	private String smsCode;
	/**
	 * $column.comments
	 */
	private Date smsCodeDate;
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
	private String deliveryRemark;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getForgotPasswordKey() {
		return forgotPasswordKey;
	}

	public void setForgotPasswordKey(String forgotPasswordKey) {
		this.forgotPasswordKey = forgotPasswordKey;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getWrongPasswordCount() {
		return wrongPasswordCount;
	}

	public void setWrongPasswordCount(Integer wrongPasswordCount) {
		this.wrongPasswordCount = wrongPasswordCount;
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

	public Long getStatusId() {
		return statusId;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	public Long getModifierId() {
		return modifierId;
	}

	public void setModifierId(Long modifierId) {
		this.modifierId = modifierId;
	}

	public Long getGenericDepartmentId() {
		return genericDepartmentId;
	}

	public void setGenericDepartmentId(Long genericDepartmentId) {
		this.genericDepartmentId = genericDepartmentId;
	}

	public Long getGenericJobTitleId() {
		return genericJobTitleId;
	}

	public void setGenericJobTitleId(Long genericJobTitleId) {
		this.genericJobTitleId = genericJobTitleId;
	}

	public String getSelfCreateCommercialType() {
		return selfCreateCommercialType;
	}

	public void setSelfCreateCommercialType(String selfCreateCommercialType) {
		this.selfCreateCommercialType = selfCreateCommercialType;
	}

	public String getSelfCreateCooperateIntension() {
		return selfCreateCooperateIntension;
	}

	public void setSelfCreateCooperateIntension(String selfCreateCooperateIntension) {
		this.selfCreateCooperateIntension = selfCreateCooperateIntension;
	}

	public String getSelfCreateDepartment() {
		return selfCreateDepartment;
	}

	public void setSelfCreateDepartment(String selfCreateDepartment) {
		this.selfCreateDepartment = selfCreateDepartment;
	}

	public String getSelfCreateInterestedProduct() {
		return selfCreateInterestedProduct;
	}

	public void setSelfCreateInterestedProduct(String selfCreateInterestedProduct) {
		this.selfCreateInterestedProduct = selfCreateInterestedProduct;
	}

	public String getSelfCreateJobTitle() {
		return selfCreateJobTitle;
	}

	public void setSelfCreateJobTitle(String selfCreateJobTitle) {
		this.selfCreateJobTitle = selfCreateJobTitle;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getSmsCode() {
		return smsCode;
	}

	public void setSmsCode(String smsCode) {
		this.smsCode = smsCode;
	}

	public Date getSmsCodeDate() {
		return smsCodeDate;
	}

	public void setSmsCodeDate(Date smsCodeDate) {
		this.smsCodeDate = smsCodeDate;
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

	public String getDeliveryRemark() {
		return deliveryRemark;
	}

	public void setDeliveryRemark(String deliveryRemark) {
		this.deliveryRemark = deliveryRemark;
	}
}
