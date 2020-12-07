package com.express.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.express.dto.OrderDto;
import com.express.dto.ProductDto;
import com.express.entity.DistributorOrderEntity;
import com.express.entity.SysUser;
import com.express.mapper.UserMapper;
import com.express.service.DistributorOrderService;
import com.express.util.JWTService;
import com.express.util.R;
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
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        DistributorOrderEntity distributorOrder = distributorOrderService.getById(id);

        return R.ok().put("distributorOrder", distributorOrder);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DistributorOrderEntity distributorOrder) {
        distributorOrderService.save(distributorOrder);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody DistributorOrderEntity distributorOrder) {
        distributorOrderService.updateById(distributorOrder);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        distributorOrderService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

    /**
     * 批量更新或新增
     *
     * @param orderDtoList
     * @return
     */
    @PostMapping("/updateOrSaveList")
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
