package com.express.dto.zhongyou;

/**
 * 重邮·批量下单·配送信息
 *
 */
public class BatchCreateOrderParticipantInfoDto {

    // 省名称
    private String provinceName;

    // 市名称
    private String cityName;

    // 区/县名称
    private String countyName;

    // 乡镇/街道名称
    private String townName;

    // 详细地址
    private String address;

    // 联系人
    private String contact;

    //联系电话  手机号、固话二选一必填
    private String phone;

    // 联系手机 手机号、固话二选一必填
    private String mobile;

    // 单位、公司
    private String company;

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
