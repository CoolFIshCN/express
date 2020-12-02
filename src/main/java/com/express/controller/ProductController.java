package com.express.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.express.annotation.PassToken;
import com.express.annotation.UserLoginToken;
import com.express.dto.ProductDto;
import com.express.entity.SysUser;
import com.express.mapper.UserMapper;
import com.express.service.ProductService;
import com.express.util.JWTService;
import com.express.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * 外部 api 物料
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    // 最大条数
    @Value("${product.maxSize}")
    private volatile int PRODUCT_MAX_SIZE;
    /**
     * 用户
     */
    @Autowired
    private UserMapper userMapper;
    // jwt
    @Autowired
    private JWTService jwtService;
    /**
     * 物料
     */
    @Autowired
    private ProductService productService;


    /**
     * 更新或者添加物料
     * @param productList
     * @return
     */
    @PostMapping("/updateOrSave")
    @Validated
    @ResponseBody
    public R updateOrSave(@RequestHeader("token")String token,@RequestBody List<ProductDto> productList){
        //获取用户信息
        SysUser user  = jwtService.getUser(token);
        if (null ==user || null == user.getUsername()){
            return R.error("无效token");
        }
        // 获取进销商id
        SysUser byUsername = userMapper.findByUsername(user.getUsername());
        if (null ==byUsername || null == byUsername.getDistributorId()){
            return R.error("无效经销商");
        }
        Long distributorId = byUsername.getDistributorId();

        // 最大长度
        if (null != productList && productList.size() > PRODUCT_MAX_SIZE){
            return R.error("请求最大长度不得超过："+PRODUCT_MAX_SIZE);
        }
        // 更新或者添加物料
        boolean b = productService.updateOrSave(productList,byUsername);


        return R.ok();
    }


    /**
     * 根据物料编号获取物料所有信息
     * @param token
     * @param
     * @return
     */
    @PostMapping("/getByProductNumber")
    @ResponseBody
    public R getByProductNumber(@RequestHeader("token")String token,@RequestBody Map<String,Object> params){

        // 提取物料编号
        List<String>productNumberList = (ArrayList<String>) params.get("productNumberList");


        //获取用户信息
        SysUser user  = jwtService.getUser(token);
        if (null ==user || null == user.getUsername()){
            return R.error("无效token");
        }
        // 获取进销商id
        SysUser byUsername = userMapper.findByUsername(user.getUsername());
        if (null ==byUsername || null == byUsername.getDistributorId()){
            return R.error("无效经销商");
        }
        // 最大长度
        if (null != productNumberList && productNumberList.size() > PRODUCT_MAX_SIZE){
            return R.error("请求最大长度不得超过："+PRODUCT_MAX_SIZE);
        }

        Long distributorId = byUsername.getDistributorId();

        List<ProductDto> reList = new ArrayList<>();
        // 查询
        List<ProductDto> productDtoList = productService.getByProductNumber(distributorId,productNumberList);

        if (null != productDtoList && productDtoList.size() > 0){
            reList = productDtoList;
        }

        return R.ok().put("reList",reList);
    }
}
