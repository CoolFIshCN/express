package com.express.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.data.annotation.Transient;

import java.io.Serializable;
import java.util.Date;

/**
 * ${comments}
 * 
 * @author Rock.Zhou
 * @email cool_fish@aliyun.com
 * @date 2020-11-26 14:46:06
 */
@TableName("distributor_product")
public class DistributorProductEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * $column.comments
	 */
	@Transient
	private Long id;
	/**
	 * $column.comments
	 */
	private Date createDate;
	/**
	 * $column.comments
	 */
	private String distributorLevel;
	/**
	 * $column.comments
	 */
	private String distributorName;
	/**
	 * $column.comments
	 */
	private String distributorNumber;
	/**
	 * $column.comments
	 */
	private Date modifyDate;
	/**
	 * $column.comments
	 */
	private String productName;
	/**
	 * $column.comments
	 */
	private String productNumber;
	/**
	 * $column.comments
	 */
	private Double sellPrice;
	/**
	 * $column.comments
	 */
	private String sellUnit;
	/**
	 * $column.comments
	 */
	private String stockUnit;
	/**
	 * $column.comments
	 */
	private Long creatorId;
	/**
	 * $column.comments
	 */
	private Long statusId;
	/**
	 * $column.comments
	 */
	private Long modifierId;
	/**
	 * product表id主键
	 */
	private Long productId;
	/**
	 * $column.comments
	 */
	private Long distributorId;
	/**
	 * $column.comments
	 */
	private Double unitWeight;
	/**
	 * $column.comments
	 */
	private Integer version;
	/**
	 * $column.comments
	 */
	private Integer ecAvailableStock;
	/**
	 * $column.comments
	 */
	private Integer ecOccupiedStock;
	/**
	 * $column.comments
	 */
	private Integer ecStock;
	/**
	 * 安全库存量
	 */
	private Integer safeStockAmount;
	/**
	 * $column.comments
	 */
	private Long productStockTypeId;
	/**
	 * $column.comments
	 */
	private String originalRequestId;
	/**
	 * $column.comments
	 */
	private String currency;
	/**
	 * $column.comments
	 */
	private Integer sellUnitSkuAmount;
	/**
	 * $column.comments
	 */
	private Long companyId;
	/**
	 * $column.comments
	 */
	private String productNumberSap;
	/**
	 * 最小起订量
	 */
	private Integer orderAmountLeast;
	/**
	 * 最大起订量
	 */
	private Integer stocksAmountMax;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

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

	public String getDistributorLevel() {
		return distributorLevel;
	}

	public void setDistributorLevel(String distributorLevel) {
		this.distributorLevel = distributorLevel;
	}

	public String getDistributorName() {
		return distributorName;
	}

	public void setDistributorName(String distributorName) {
		this.distributorName = distributorName;
	}

	public String getDistributorNumber() {
		return distributorNumber;
	}

	public void setDistributorNumber(String distributorNumber) {
		this.distributorNumber = distributorNumber;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}

	public Double getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(Double sellPrice) {
		this.sellPrice = sellPrice;
	}

	public String getSellUnit() {
		return sellUnit;
	}

	public void setSellUnit(String sellUnit) {
		this.sellUnit = sellUnit;
	}

	public String getStockUnit() {
		return stockUnit;
	}

	public void setStockUnit(String stockUnit) {
		this.stockUnit = stockUnit;
	}

	public Long getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
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

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getDistributorId() {
		return distributorId;
	}

	public void setDistributorId(Long distributorId) {
		this.distributorId = distributorId;
	}

	public Double getUnitWeight() {
		return unitWeight;
	}

	public void setUnitWeight(Double unitWeight) {
		this.unitWeight = unitWeight;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Integer getEcAvailableStock() {
		return ecAvailableStock;
	}

	public void setEcAvailableStock(Integer ecAvailableStock) {
		this.ecAvailableStock = ecAvailableStock;
	}

	public Integer getEcOccupiedStock() {
		return ecOccupiedStock;
	}

	public void setEcOccupiedStock(Integer ecOccupiedStock) {
		this.ecOccupiedStock = ecOccupiedStock;
	}

	public Integer getEcStock() {
		return ecStock;
	}

	public void setEcStock(Integer ecStock) {
		this.ecStock = ecStock;
	}

	public Integer getSafeStockAmount() {
		return safeStockAmount;
	}

	public void setSafeStockAmount(Integer safeStockAmount) {
		this.safeStockAmount = safeStockAmount;
	}

	public Long getProductStockTypeId() {
		return productStockTypeId;
	}

	public void setProductStockTypeId(Long productStockTypeId) {
		this.productStockTypeId = productStockTypeId;
	}

	public String getOriginalRequestId() {
		return originalRequestId;
	}

	public void setOriginalRequestId(String originalRequestId) {
		this.originalRequestId = originalRequestId;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Integer getSellUnitSkuAmount() {
		return sellUnitSkuAmount;
	}

	public void setSellUnitSkuAmount(Integer sellUnitSkuAmount) {
		this.sellUnitSkuAmount = sellUnitSkuAmount;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getProductNumberSap() {
		return productNumberSap;
	}

	public void setProductNumberSap(String productNumberSap) {
		this.productNumberSap = productNumberSap;
	}

	public Integer getOrderAmountLeast() {
		return orderAmountLeast;
	}

	public void setOrderAmountLeast(Integer orderAmountLeast) {
		this.orderAmountLeast = orderAmountLeast;
	}

	public Integer getStocksAmountMax() {
		return stocksAmountMax;
	}

	public void setStocksAmountMax(Integer stocksAmountMax) {
		this.stocksAmountMax = stocksAmountMax;
	}
}
