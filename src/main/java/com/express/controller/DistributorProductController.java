package com.express.controller;

import java.util.Arrays;
import java.util.Map;

import com.express.entity.DistributorProductEntity;
import com.express.service.DistributorProductService;
import com.express.util.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * 经销商物料
 *
 * @author Rock.Zhou
 * @email cool_fish@aliyun.com
 * @date 2020-11-26 14:46:06
 */
@Api(tags = "经销商物料")
@RestController
@RequestMapping("xhgz/distributorproduct")
public class DistributorProductController {
    @Autowired
    private DistributorProductService distributorProductService;

}
