package com.express.service.impl;

import com.express.entity.SysUserTokenEntity;
import com.express.mapper.SysUserTokenDao;
import com.express.service.SysUserTokenService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;
import java.util.Map;
/**
 * 用户token
 *
 * @author Rock.Zhou
 * @email cool_fish@aliyun.com
 * @date 2020-12-25 16:48:51
 */
@Service("sysUserTokenService")
public class SysUserTokenServiceImpl extends ServiceImpl<SysUserTokenDao, SysUserTokenEntity> implements SysUserTokenService {

    /**
     * 查询创建时间为三天前的账号
     * @param userNo
     * @param userPs
     * @return
     */
    @Override
    public List<SysUserTokenEntity> findIsExpired(String userNo, String userPs) {
        return null;
    }
    /**
     * 生成双token
     * @param userNo
     * @param pwd
     * @param distributorId
     * @param outTime
     * @param renew
     * @return
     */
    @Override
    public Map<String, String> getToken(String userNo, String pwd, Long distributorId, int outTime, boolean renew) {
        return null;
    }
}