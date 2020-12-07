package com.express.service.impl;

import com.express.entity.DistributorAccountEntity;
import com.express.mapper.DistributorAccountDao;
import com.express.service.DistributorAccountService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("distributorAccountService")
public class DistributorAccountServiceImpl extends ServiceImpl<DistributorAccountDao, DistributorAccountEntity> implements DistributorAccountService {

}