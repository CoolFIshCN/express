package com.express.controller;

import java.util.Arrays;
import java.util.Map;

import com.express.entity.DistributorOrderEntity;
import com.express.service.DistributorOrderService;
import com.express.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



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



    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		DistributorOrderEntity distributorOrder = distributorOrderService.getById(id);

        return R.ok().put("distributorOrder", distributorOrder);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DistributorOrderEntity distributorOrder){
		distributorOrderService.save(distributorOrder);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody DistributorOrderEntity distributorOrder){
		distributorOrderService.updateById(distributorOrder);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		distributorOrderService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
