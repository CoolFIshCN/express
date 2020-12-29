package com.express.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.express.entity.SysUserTokenEntity;

import java.util.List;
import java.util.Map;

/**
 * 用户token
 *
 * @author Rock.Zhou
 * @email cool_fish@aliyun.com
 * @date 2020-12-25 16:48:51
 */
public interface SysUserTokenService extends IService<SysUserTokenEntity> {

    /**
     * 查询创建时间为三天前的账号
     * @param userNo
     * @param userPs
     * @return
     */
    List<Map<String,Object>> findIsExpired(String userNo, String userPs);

    /**
     * 获取token
     * @param userNo
     * @param pwd
     * @return
     */
    Map<String, String> getToken(String userNo, String pwd);

    /**
     * 生成双token
     * @param user
     * @return
     */
    Map<String, String> getDoubleToken (SysUserTokenEntity user);

    /**
     * 创建用户
     * @param params
     * @return
     */
    boolean createUser(Map<String, String> params);

    /**
     * 根据用户名查询是否重复
     * @param userNo
     * @return
     */
    int countByUserNo(String userNo);
}

