package com.express.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.express.entity.SysApiEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * api
 * 
 * @author Rock.Zhou
 * @email cool_fish@aliyun.com
 * @date 2020-12-08 16:28:39
 */
@Repository
@Mapper
public interface SysApiDao extends BaseMapper<SysApiEntity> {
	
}
