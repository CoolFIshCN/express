package com.express.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 物料
 * 
 * @author Rock.Zhou
 * @email cool_fish@aliyun.com
 * @date 2020-11-24 10:23:22
 */
@TableName("product")
public class ProductEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	private Long id;
	/**
	 * 简介
	 */
	private String briefDescription;
	/**
	 * $column.comments
	 */
	private String content;
	/**
	 * $column.comments
	 */
	private Date createDate;
	/**
	 * $column.comments
	 */
	private Date modifyDate;
	/**
	 * $column.comments
	 */
	private String productCategory1stName;
	/**
	 * $column.comments
	 */
	private String productCategory1stNo;
	/**
	 * $column.comments
	 */
	private String productCategory2ndName;
	/**
	 * $column.comments
	 */
	private String productCategory2ndNo;
	/**
	 * 物料名称
	 */
	private String productName;
	/**
	 * 物料编号
	 */
	private String productNumber;
	/**
	 * $column.comments
	 */
	private String productThumbnailPix;
	/**
	 * 规格 (例: 12瓶/箱; 400包/20袋/箱)
	 */
	private String spec;
	/**
	 * 重量单位
	 */
	private String skuWeightUnit;
	/**
	 * sku单位(瓶、包、袋...)
	 */
	private String skuUnit;
	/**
	 * $column.comments
	 */
	private String erpSellingUnit;
	/**
	 * $column.comments
	 */
	private Long creatorId;
	/**
	 * $column.comments
	 */
	private Long modifierId;
	/**
	 * $column.comments
	 */
	private Long statusId;
	/**
	 * $column.comments
	 */
	private Long productCategory1stId;
	/**
	 * $column.comments
	 */
	private Long productCategory2ndId;
	/**
	 * sku净重 (公斤, 小数后二位)
	 */
	private Double skuWeight;
	/**
	 * $column.comments
	 */
	private Double boxLoadedWeight;
	/**
	 * $column.comments
	 */
	private String fenpa;
	/**
	 * $column.comments
	 */
	private String ecName;
	/**
	 * $column.comments
	 */
	private Long productTypeId;
	/**
	 * 箱材积(立方公分, 小数后二位)
	 */
	private Double boxLoadedVolume;
	/**
	 * 单箱内sku数
	 */
	private Integer boxLoadedAmount;
	/**
	 * 单箱毛重(KG, 小数后二位)
	 */
	private Double boxLoadedGrossWeight;
	/**
	 * 单箱净重(KG, 小数后二位)
	 */
	private Double boxLoadedNetWeight;
	/**
	 * 保质期
	 */
	private Integer warrantyDays;
	/**
	 * $column.comments
	 */
	private Date erpSyncDate;
	/**
	 * sku毛重 (公斤, 小数后二位)
	 */
	private Double skuGrossWeight;
	/**
	 * $column.comments
	 */
	private Long companyId;
	/**
	 * 箱载容积单位
	 */
	private String boxLoadedVolumeUnit;
	/**
	 * 储存条件
	 */
	private Long temperatureTypeId;
	/**
	 * $column.comments
	 */
	private Long distributorId;
	/**
	 * $column.comments
	 */
	private String productNumberSap;
	/**
	 * $column.comments
	 */
	private String barCode;
	/**
	 * $column.comments
	 */
	private Double boxLoadedHeight;
	/**
	 * $column.comments
	 */
	private Double boxLoadedLength;
	/**
	 * $column.comments
	 */
	private Double boxLoadedWidth;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBriefDescription() {
		return briefDescription;
	}

	public void setBriefDescription(String briefDescription) {
		this.briefDescription = briefDescription;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getProductCategory1stName() {
		return productCategory1stName;
	}

	public void setProductCategory1stName(String productCategory1stName) {
		this.productCategory1stName = productCategory1stName;
	}

	public String getProductCategory1stNo() {
		return productCategory1stNo;
	}

	public void setProductCategory1stNo(String productCategory1stNo) {
		this.productCategory1stNo = productCategory1stNo;
	}

	public String getProductCategory2ndName() {
		return productCategory2ndName;
	}

	public void setProductCategory2ndName(String productCategory2ndName) {
		this.productCategory2ndName = productCategory2ndName;
	}

	public String getProductCategory2ndNo() {
		return productCategory2ndNo;
	}

	public void setProductCategory2ndNo(String productCategory2ndNo) {
		this.productCategory2ndNo = productCategory2ndNo;
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

	public String getProductThumbnailPix() {
		return productThumbnailPix;
	}

	public void setProductThumbnailPix(String productThumbnailPix) {
		this.productThumbnailPix = productThumbnailPix;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public String getSkuWeightUnit() {
		return skuWeightUnit;
	}

	public void setSkuWeightUnit(String skuWeightUnit) {
		this.skuWeightUnit = skuWeightUnit;
	}

	public String getSkuUnit() {
		return skuUnit;
	}

	public void setSkuUnit(String skuUnit) {
		this.skuUnit = skuUnit;
	}

	public String getErpSellingUnit() {
		return erpSellingUnit;
	}

	public void setErpSellingUnit(String erpSellingUnit) {
		this.erpSellingUnit = erpSellingUnit;
	}

	public Long getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}

	public Long getModifierId() {
		return modifierId;
	}

	public void setModifierId(Long modifierId) {
		this.modifierId = modifierId;
	}

	public Long getStatusId() {
		return statusId;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	public Long getProductCategory1stId() {
		return productCategory1stId;
	}

	public void setProductCategory1stId(Long productCategory1stId) {
		this.productCategory1stId = productCategory1stId;
	}

	public Long getProductCategory2ndId() {
		return productCategory2ndId;
	}

	public void setProductCategory2ndId(Long productCategory2ndId) {
		this.productCategory2ndId = productCategory2ndId;
	}

	public Double getSkuWeight() {
		return skuWeight;
	}

	public void setSkuWeight(Double skuWeight) {
		this.skuWeight = skuWeight;
	}

	public Double getBoxLoadedWeight() {
		return boxLoadedWeight;
	}

	public void setBoxLoadedWeight(Double boxLoadedWeight) {
		this.boxLoadedWeight = boxLoadedWeight;
	}

	public String getFenpa() {
		return fenpa;
	}

	public void setFenpa(String fenpa) {
		this.fenpa = fenpa;
	}

	public String getEcName() {
		return ecName;
	}

	public void setEcName(String ecName) {
		this.ecName = ecName;
	}

	public Long getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(Long productTypeId) {
		this.productTypeId = productTypeId;
	}

	public Double getBoxLoadedVolume() {
		return boxLoadedVolume;
	}

	public void setBoxLoadedVolume(Double boxLoadedVolume) {
		this.boxLoadedVolume = boxLoadedVolume;
	}

	public Integer getBoxLoadedAmount() {
		return boxLoadedAmount;
	}

	public void setBoxLoadedAmount(Integer boxLoadedAmount) {
		this.boxLoadedAmount = boxLoadedAmount;
	}

	public Double getBoxLoadedGrossWeight() {
		return boxLoadedGrossWeight;
	}

	public void setBoxLoadedGrossWeight(Double boxLoadedGrossWeight) {
		this.boxLoadedGrossWeight = boxLoadedGrossWeight;
	}

	public Double getBoxLoadedNetWeight() {
		return boxLoadedNetWeight;
	}

	public void setBoxLoadedNetWeight(Double boxLoadedNetWeight) {
		this.boxLoadedNetWeight = boxLoadedNetWeight;
	}

	public Integer getWarrantyDays() {
		return warrantyDays;
	}

	public void setWarrantyDays(Integer warrantyDays) {
		this.warrantyDays = warrantyDays;
	}

	public Date getErpSyncDate() {
		return erpSyncDate;
	}

	public void setErpSyncDate(Date erpSyncDate) {
		this.erpSyncDate = erpSyncDate;
	}

	public Double getSkuGrossWeight() {
		return skuGrossWeight;
	}

	public void setSkuGrossWeight(Double skuGrossWeight) {
		this.skuGrossWeight = skuGrossWeight;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getBoxLoadedVolumeUnit() {
		return boxLoadedVolumeUnit;
	}

	public void setBoxLoadedVolumeUnit(String boxLoadedVolumeUnit) {
		this.boxLoadedVolumeUnit = boxLoadedVolumeUnit;
	}

	public Long getTemperatureTypeId() {
		return temperatureTypeId;
	}

	public void setTemperatureTypeId(Long temperatureTypeId) {
		this.temperatureTypeId = temperatureTypeId;
	}

	public Long getDistributorId() {
		return distributorId;
	}

	public void setDistributorId(Long distributorId) {
		this.distributorId = distributorId;
	}

	public String getProductNumberSap() {
		return productNumberSap;
	}

	public void setProductNumberSap(String productNumberSap) {
		this.productNumberSap = productNumberSap;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public Double getBoxLoadedHeight() {
		return boxLoadedHeight;
	}

	public void setBoxLoadedHeight(Double boxLoadedHeight) {
		this.boxLoadedHeight = boxLoadedHeight;
	}

	public Double getBoxLoadedLength() {
		return boxLoadedLength;
	}

	public void setBoxLoadedLength(Double boxLoadedLength) {
		this.boxLoadedLength = boxLoadedLength;
	}

	public Double getBoxLoadedWidth() {
		return boxLoadedWidth;
	}

	public void setBoxLoadedWidth(Double boxLoadedWidth) {
		this.boxLoadedWidth = boxLoadedWidth;
	}
}
