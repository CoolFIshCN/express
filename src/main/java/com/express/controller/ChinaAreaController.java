package com.express.controller;

import java.util.Arrays;

import com.express.entity.ChinaAreaEntity;
import com.express.service.ChinaAreaService;
import com.express.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 中国 区/县
 * @author Rock.Zhou
 * @email cool_fish@aliyun.com
 * @date 2020-12-02 13:49:45
 */
@RestController
@RequestMapping("xhgz/chinaarea")
public class ChinaAreaController {
    @Autowired
    private ChinaAreaService chinaAreaService;


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		ChinaAreaEntity chinaArea = chinaAreaService.getById(id);

        return R.ok().put("chinaArea", chinaArea);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChinaAreaEntity chinaArea){
		chinaAreaService.save(chinaArea);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ChinaAreaEntity chinaArea){
		chinaAreaService.updateById(chinaArea);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		chinaAreaService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
