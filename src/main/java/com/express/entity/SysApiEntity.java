package com.express.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import lombok.Data;

/**
 * api
 * 
 * @author Rock.Zhou
 * @email cool_fish@aliyun.com
 * @date 2020-12-08 16:28:39
 */
@TableName("sys_api")
public class SysApiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * $column.comments
	 */
	@TableId
	private Long id;
	/**
	 * api名称，在接口注解中表明
	 */
	private String apiName;
	/**
	 * $column.comments
	 */
	private String apiUrl;
	/**
	 * $column.comments
	 */
	private String status;
	/**
	 * api备注
	 */
	private String apiRemark;
	/**
	 * 0存在 1删除
	 */
	private Integer isDel;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getApiName() {
		return apiName;
	}

	public void setApiName(String apiName) {
		this.apiName = apiName;
	}

	public String getApiUrl() {
		return apiUrl;
	}

	public void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getIsDel() {
		return isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

	public String getApiRemark() {
		return apiRemark;
	}

	public void setApiRemark(String apiRemark) {
		this.apiRemark = apiRemark;
	}
}
