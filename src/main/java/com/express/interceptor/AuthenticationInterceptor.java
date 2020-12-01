package com.express.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.express.annotation.PassToken;
import com.express.annotation.UserLoginToken;
import com.express.entity.SysUser;
import com.express.service.UserService;
import com.express.util.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.Method;


/**
 * @author
 * @date 2018-07-08 20:41
 */
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Autowired
    UserService userService;

    @Autowired
    JWTService jwtService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {

        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json; charset=utf-8");
        JSONObject res = new JSONObject();

        String token = httpServletRequest.getHeader("token");// 从 http 请求头中取出 token
        // 如果不是映射到方法直接通过
        if (!(object instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();
        //检查是否有passtoken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }


        // 执行认证
        if (token == null) {
            httpServletResponse.setCharacterEncoding("UTF-8");
            httpServletResponse.setContentType("application/json; charset=utf-8");

            throw new RuntimeException("无token，请重新登录");
        }
        // 验证
        Boolean tokenFlag = jwtService.decryptToken(token);
        if (!tokenFlag) {

            res.put("code", "501");
            res.put("msg", "无效token");
            PrintWriter out = null;
            out = httpServletResponse.getWriter();
            out.write(res.toString());
            out.flush();
            out.close();
            return false;
        }
        // 获取 token 中的 user id
        String userId;
        try {
            userId = jwtService.getUser(token).getId();
        } catch (JWTDecodeException j) {
            res.put("code", "502");
            res.put("msg", "无效token");
            PrintWriter out = null;
            out = httpServletResponse.getWriter();
            out.write(res.toString());
            out.flush();
            out.close();
            throw new RuntimeException("502，无效token");
        }
        SysUser sysUser = userService.findUserById(userId);
        if (sysUser == null) {
            res.put("code", "503");
            res.put("msg", "无效token");
            PrintWriter out = null;
            out = httpServletResponse.getWriter();
            out.write(res.toString());
            out.flush();
            out.close();
            throw new RuntimeException("用户不存在，请重新登录");
        } else {
            // 验证token
            Boolean b = jwtService.decryptToken(token);


            if (!b) {
                res.put("code", "502");
                res.put("msg", "无效token");
                PrintWriter out = null;
                out = httpServletResponse.getWriter();
                out.write(res.toString());
                out.flush();
                out.close();
            }
        }
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
