package com.express.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.express.entity.ChinaAreaEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * ${comments}
 * 
 * @author Rock.Zhou
 * @email cool_fish@aliyun.com
 * @date 2020-12-02 13:49:45
 */
@Repository
@Mapper
public interface ChinaAreaDao extends BaseMapper<ChinaAreaEntity> {
	
}
