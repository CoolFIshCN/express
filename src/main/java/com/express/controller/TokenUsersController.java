package com.express.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.express.entity.SysUserTokenEntity;
import com.express.service.SysUserTokenService;
import com.express.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


/**
 * 用户token
 *
 * @author Rock.Zhou
 * @email cool_fish@aliyun.com
 * @date 2020-12-25 10:49:09
 */
@RestController
@RequestMapping("/APIServer/api")
public class TokenUsersController {
    @Autowired
    private SysUserTokenService userTokenService;

    /**
     * 申请token
     *
     * @param request
     * @param userNo
     * @param userPs
     * @return
     */
    @PostMapping("/NewToken")
    public Response newToken(HttpServletRequest request, @RequestParam("UID") String userNo, @RequestParam("PWD") String userPs) {
        //token
        String accessToken = "";
        String refreshToken = "";

        // 如果用户名错误返回401
        if (null == userNo || userNo.equals("")) {
            return Response.error().put("401", "账号或密码错误!");
        }
        // 查询创建时间为三天前的账号
        List<SysUserTokenEntity> userList = userTokenService.findIsExpired(userNo, userPs);

        // 如果未查到
        if (null == userList || userList.size() < 1) {
            return Response.error("401", userNo+"不存在权限");
        }

        SysUserTokenEntity userTokenEntity = userList.get(0);
        Date createDate = userTokenEntity.getCreateTime();
        Date expireDate = userTokenEntity.getExpireAt();
        // 是否过期
        String isExpired = userTokenEntity.getIsExpired();

        // 如果过期
        if (isExpired.equalsIgnoreCase("Y")) {
            return Response.error("401", "User(" + userNo + ") 有效期至 " + createDate);
        }else {
            // ip
            String ip = request.getRemoteAddr();
        }

        // 生成token
        Map<String,String> tokenMap = userTokenService.getToken(
                userNo.trim()
                ,userPs.trim()
                ,userTokenEntity.getDistributorId()
                ,1000*60*60,false);

        // 判断token是否有值
        if (null != tokenMap.get("accessToken") || !"".equals(tokenMap.get("accessToken"))){
            accessToken = tokenMap.get("accessToken");
        }
        if (null != tokenMap.get("refreshToken") || !"".equals(tokenMap.get("refreshToken"))){
            refreshToken = tokenMap.get("refreshToken");
        }

        if ("".equals(accessToken) || "".equals(accessToken)){
            return Response.error("500","申请token出错,请联系管理员!");
        }

        return new Response().put("accessToken",accessToken).put("refreshToken",refreshToken);
    }
}
