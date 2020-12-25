package com.express.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 用户token
 *
 * @author Rock.Zhou
 * @email cool_fish@aliyun.com
 * @date 2020-12-25 16:48:51
 */
@Data
@TableName("sys_user_token")
public class SysUserTokenEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * $column.comments
     */
    @TableId
    private Long id;
    /**
     * $column.comments
     */
    private String userNo;
    /**
     * $column.comments
     */
    private String userPs;
    /**
     * $column.comments
     */
    private String accessToken;
    /**
     * $column.comments
     */
    private String refreshToken;
    /**
     * $column.comments
     */
    private Date expireAt;
    /**
     * $column.comments
     */
    private Date issueAt;
    /**
     * $column.comments
     */
    private Date updateTime;
    /**
     * $column.comments
     */
    private Long distributorId;
    /**
     * $column.comments
     */
    private String ipList;
    /**
     * $column.comments
     */
    private String contact;
    /**
     * $column.comments
     */
    private String phoneNumber;
    /**
     * $column.comments
     */
    private Date createTime;
    /**
     * $column.comments
     */
    private String verifyCode;
    /**
     * $column.comments
     */
    private Date verifyCreateTime;

    /**
     * 是否过期 Y=过期 N=未过期
     */
    @TableField(exist = false)
    private String isExpired = "Y";
}
