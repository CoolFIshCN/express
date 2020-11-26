package com.express.controller;


import com.express.dto.ProductDto;
import com.express.entity.SysUser;
import com.express.mapper.UserMapper;
import com.express.service.ProductService;
import com.express.util.JWTService;
import com.express.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
     * 物料
     */
    @Autowired
    private ProductService productService;

    // jwt
    @Autowired
    private JWTService jwtService;

    /**
     * 用户
     */
    @Autowired
    private UserMapper userMapper;

    /**
     * 更新或者添加物料
     * @param productList
     * @return
     */
    @PostMapping("/updateOrSave")
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
            return R.error("无效进销商");
        }
        Long distributorId = byUsername.getDistributorId();

        // 最大长度
        if (null != productList && productList.size() > PRODUCT_MAX_SIZE){
            return R.error("请求最大长度不得超过："+PRODUCT_MAX_SIZE);
        }
        // 更新或者添加物料
        boolean b = productService.updateOrSave(productList,distributorId);


        return R.ok();
    }
}
