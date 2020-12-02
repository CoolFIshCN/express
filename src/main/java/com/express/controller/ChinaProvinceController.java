package com.express.controller;

import java.util.Arrays;

import com.express.entity.ChinaProvinceEntity;
import com.express.service.ChinaProvinceService;
import com.express.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * 中国省份
 *
 * @author Rock.Zhou
 * @email cool_fish@aliyun.com
 * @date 2020-12-02 13:42:32
 */
@RestController
@RequestMapping("xhgz/chinaprovince")
public class ChinaProvinceController {
    @Autowired
    private ChinaProvinceService chinaProvinceService;


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		ChinaProvinceEntity chinaProvince = chinaProvinceService.getById(id);

        return R.ok().put("chinaProvince", chinaProvince);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChinaProvinceEntity chinaProvince){
		chinaProvinceService.save(chinaProvince);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ChinaProvinceEntity chinaProvince){
		chinaProvinceService.updateById(chinaProvince);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		chinaProvinceService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
