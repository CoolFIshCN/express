package com.express.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.express.entity.TemperatureTypeEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 存储方式
 * 
 * @author Rock.Zhou
 * @email cool_fish@aliyun.com
 * @date 2020-11-24 09:40:34
 */
@Repository
@Mapper
public interface TemperatureTypeDao extends BaseMapper<TemperatureTypeEntity> {
	
}
