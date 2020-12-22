package com.express.controller;

import java.util.Arrays;
import java.util.Map;

import com.express.entity.DistributorOrderItemEntity;
import com.express.service.DistributorOrderItemService;
import com.express.util.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * 订单详情
 *
 * @author Rock.Zhou
 * @email cool_fish@aliyun.com
 * @date 2020-12-03 15:12:09
 */
@Api(tags = "订单详情")
@RestController
@RequestMapping("/distributorOrderItem")
public class DistributorOrderItemController {
    @Autowired
    private DistributorOrderItemService distributorOrderItemService;



}
