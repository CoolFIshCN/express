package com.express.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.express.entity.SysUser;
import com.express.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 * @author jinbin
 * @date 2018-07-08 20:52
 */
@Service("UserService")
public class UserService {
    @Autowired
    UserMapper userMapper;

    @DS("api")
    public SysUser findByUsername(SysUser sysUser) {
        return userMapper.findByUsername(sysUser.getUsername());
    }
    @DS("api")
    public SysUser findUserById(String userId) {
        return userMapper.findUserById(userId);
    }

    /**
     * 用户校验
     *
     * @param username
     * @param password
     * @return
     */
    @DS("api")
    public SysUser checkPassword(String username, String password) {
        SysUser sysUser = new SysUser();
        String md5pw = DigestUtils.md5DigestAsHex((password).getBytes());
        SysUser byUsername = userMapper.findByUsername(username);
        if (null != byUsername && null != byUsername.getPassword() && md5pw.equals(byUsername.getPassword())) {
            return byUsername;
        }else {
            new RuntimeException("用户登录信息错误："+username+"-"+"password");
        }
        return sysUser;
    }
}
