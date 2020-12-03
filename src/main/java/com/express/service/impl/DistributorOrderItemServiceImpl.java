package com.express.service.impl;

import com.express.entity.DistributorOrderItemEntity;
import com.express.mapper.DistributorOrderItemDao;
import com.express.service.DistributorOrderItemService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("distributorOrderItemService")
public class DistributorOrderItemServiceImpl extends ServiceImpl<DistributorOrderItemDao, DistributorOrderItemEntity> implements DistributorOrderItemService {

}