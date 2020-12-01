package com.express.dto;

import java.io.Serializable;
import java.util.Date;


/**
 * 物料外部接口dto
 *
 *   @author Rock.Zhou
 *   @email cool_fish@aliyun.com
 *   @date 2020-11-23 19:05:54
 */
public class ProductDto implements Serializable {

    // 物料编号
    private String productNumber;

    // 物料名称
    private String productName;

    // sku最小单位
    private String skuUnit;

    // sku毛重
    private Double skuGrossWeight;

    // sku净重
    private Double skuWeight;

    // 规格 (例: 12瓶/箱; 400包/20袋/箱)
    private String spec;

    // 保质期
    private Integer warrantyDays;

    // 存储条件
    private String temperatureType;

    // 箱长(公分, 小数后二位)
    private String boxLength;

    // 箱宽(公分, 小数后二位)
    private String boxWidth;

    // 箱高(公分, 小数后二位)
    private String boxHeight;

    //箱材积(立方公分, 小数后二位)
    private Double boxLoadedVolume;

    // 最大库存量
    private  Integer stocksAmountMax;

    // 安全库存量
    private  Integer safeStockAmount;

    // 最小起订量
    private  Integer orderAmountLeast;

    // 状态(0: 停用 / 1: 启用)
    private  Integer status;

    // 商品条码
    private String barCode;

    // 单箱净重(KG, 小数后二位)
    private String boxNetWeight;

    // 单箱毛重(KG, 小数后二位)
    private String boxGrossWeight;

    // 单箱内sku数
    private Integer boxLoadedAmount;

    // 当前操作人id
    private Long userId;

    // 当前时间
    private Date nowTime;

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSkuUnit() {
        return skuUnit;
    }

    public void setSkuUnit(String skuUnit) {
        this.skuUnit = skuUnit;
    }

    public Double getSkuGrossWeight() {
        return skuGrossWeight;
    }

    public void setSkuGrossWeight(Double skuGrossWeight) {
        this.skuGrossWeight = skuGrossWeight;
    }

    public Double getSkuWeight() {
        return skuWeight;
    }

    public void setSkuWeight(Double skuWeight) {
        this.skuWeight = skuWeight;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public Integer getWarrantyDays() {
        return warrantyDays;
    }

    public void setWarrantyDays(Integer warrantyDays) {
        this.warrantyDays = warrantyDays;
    }

    public String getTemperatureType() {
        return temperatureType;
    }

    public void setTemperatureType(String temperatureType) {
        this.temperatureType = temperatureType;
    }

    public String getBoxLength() {
        return boxLength;
    }

    public void setBoxLength(String boxLength) {
        this.boxLength = boxLength;
    }

    public String getBoxWidth() {
        return boxWidth;
    }

    public void setBoxWidth(String boxWidth) {
        this.boxWidth = boxWidth;
    }

    public String getBoxHeight() {
        return boxHeight;
    }

    public void setBoxHeight(String boxHeight) {
        this.boxHeight = boxHeight;
    }

    public Double getBoxLoadedVolume() {
        return boxLoadedVolume;
    }

    public void setBoxLoadedVolume(Double boxLoadedVolume) {
        this.boxLoadedVolume = boxLoadedVolume;
    }

    public Integer getStocksAmountMax() {
        return stocksAmountMax;
    }

    public void setStocksAmountMax(Integer stocksAmountMax) {
        this.stocksAmountMax = stocksAmountMax;
    }

    public Integer getSafeStockAmount() {
        return safeStockAmount;
    }

    public void setSafeStockAmount(Integer safeStockAmount) {
        this.safeStockAmount = safeStockAmount;
    }

    public Integer getOrderAmountLeast() {
        return orderAmountLeast;
    }

    public void setOrderAmountLeast(Integer orderAmountLeast) {
        this.orderAmountLeast = orderAmountLeast;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getBoxNetWeight() {
        return boxNetWeight;
    }

    public void setBoxNetWeight(String boxNetWeight) {
        this.boxNetWeight = boxNetWeight;
    }

    public String getBoxGrossWeight() {
        return boxGrossWeight;
    }

    public void setBoxGrossWeight(String boxGrossWeight) {
        this.boxGrossWeight = boxGrossWeight;
    }

    public Integer getBoxLoadedAmount() {
        return boxLoadedAmount;
    }

    public void setBoxLoadedAmount(Integer boxLoadedAmount) {
        this.boxLoadedAmount = boxLoadedAmount;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getNowTime() {
        return nowTime;
    }

    public void setNowTime(Date nowTime) {
        this.nowTime = nowTime;
    }
}
