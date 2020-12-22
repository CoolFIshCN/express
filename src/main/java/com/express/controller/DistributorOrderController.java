package com.express.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.express.annotation.AuthorityCheck;
import com.express.dto.OrderDto;
import com.express.dto.ProductDto;
import com.express.entity.DistributorOrderEntity;
import com.express.entity.SysUser;
import com.express.mapper.UserMapper;
import com.express.service.DistributorOrderService;
import com.express.util.JWTService;
import com.express.util.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


/**
 * 订单
 *
 * @author Rock.Zhou
 * @email cool_fish@aliyun.com
 * @date 2020-12-03 15:07:56
 */
@Api(tags = "订单")
@RestController
@RequestMapping("/distributorOrder")
public class DistributorOrderController {
    @Autowired
    private DistributorOrderService distributorOrderService;

    @Value("${order.maxSize}")
    private volatile int ORDER_MAX_SIZE;

    /**
     * 用户
     */
    @Autowired
    private UserMapper userMapper;
    // jwt
    @Autowired
    private JWTService jwtService;


    /**
     * 批量更新或新增
     *
     * @param orderDtoList
     * @return
     */
    @PostMapping("/updateOrSaveList")
    @AuthorityCheck(value = "distributorOrder:updateOrSaveList")
    @ResponseBody
    public R updateOrSaveList(@RequestHeader("token") String token, @RequestBody List<OrderDto> orderDtoList) {
        //获取用户信息
        SysUser user  = jwtService.getUser(token);
        if (null ==user || null == user.getUsername()){
            return R.error("无效token");
        }
        // 获取进销商id
        SysUser byUsername = userMapper.findByUsername(user.getUsername());
        if (null ==byUsername || null == byUsername.getDistributorId()){
            return R.error("无效经销商");
        }
        Long distributorId = byUsername.getDistributorId();

        // 最大长度
        if (null != orderDtoList && orderDtoList.size() > ORDER_MAX_SIZE){
            return R.error("请求最大长度不得超过："+ORDER_MAX_SIZE);
        }

        boolean b = distributorOrderService.updateOrSaveList(orderDtoList,distributorId);
        if (!b){
            return R.error();
        }
        return R.ok();
    }



}
