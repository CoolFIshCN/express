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
    List<SysUserTokenEntity> findIsExpired(String userNo, String userPs);

    /**
     * 生成双token
     * @param userNo
     * @param pwd
     * @param distributorId
     * @param outTime
     * @param renew
     * @return
     */
    Map<String, String> getToken(String userNo, String pwd, Long distributorId, int outTime, boolean renew);
}

