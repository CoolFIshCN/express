package com.express.controller;

import java.util.Arrays;
import java.util.Map;

import com.express.entity.DistributorOrderItemEntity;
import com.express.service.DistributorOrderItemService;
import com.express.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * 订单详情
 *
 * @author Rock.Zhou
 * @email cool_fish@aliyun.com
 * @date 2020-12-03 15:12:09
 */
@RestController
@RequestMapping("/distributorOrderItem")
public class DistributorOrderItemController {
    @Autowired
    private DistributorOrderItemService distributorOrderItemService;


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		DistributorOrderItemEntity distributorOrderItem = distributorOrderItemService.getById(id);

        return R.ok().put("distributorOrderItem", distributorOrderItem);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DistributorOrderItemEntity distributorOrderItem){
		distributorOrderItemService.save(distributorOrderItem);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody DistributorOrderItemEntity distributorOrderItem){
		distributorOrderItemService.updateById(distributorOrderItem);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		distributorOrderItemService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
