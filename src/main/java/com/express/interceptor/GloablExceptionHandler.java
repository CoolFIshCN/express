package com.express.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.express.util.R;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author jinbin
 * @date 2018-07-08 22:37
 */
@Slf4j
@ControllerAdvice
public class GloablExceptionHandler {
    protected static final Logger logger = LoggerFactory.getLogger(GloablExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public R handleException(Exception e) {
        e.printStackTrace();
        String msg = e.getMessage();
        if (msg == null || msg.equals("")) {
            msg = "服务器出错";
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message", msg);
        logger.error(msg);
        return R.error();
    }

}
