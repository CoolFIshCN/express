package com.express.dto.zhongyou;


import java.util.HashMap;
import java.util.List;

/**
 * 众游批量下单成功返回返回
 */
public class BatchCreateOrderRespListDto extends HashMap<String,Object> {
    String cargoName;

    String waybillCode;

    List<String> packageCode;

    String customerOrderNo;

    String platformNo;
    String  payTypeName;
}
