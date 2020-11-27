package com.express.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.express.entity.DistributorProductEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 经销商物料
 * 
 * @author Rock.Zhou
 * @email cool_fish@aliyun.com
 * @date 2020-11-26 14:46:06
 */
@Repository
@Mapper
public interface DistributorProductDao extends BaseMapper<DistributorProductEntity> {

    /**
     * 插入一个经销商物料
     * @param distributorProductEntity
     */
    void insertOne(DistributorProductEntity distributorProductEntity);
}
