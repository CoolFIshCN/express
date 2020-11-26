package com.express.service;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.express.entity.SysUser;
import org.springframework.stereotype.Service;


/**
 * @author jinbin
 * @date 2018-07-08 21:04
 */
@Service("TokenService")
public class TokenService {
    public String getToken(SysUser sysUser) {
        String token="";
        token= JWT.create().withAudience(sysUser.getId())// 将 user id 保存到 token 里面
                .sign(Algorithm.HMAC256(sysUser.getPassword()));// 以 password 作为 token 的密钥
        return token;
    }

    public SysUser getUser(String token) {
        DecodedJWT jwt = JWT.decode(token);
        SysUser sysUser = new SysUser();
        sysUser.setUsername(jwt.getClaim("username").asString());
        sysUser.setPassword(jwt.getClaim("password").asString());
        return sysUser;

    }
}
