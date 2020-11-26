package com.express.api;



import com.express.util.JWTService;
import com.express.entity.SysUser;
import com.express.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private JWTService jwtService;


    //生成token并返回到前端
    @PostMapping("/doLogin")
    public String login(@RequestBody SysUser sysUser) {

        //获取用户信息,可自行创建User类
        SysUser res = userService.checkPassword(sysUser.getUsername(),sysUser.getPassword());
        Map<String,String> userInfo = createUserInfoMap(res);

        String token = jwtService.createToken(userInfo, 1);
        return token;
    }

    private Map<String, String> createUserInfoMap(SysUser res) {
        Map<String,String> userInfo = new HashMap<>();
        userInfo.put("username", res.getUsername());
        userInfo.put("password", res.getPassword());
        return userInfo;

    }



    //获取token后,解析获取token中封装的user对象信息

    @RequestMapping("/token")
    public SysUser token(String token){
        SysUser user = jwtService.getUser(token);
        return user;
    }
}
