package com.express.service.impl;

import com.express.entity.DistributorOrderEntity;
import com.express.mapper.DistributorOrderDao;
import com.express.service.DistributorOrderService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("distributorOrderService")
public class DistributorOrderServiceImpl extends ServiceImpl<DistributorOrderDao, DistributorOrderEntity> implements DistributorOrderService {


}