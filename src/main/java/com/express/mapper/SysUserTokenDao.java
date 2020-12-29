package com.express.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.express.entity.SysUserTokenEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 用户 sys_user_token
 * 
 * @author Rock.Zhou
 * @email cool_fish@aliyun.com
 * @date 2020-12-25 16:48:51
 */
@DS("api")
@Repository
@Mapper
public interface SysUserTokenDao extends BaseMapper<SysUserTokenEntity> {

    /**
     * 创建用户
     * @param userNo
     * @param userPs
     * @return
     */
    int createUser(@Param("userNo") String userNo,@Param("userPs") String userPs);

    /**
     * 查询创建时间为三天前的账号
     * @param userNo
     * @param userPs
     * @return
     */
    List<Map<String, Object>> findIsExpired(@Param("userNo") String userNo, @Param("userPs") String userPs);
}
