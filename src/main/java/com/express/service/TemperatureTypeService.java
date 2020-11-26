package com.express.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.express.entity.TemperatureTypeEntity;

import java.util.List;


/**
 * ${comments}
 *
 * @author Rock.Zhou
 * @email cool_fish@aliyun.com
 * @date 2020-11-24 09:40:34
 */
public interface TemperatureTypeService extends IService<TemperatureTypeEntity> {

    /**
     * 获取所有存储方式
     * @return
     */
    List<TemperatureTypeEntity> getAll();
}

