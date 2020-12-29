package com.express.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.express.annotation.AuthorityCheck;
import com.express.entity.DistributorStoreEntity;
import com.express.entity.SysUser;
import com.express.entity.SysUserTokenEntity;
import com.express.mapper.UserMapper;
import com.express.service.DistributorStoreService;
import com.express.util.JWTService;
import com.express.util.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


/**
 * 经销商门店
 *
 * @author Rock.Zhou
 * @email cool_fish@aliyun.com
 * @date 2020-12-02 11:02:17
 */
@Api(tags = "经销商门店")
@RestController
@RequestMapping("/distributorStore")
public class DistributorStoreController {

    // 最大条数
    @Value("${store.maxSize}")
    private volatile int STORE_MAX_SIZE;
    /**
     * 经销商门店
     */
    @Autowired
    private DistributorStoreService distributorStoreService;
    /**
     * 用户
     */
    @Autowired
    private UserMapper userMapper;
    // jwt
    @Autowired
    private JWTService jwtService;


    /**
     * 批量修改或者新增
     *
     * @param entityList
     * @return
     */
    @PostMapping("/updateOrSave")
    @AuthorityCheck(value = "distributorStore:updateOrSave")
    @ResponseBody
    public R updateOrSave(@RequestHeader("token") String token, @RequestBody List<DistributorStoreEntity> entityList) {
        //获取用户信息
        SysUserTokenEntity user = jwtService.getUser(token);
        if (null == user || null == user.getUserNo()) {
            return R.error("无效token");
        }
        // 获取进销商id
        SysUser byUsername = userMapper.findByUsername(user.getUserNo());
        if (null == byUsername || null == byUsername.getDistributorId()) {
            return R.error("无效经销商");
        }
        Long distributorId = byUsername.getDistributorId();

        // 最大长度
        if (null != entityList && entityList.size() > STORE_MAX_SIZE) {
            return R.error("请求最大长度不得超过：" + STORE_MAX_SIZE);
        }

        boolean b = distributorStoreService.updateOrSave(entityList, byUsername);

        if (!b) {
            return R.error("批量修改或者新增失败");
        }

        return R.ok();
    }

    /**
     * @param token
     * @param params
     * @return
     */
    @PostMapping("/getByStoreNumber")
    @AuthorityCheck(value = "distributorStore:getByStoreNumber")
    @ResponseBody
    public R getByStoreNumber(@RequestHeader("token") String token, @RequestBody Map<String, Object> params) {
        List<String> storeNumberList = (ArrayList<String>) params.get("storeNumberList");

        //获取用户信息
        SysUserTokenEntity user = jwtService.getUser(token);
        if (null == user || null == user.getUserNo()) {
            return R.error("无效token");
        }
        // 获取进销商id
        SysUser byUsername = userMapper.findByUsername(user.getUserNo());
        if (null == byUsername || null == byUsername.getDistributorId()) {
            return R.error("无效经销商");
        }
        // 最大长度
        if (null != storeNumberList && storeNumberList.size() == 0){
            return R.error("参数有误！");
        }
        if (null != storeNumberList && storeNumberList.size() > STORE_MAX_SIZE) {
            return R.error("请求最大长度不得超过：" + STORE_MAX_SIZE);
        }
        Long distributorId = byUsername.getDistributorId();

        List<DistributorStoreEntity> reList = new ArrayList<>();

        List<DistributorStoreEntity> entityList = distributorStoreService.getByStoreNumber(storeNumberList,distributorId);

        if (null != entityList && entityList.size()>0){
            reList = entityList;
        }

        return R.ok().put("reList",reList);
    }
}