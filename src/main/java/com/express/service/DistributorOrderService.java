package com.express.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.express.dto.OrderDto;
import com.express.entity.DistributorOrderEntity;

import java.util.List;

/**
 * 订单
 *
 * @author Rock.Zhou
 * @email cool_fish@aliyun.com
 * @date 2020-12-03 15:07:56
 */
public interface DistributorOrderService extends IService<DistributorOrderEntity> {

    /**
     * 批量更新或新增
     *
     * @param orderDtoList
     * @param distributorId
     * @return
     */
    boolean updateOrSaveList(List<OrderDto> orderDtoList, Long distributorId);

}

