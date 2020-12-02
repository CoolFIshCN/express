package com.express.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.express.entity.ChinaProvinceEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 中国省份
 * 
 * @author Rock.Zhou
 * @email cool_fish@aliyun.com
 * @date 2020-12-02 13:42:32
 */
@Repository
@Mapper
public interface ChinaProvinceDao extends BaseMapper<ChinaProvinceEntity> {
	
}
