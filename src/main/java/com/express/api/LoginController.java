package com.express.api;

import com.express.annotation.PassToken;
import com.express.entity.SysUserTokenEntity;
import com.express.util.JWTService;
import com.express.entity.SysUser;
import com.express.service.UserService;
import com.express.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private JWTService jwtService;


//    /**
//     * 生成token并返回到前端
//     * @param sysUser
//     * @return
//     */
//    @PassToken(required = true)
//    @PostMapping("/doLogin")
//    public R login(@RequestBody SysUser sysUser) {
//
//        // 获取用户信息,可自行创建User类
//        SysUser user = userService.checkPassword(sysUser.getUsername(),sysUser.getPassword());
//        if (null == user || null == user.getId()){
//            return R.error("账号或密码错误");
//        }
//        String token = jwtService.getToken(user);
//
//        return R.ok().put("token",token);
//    }


    /**
     * 获取token后,解析获取token中封装的user对象信息
     * @param token
     * @return
     */
    @GetMapping("/getUserName")
    public R token(String token){

        SysUserTokenEntity user = jwtService.getUser(token);
        if (null != user && !"".equals(user.getUserNo())){
            return R.ok().put("userName",user.getUserNo());
        }
        return R.error();
    }
}
