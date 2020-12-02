package com.express.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.express.entity.DistributorStoreEntity;
import com.express.entity.SysUser;

import java.util.List;


/**
 * 进销商门店
 *
 * @author Rock.Zhou
 * @email cool_fish@aliyun.com
 * @date 2020-12-02 11:02:17
 */
public interface DistributorStoreService extends IService<DistributorStoreEntity> {

    /**
     * 批量修改或者新增
     *
     * @param entityList
     * @param user
     * @return
     */
    boolean updateOrSave(List<DistributorStoreEntity> entityList, SysUser user);

    /**
     * 批量查询门店
     * @param storeNumberList
     * @param distributorId
     * @return
     */
    List<DistributorStoreEntity> getByStoreNumber(List<String> storeNumberList, Long distributorId);
}

