package com.express.service.impl;

import com.express.entity.ChinaCityEntity;
import com.express.mapper.ChinaCityDao;
import com.express.service.ChinaCityService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

@Service("chinaCityService")
public class ChinaCityServiceImpl extends ServiceImpl<ChinaCityDao, ChinaCityEntity> implements ChinaCityService {


}