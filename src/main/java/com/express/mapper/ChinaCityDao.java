package com.express.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.express.entity.ChinaCityEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 中国城市
 * 
 * @author Rock.Zhou
 * @email cool_fish@aliyun.com
 * @date 2020-12-02 13:46:34
 */
@Repository
@Mapper
public interface ChinaCityDao extends BaseMapper<ChinaCityEntity> {
	
}
