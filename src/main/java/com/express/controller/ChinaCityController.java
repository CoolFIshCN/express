package com.express.controller;

import java.util.Arrays;

import com.express.entity.ChinaCityEntity;
import com.express.service.ChinaCityService;
import com.express.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 中国城市
 *
 * @author Rock.Zhou
 * @email cool_fish@aliyun.com
 * @date 2020-12-02 13:46:34
 */
@RestController
@RequestMapping("xhgz/chinacity")
public class ChinaCityController {
    @Autowired
    private ChinaCityService chinaCityService;



    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		ChinaCityEntity chinaCity = chinaCityService.getById(id);

        return R.ok().put("chinaCity", chinaCity);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChinaCityEntity chinaCity){
		chinaCityService.save(chinaCity);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ChinaCityEntity chinaCity){
		chinaCityService.updateById(chinaCity);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		chinaCityService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
