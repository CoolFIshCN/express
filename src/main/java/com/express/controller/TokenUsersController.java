package com.express.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.express.annotation.PassToken;
import com.express.entity.SysUserTokenEntity;
import com.express.service.SysUserTokenService;
import com.express.util.DateUtils;
import com.express.util.JWTService;
import com.express.util.R;
import com.express.util.Response;
import io.jsonwebtoken.impl.crypto.JwtSigner;
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


    /**
     * jwt
     */
    @Autowired
    private JWTService jwtService;
    /**
     * 用户和token
     */
    @Autowired
    private SysUserTokenService userTokenService;


    /**
     * 创建用户
     * @return
     */
    @PassToken
    @PostMapping("/createUser")
    @ResponseBody
    public R createUser(@RequestBody Map<String,String> params){

        if (null == params.get("userNo") || null == params.get("userPs") || "".equals(params.get("userNo")) || "".equals(params.get("userPs"))){
            return R.error(401,"参数不全");
        }

        // 调用 查询是否重复
        int countByUserNo = userTokenService.countByUserNo(params.get("userNo"));
        if (countByUserNo > 0){
            return R.error(501,"用户名已经存在");
        }
        // 调用insert
        boolean flag = userTokenService.createUser(params);
        if (!flag){
            return R.error(500,"用户创建失败");
        }

        return R.ok("用户创建成功");
    }

    /**
     * 用户密码更新
     * @param params
     * @return
     */
    @PostMapping("/updatePassword")
    public R updatePassword(@RequestBody Map<String,String> params){


        return R.ok("用户密码更新成功");
    }

    /**
     * 申请token
     *
     * @param request
     * @param userNo
     * @param userPs
     * @return
     */
    @PassToken
    @PostMapping("/NewToken")
    @ResponseBody
    public Response newToken(HttpServletRequest request, @RequestParam("UID") String userNo, @RequestParam("PWD") String userPs) {
        //token
        String accessToken = "";
        String refreshToken = "";

        // 如果用户名错误返回401
        if (null == userNo || userNo.equals("")) {
            return Response.error().put("401", "账号或密码错误!");
        }
        // 查询创建时间为三天前的账号
        List<Map<String,Object>> resultList = userTokenService.findIsExpired(userNo, userPs);

        // 如果未查到
        if (null == resultList || resultList.size() < 1) {
            return Response.error("401", userNo+"不存在权限");
        }

        Map<String, Object> resultMap = resultList.get(0);

        String createDate = "";
        String expireDate = "";
        // 是否过期
        String isExpired = "";

        if (null != resultMap.get("createTime") && !"".equals(resultMap.get("createTime").toString())){
            createDate = resultMap.get("createTime").toString();
        }
        if (null != resultMap.get("expiredDate") && !"".equals(resultMap.get("expiredDate").toString())){
            expireDate = resultMap.get("expiredDate").toString();
        }
        // 是否过期
        isExpired = resultMap.get("isExpired").toString();

        // 如果过期
        if (isExpired.equalsIgnoreCase("Y")) {
            return Response.error("401", "User(" + userNo + ") 有效期至 " + expireDate);
        }

//        // 进销商id
//        Long distributorId = 0L;
//        if (null != resultMap.get("distributorId") && !"".equals(resultMap.get("distributorId").toString())){
//            distributorId = Long.parseLong(resultMap.get("distributorId").toString());
//        }else {
//            return Response.error("401","经销商参数未分配,请联系管理员");
//        }

        // 生成token
        Map<String,String> tokenMap = userTokenService.getToken(
                userNo.trim()
                ,userPs.trim());

        // 判断token是否有值
        if (null != tokenMap.get("access_token") || !"".equals(tokenMap.get("access_token"))){
            accessToken = tokenMap.get("access_token");
        }
        if (null != tokenMap.get("refresh_token") || !"".equals(tokenMap.get("refresh_token"))){
            refreshToken = tokenMap.get("refresh_token");
        }

        if ("".equals(accessToken) || "".equals(refreshToken)){
            return Response.error("500","申请token出错,请联系管理员!");
        }

        return new Response().put("access_token",accessToken).put("refresh_token",refreshToken);
    }

    /**
     * 更新token
     * @param userNo
     * @param refreshToken
     * @return
     */
    @PostMapping("/RefreshToken")
    @ResponseBody
    public Response refreshToken(@RequestHeader("Authentication")String token,@RequestParam("UID")String  userNo,@RequestParam("RefreshToken")String refreshToken){

        // accessToken 返回值
        String accessToken = "";
        // refreshToken 返回值
        String reRefreshToken = "";

        // 获取用户
        SysUserTokenEntity user = jwtService.getUser(token);
        if (null ==user || null == user.getUserNo()){
            return Response.error("401","未找到该用户");
        }
        if (null != user.getUserNo()){
            if (!user.getUserNo().equals(userNo)){
                return Response.error("401","未找到该用户");
            }
        }
        // 校验RefreshToken
        if (null != user.getRefreshToken() && !"".equals(user.getRefreshToken())){
            String userRefreshToken = user.getRefreshToken();
            if (!userRefreshToken.equals(refreshToken)){
                return new Response().put("401","无效refreshToken");
            }
        }else {
            return new Response().put("401","无效refreshToken");
        }

        // 生成token
        Map<String,String> tokenMap = userTokenService.getDoubleToken(user);

        // 判断token是否有值
        if (null != tokenMap.get("access_token") || !"".equals(tokenMap.get("access_token"))){
            accessToken = tokenMap.get("access_token");
        }
        if (null != tokenMap.get("refresh_token") || !"".equals(tokenMap.get("refresh_token"))){
            reRefreshToken = tokenMap.get("refresh_token");
        }

        if ("".equals(accessToken) || "".equals(reRefreshToken)){
            return Response.error("500","申请token出错,请联系管理员!");
        }

        return new Response().put("access_token",accessToken).put("refresh_token",reRefreshToken);
    }

    /**
     * 检查token
     * @param token
     * @return
     */
    @PostMapping("/VerifyToken")
    @ResponseBody
    public Response verifyToken(@RequestHeader("Authentication")String token){
        if (null == token || token.trim().equals("")){
            return Response.error("401","无效token");
        }
        Boolean flag = jwtService.decryptToken(token);
        if (!flag){
            return new Response("401","无效token");
        }
        return Response.ok("token认证成功");
    }
}
