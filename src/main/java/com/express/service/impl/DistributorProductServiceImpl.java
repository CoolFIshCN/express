package com.express.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.express.entity.DistributorProductEntity;
import com.express.mapper.DistributorProductDao;
import com.express.service.DistributorProductService;
import org.springframework.stereotype.Service;

@Service("distributorProductService")
public class DistributorProductServiceImpl extends ServiceImpl<DistributorProductDao, DistributorProductEntity> implements DistributorProductService {


}