package com.express;


import com.express.controller.LogisticsController;
import com.express.util.HttpClientUtil;
import jodd.http.HttpRequest;
import jodd.http.HttpResponse;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {

    final static String access_token = "1b0c5e1c4ded4907bf59e8ec77fd4a26";
    final static String app_key = "dc88920d82764c20b6b03e18fa45dbac";
    final static String method = "zhongyouex.api.order.createOrderForCustom";
    final static String v = "2.0";
    final static String appSecret = "9980cc6e9f524d3fb02ae7e7d4b4f6b2";
    final static String param = "";



    /**
     * 签约客户下单
     */
    @org.junit.Test
    public void testApiOrderCreateOrderForCustomTest() {
        // 组装数据
        String paramJson = buildBody();


        // 拼接url


    }

    /**
     * 组装数据
     *
     * @return
     */
    private String buildBody() {
        String paramJson = "";


        return null;
    }

    /**
     * 处理时间格式
     */
    private String getTimestamp(String timestamp) {
        String timestampNew = "";

        return timestampNew;
    }


    /**
     * 签名算法
     *
     * @param timestamp
     * @param version
     * @param method
     * @param paramJson
     * @param accessToken
     * @param appKey
     * @param appSecret
     * @return
     * @throws Exception
     */
    private String buildSign(String timestamp, String version, String method,
                             String paramJson, String accessToken,
                             String appKey, String appSecret) throws Exception {
        //第一步，按照顺序填充参数
        Map<String, String> map = new TreeMap();
        map.put("timestamp", timestamp);
        map.put("v", version);
        map.put("method", method);
        map.put("param_json", paramJson);
        map.put("access_token", accessToken);
        map.put("app_key", appKey);

        StringBuilder sb = new StringBuilder(appSecret);
        //按照规则拼成字符串
        for (Map.Entry entry : map.entrySet()) {
            String name = (String) entry.getKey();
            String value = (String) entry.getValue();
            sb.append(name).append(value);
        }
        sb.append(appSecret);
        //MD5
        return md5(sb.toString());
    }

    public static String md5(String source) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] bytes = md.digest(source.getBytes("utf-8"));
        return byte2hex(bytes);
    }

    private static String byte2hex(byte[] bytes) {
        StringBuilder sign = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if (hex.length() == 1) {
                sign.append("0");
            }
            sign.append(hex.toUpperCase());
        }
        return sign.toString();
    }


    static String token= "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIiLCJleHAiOjE2MDg2MDYyMzIsInVzZXJJZCI6IjkiLCJpYXQiOjE2MDg2MDI2MzIsImp0aSI6IjE2MDg2MDI2MzIxMzc5In0.UGdUJF7cU3uYyp4hVtke4TCDyQORpLgem54n3dQi5qE";
    /**
     * 测试创建订单
     */
    @org.junit.Test
    public void testCreateOrder() {
        // 组装参数
        Map<String, Object> params = getParams();

        // 发送httpPost
        HttpRequest post = HttpRequest.post("http://192.168.88.53:8888/logistics/zhongYou");

    }

    /**
     * 测试创建订单 -- 构建参数
     *
     * @return
     */
    private Map<String, Object> getParams() {
        Map<String, Object> params = new HashMap<>();
        List<Map<String, Object>> paramsList = new ArrayList<>();
        Map<String, Object> listItem = new HashMap<>();

        // 指定物流方
        params.put("pointTo", "zhongYou");

        //客户平台信息
        listItem.put("customerCode", "kehubianma");
        listItem.put("customerOrderNo", "kehudingdanhao");
        listItem.put("platformNo", "qudaodanhao");
        listItem.put("warehouseType", 1);

        // 托寄物信息
        listItem.put("consignCount", 1);
        listItem.put("consignWare", "托寄物名称");
        listItem.put("consignType", 5);
        listItem.put("length", new BigDecimal("1"));
        listItem.put("width", new BigDecimal("1"));
        listItem.put("height", new BigDecimal("1.01"));
        listItem.put("weight", new BigDecimal("1.02"));
        listItem.put("volume", new BigDecimal("2.00"));

        // 寄件人信息
        listItem.put("provinceName", "江苏省");
        listItem.put("cityName", "苏州市");
        listItem.put("countyName", "昆山市");
        listItem.put("townName", "张浦镇");
        listItem.put("address", "俱进路鲜活果汁");
        listItem.put("contact", "凉席人");
        listItem.put("phone", "18556505992");
        listItem.put("mobile", "05512828001");
        listItem.put("company", "鲜活果汁有限公司");

        // 收件人信息
        listItem.put("provinceName", "安徽省");
        listItem.put("cityName", "安庆市");
        listItem.put("countyName", "枞阳县");
        listItem.put("townName", "枞阳镇");
        listItem.put("address", "天利明珠");
        listItem.put("contact", "收件人");
        listItem.put("phone", "18556505992");
        listItem.put("mobile", "05512828001");
        listItem.put("company", "枞鑫商贸");

        // 货运信息
        listItem.put("pickupType", 1);
        listItem.put("deliveryType", 2);
        listItem.put("expectPickupStartTime", "2020-12-12 12:12:12");
        listItem.put("expectPickupEndTime", "2020-12-21 12:21:21");
        listItem.put("expectDeliveryStartTime", "2020-12-12 12:12:12");
        listItem.put("expectDeliveryEndTime", "2020-12-21 12:21:21");

        // 运费支付
        listItem.put("payType", 2);

        // 运费
        listItem.put("freight", new BigDecimal("100.01"));

        // 增值服务

        // 订单备注
        listItem.put("remark", "订单备注");

        // 扩展信息


        // 组装
        paramsList.add(listItem);
        params.put("paramsList", paramsList);
        return params;
    }

    @org.junit.Test
    public  void testBaidu(){

        HttpResponse send = HttpRequest.get("http://www.baidu.com").send();
        System.out.println(send);
    }
}
