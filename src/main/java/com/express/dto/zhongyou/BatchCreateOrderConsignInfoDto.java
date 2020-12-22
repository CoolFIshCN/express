package com.express.dto.zhongyou;

import java.math.BigDecimal;

/**
 * 重邮·批量下单·托寄物信息
 *
 */
public class BatchCreateOrderConsignInfoDto {

    // 托寄物数量 默认：1 包裹数量 数量1校验
    private Integer consignCount = 1;

    // 托寄物名称
    private String consignWare;

    // 托寄物类型 1.文件 2. 数码产品 3.生活用品 4.服饰 5.食品 6.其他(默认)
    private Integer consignType = 6;

    // 长（单位：cm）精度：0.00
    private BigDecimal length;

    // 宽（单位：cm）精度：0.00
    private BigDecimal width;

    // 高（单位：cm）精度：0.00
    private BigDecimal height;

    // 重量（单位：KG） 默认0.1, 精度：0.00
    private BigDecimal weight = new BigDecimal("0.1");

    // 体积（单位：cm^3）精度：0.00
    private BigDecimal volume;

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
}