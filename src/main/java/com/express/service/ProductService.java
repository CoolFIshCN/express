package com.express.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.express.dto.ProductDto;
import com.express.entity.ProductEntity;
import com.express.entity.SysUser;

import java.util.List;

/**
 * 物料
 *
 * @author Rock.Zhou
 * @email cool_fish@aliyun.com
 * @date 2020-11-24 10:23:22
 */
public interface ProductService extends IService<ProductEntity> {

    /**
     * 更新或者添加物料
     * @param productList
     * @param
     * @return
     */
    boolean updateOrSave(List<ProductDto> productList, SysUser user);

    /**
     * 根据经销商id和物料编号查询
     * @param distributorId
     * @param
     * @return
     */
    List<ProductDto> getByProductNumber(Long distributorId, List<String> productNumberList);
}

