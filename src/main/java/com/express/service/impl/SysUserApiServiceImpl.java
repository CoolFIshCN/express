package com.express.service.impl;

import com.express.entity.SysUserApiEntity;
import com.express.mapper.SysUserApiDao;
import com.express.service.SysUserApiService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

@Service("sysUserApiService")
public class SysUserApiServiceImpl extends ServiceImpl<SysUserApiDao, SysUserApiEntity> implements SysUserApiService {


}