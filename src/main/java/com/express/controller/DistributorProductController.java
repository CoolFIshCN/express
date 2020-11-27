package com.express.controller;

import java.util.Arrays;
import java.util.Map;

import com.express.entity.DistributorProductEntity;
import com.express.service.DistributorProductService;
import com.express.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * ${comments}
 *
 * @author Rock.Zhou
 * @email cool_fish@aliyun.com
 * @date 2020-11-26 14:46:06
 */
@RestController
@RequestMapping("xhgz/distributorproduct")
public class DistributorProductController {
    @Autowired
    private DistributorProductService distributorProductService;


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		DistributorProductEntity distributorProduct = distributorProductService.getById(id);

        return R.ok().put("distributorProduct", distributorProduct);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DistributorProductEntity distributorProduct){
		distributorProductService.save(distributorProduct);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody DistributorProductEntity distributorProduct){
		distributorProductService.updateById(distributorProduct);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		distributorProductService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
