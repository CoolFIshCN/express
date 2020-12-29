package com.express.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.express.entity.SysUserTokenEntity;
import com.express.mapper.SysUserTokenDao;
import com.express.service.SysUserTokenService;
import com.express.util.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.*;

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
     * jwt
     */
    @Autowired
    private JWTService jwtService;

    /**
     * 用户
     */
    @Autowired
    private SysUserTokenDao userTokenDao;

    /**
     * 查询创建时间为三天前的账号
     *
     * @param userNo
     * @param userPs
     * @return
     */
    @Override
    public List<Map<String, Object>> findIsExpired(String userNo, String userPs) {
        List<Map<String, Object>> resultList = userTokenDao.findIsExpired(userNo, userPs);

        return resultList;
    }

    /**
     * 获取token
     *
     * @param userNo
     * @param pwd
     * @return
     */
    @Override
    public Map<String, String> getToken(String userNo, String pwd) {

        Map<String, String> tokens = new HashMap<>();

        // 用户校验
        List<SysUserTokenEntity> userList = userTokenDao.selectList(new QueryWrapper<SysUserTokenEntity>()
                .eq("user_no", userNo)
                .eq("user_ps", pwd)
                .ne("is_del", 1));
        if (null != userList && userList.size() > 0) {
            SysUserTokenEntity user = userList.get(0);
            tokens = getDoubleToken(user);
        }

        return tokens;
    }

    /**
     * 生成双token
     * @param user
     * @return
     */
    @Override
    public Map<String, String> getDoubleToken (SysUserTokenEntity user){

        Map<String, String> tokens = new HashMap<>();
        // 生成token
        String token = jwtService.getToken(user);
        // 生成RefreshToken
        String refreshToken = UUID.randomUUID().toString().replaceAll("-", "");;

        tokens.put("access_token", token);
        tokens.put("refresh_token",refreshToken);

        // 保存双token
        user.setRefreshToken(refreshToken);
        user.setAccessToken(token);
        user.setUpdateTime(new Date());
        userTokenDao.updateById(user);
        return tokens;
    }

    /**
     * 创建用户
     *
     * @param params
     * @return
     */
    @Override
    public boolean createUser(Map<String, String> params) {
        // 标识
        boolean flag = false;

        String userNo = params.get("userNo");
        String userPs = params.get("userPs");

        // 调用dao
        int saveCount = userTokenDao.createUser(userNo, userPs);
        if (saveCount < 1) {
            flag = false;
        } else {
            flag = true;
        }
        return flag;
    }

    /**
     * 根据用户名查询是否重复
     *
     * @param userNo
     * @return
     */
    @DS("api")
    @Override
    public int countByUserNo(String userNo) {
        int countByUserNo = userTokenDao.selectCount(new QueryWrapper<SysUserTokenEntity>()
                .eq("user_no", userNo)
                .ne("is_del", 1));
        return countByUserNo;
    }
}