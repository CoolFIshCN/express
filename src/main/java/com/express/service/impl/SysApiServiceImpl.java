package com.express.service.impl;

import com.express.entity.SysApiEntity;
import com.express.mapper.SysApiDao;
import com.express.service.SysApiService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("sysApiService")
public class SysApiServiceImpl extends ServiceImpl<SysApiDao, SysApiEntity> implements SysApiService {



}