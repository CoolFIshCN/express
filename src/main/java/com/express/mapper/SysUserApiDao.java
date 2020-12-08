package com.express.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.express.entity.SysUserApiEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * ${comments}
 * 
 * @author Rock.Zhou
 * @email cool_fish@aliyun.com
 * @date 2020-12-08 16:32:35
 */
@Repository
@Mapper
public interface SysUserApiDao extends BaseMapper<SysUserApiEntity> {
	
}
