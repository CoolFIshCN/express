package com.express.service;


import com.express.dto.DeliveryOrderDTO;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.Map;

/**
 * 物流订单
 *
 * @author Rock.Zhou
 * @email cool_fish@aliyun.com
 * @date 2020-12-14 09:07:56
 */
public interface DeliveryOrderService {



    /**
     * 众邮发货
     * @param params
     * @return 发货是否成功
     */
    boolean zhongYouDeliveryOrder(List<DeliveryOrderDTO> params) throws Exception;
}
