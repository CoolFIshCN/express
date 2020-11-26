package com.express.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.express.entity.TemperatureTypeEntity;
import com.express.mapper.TemperatureTypeDao;
import com.express.service.TemperatureTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("temperatureTypeService")
public class TemperatureTypeServiceImpl extends ServiceImpl<TemperatureTypeDao, TemperatureTypeEntity> implements TemperatureTypeService {


    @Autowired
    private TemperatureTypeDao temperatureTypeDao;
    /**
     * 获取所有存储方式
     * @return
     */
    @Override
    public List<TemperatureTypeEntity> getAll() {
        List<TemperatureTypeEntity> reList = new ArrayList<>();

        List<TemperatureTypeEntity> temperatureTypeEntities = temperatureTypeDao.selectList(new QueryWrapper<>());

        if (null != temperatureTypeEntities && temperatureTypeEntities.size()>0){
            reList = temperatureTypeEntities;
        }

        return reList;
    }
}