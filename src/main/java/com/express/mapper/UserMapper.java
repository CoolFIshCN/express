package com.express.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.express.entity.SysUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author jinbin
 * @date 2018-07-08 20:44
 */
@Repository
public interface UserMapper extends BaseMapper<SysUser> {
    SysUser findByUsername(@Param("username") String username);
    SysUser findUserById(@Param("Id") String Id);
}
