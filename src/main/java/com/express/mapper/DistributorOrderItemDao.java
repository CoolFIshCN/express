package com.express.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.express.entity.DistributorOrderItemEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 订单详情
 * 
 * @author Rock.Zhou
 * @email cool_fish@aliyun.com
 * @date 2020-12-03 15:12:09
 */
@Repository
@Mapper
public interface DistributorOrderItemDao extends BaseMapper<DistributorOrderItemEntity> {
	
}
