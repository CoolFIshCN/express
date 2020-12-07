package com.express.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.express.entity.DistributorAccountEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 *
 * 
 * @author Rock.Zhou
 * @email cool_fish@aliyun.com
 * @date 2020-12-07 11:23:08
 */
@Repository
@Mapper
public interface DistributorAccountDao extends BaseMapper<DistributorAccountEntity> {
	
}
