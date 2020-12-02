package com.express.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.express.entity.DistributorStoreEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 进销商门店
 * 
 * @author Rock.Zhou
 * @email cool_fish@aliyun.com
 * @date 2020-12-02 11:02:17
 */
@Repository
@Mapper
public interface DistributorStoreDao extends BaseMapper<DistributorStoreEntity> {

    /**
     * 新增门店
     * @param entity
     * @return
     */
    int insertOne(DistributorStoreEntity entity);
}
