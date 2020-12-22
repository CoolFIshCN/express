package com.express.controller;

import com.express.dto.DeliveryOrderDTO;
import com.express.dto.DeliveryOrderForm;
import com.express.service.DeliveryOrderService;
import com.express.util.ObjectConvertUtil;
import com.express.util.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 物流订单
 */

@Api(tags = "物流订单")
@RestController
@RequestMapping("/logistics")
public class LogisticsController {


    /**
     * 物流订单
     */
    @Autowired
    private DeliveryOrderService deliveryOrderService;


    /**
     * 重邮出货
     *
     * @param params
     * @return
     */
    @PostMapping("/deliveryOrder")
    @ResponseBody
    public R deliveryOrder(@RequestBody DeliveryOrderForm params) {

        // 获取物流方
        String pointToStr = "";
        if (null != params.getPointTo() && !"".equals(params.getPointTo())) {
            pointToStr = params.getPointTo();
        } else {
            return R.error("未指定物流方");
        }
        // 获取数据
        List<DeliveryOrderDTO>  paramsList = new ArrayList<>();
        if (null != params.getParamList()){
             paramsList = params.getParamList();
        }else{
            return R.error("订单数据为空");
        }


        // 创建物流订单业务 返回标识
        boolean flag = false;

        // 众邮
        if (pointToStr.equals("zhongYou")){
            try {
                flag = deliveryOrderService.zhongYouDeliveryOrder(paramsList);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (!flag) {
            return R.error("发货失败");
        }

        return R.ok();
    }
}
