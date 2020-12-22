package com.express.service.impl;

import com.alibaba.fastjson.JSON;
import com.express.dto.DeliveryOrderDTO;
import com.express.dto.zhongyou.BatchCreateOrderConsignInfoDto;
import com.express.dto.zhongyou.BatchCreateOrderCustomerInfoDto;
import com.express.dto.zhongyou.BatchCreateOrderDto;
import com.express.dto.zhongyou.BatchCreateOrderParticipantInfoDto;
import com.express.service.DeliveryOrderService;
import com.express.util.ZhongYouUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;


/**
 * 物流订单
 *
 * @author Rock.Zhou
 * @email cool_fish@aliyun.com
 * @date 2020-12-14 09:07:56
 */
@Service
public class DeliveryOrderServiceImpl implements DeliveryOrderService {

    @Value("${zhongYou.v}")
    private volatile String ZHONGYOU_VERSION;

    @Value("${zhongYou.accessToken}")
    private volatile String ZHONGYOU_ACCESSTOKEN;

    @Value("${zhongYou.appKey}")
    private volatile String ZHONGYOU_APPKEY;

    @Value("${zhongYou.appSecret}")
    private volatile String ZHONGYOU_APPSECRET;

    /**
     * 众邮发货
     *
     * @param params
     * @return
     */
    @Override
    public boolean zhongYouDeliveryOrder(List<DeliveryOrderDTO> params){

        // 组装数据
        List<TreeMap<String, Object>> paramsList = this.createZhongYouDeliveryOrder(params);
        String paramsJson = JSON.toJSONString(paramsList);

        // 设置调用method
        String mothod = "zhongyouex.api.order.createOrderForCustom";

        // 获取当前时间
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"), Locale.CHINESE);
        String timestamp = dateFormat.format(cal.getTime());


        // 生成签名
        String sign = ZhongYouUtil.buildSign(timestamp, ZHONGYOU_VERSION
                , mothod, paramsJson, ZHONGYOU_ACCESSTOKEN, ZHONGYOU_APPKEY, ZHONGYOU_APPSECRET);

        // 拼接url
        String frontUrl = "https://test-proxy.zhongyouex.com/routerjson";
        HashMap<String, String> urlMap = new HashMap<>();
        urlMap.put("sign",sign);
        urlMap.put("timestamp",timestamp);
        urlMap.put("v",ZHONGYOU_VERSION);
        urlMap.put("app_key",ZHONGYOU_APPKEY);
        urlMap.put("method",mothod);
        urlMap.put("access_token",ZHONGYOU_ACCESSTOKEN);

        String url = ZhongYouUtil.buildUrl(frontUrl, urlMap);

        // 发送https请求

        // 处理https响应


        return false;
    }

    /**
     * 组装数据
     * @param params
     * @return
     */
    private List<TreeMap<String, Object>> createZhongYouDeliveryOrder(List<DeliveryOrderDTO> params) {
        // 返回
        List<TreeMap<String, Object>> reList = new ArrayList<>();

        // 遍历组装
        params.forEach(map -> {

            Map<String, Object> reMap = new TreeMap<String, Object>();
            // 托寄物信息
            BatchCreateOrderConsignInfoDto consignInfoDto = new BatchCreateOrderConsignInfoDto();

            // 客户平台信息
            BatchCreateOrderCustomerInfoDto batchCreateOrderCustomerInfoDto = new BatchCreateOrderCustomerInfoDto();

            // 寄件人信息
            BatchCreateOrderParticipantInfoDto senderInfo = new BatchCreateOrderParticipantInfoDto();

            //


            reList.add((TreeMap<String, Object>) reMap);
        });

        return reList;
    }
}
