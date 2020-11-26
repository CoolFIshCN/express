package com.express.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.express.entity.ProductEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 物料
 * 
 * @author Rock.Zhou
 * @email cool_fish@aliyun.com
 * @date 2020-11-24 10:23:22
 */

@Repository
@Mapper
public interface ProductDao extends BaseMapper<ProductEntity> {

    /**
     * 存入一个物料对象
     * @param productEntity
     * @return
     */
    int insertOne(ProductEntity productEntity);
}
