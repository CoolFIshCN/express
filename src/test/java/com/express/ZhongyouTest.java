package com.express;

import com.jdwl.open.api.sdk.DefaultJdClient;
import com.jdwl.open.api.sdk.JdClient;
import com.jdwl.open.api.sdk.JdException;
import com.jdwl.open.api.sdk.domain.zhongyouex.OrderOpenApi.*;
import com.jdwl.open.api.sdk.request.zhongyouex.ApiOrderBatchCreateOrderForISVLopRequest;
import com.jdwl.open.api.sdk.response.zhongyouex.ApiOrderBatchCreateOrderForISVResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZhongyouTest {

    @Test
    public void testApiOrderBatchCreateOrderForISVTest() {
        try {
            String serverUrl = "https://test-proxy.zhongyouex.com/routerjson";
            String accessToken = "1b0c5e1c4ded4907bf59e8ec77fd4a26";
            String appKey = "dc88920d82764c20b6b03e18fa45dbac";
            String appSecret = "9980cc6e9f524d3fb02ae7e7d4b4f6b2";

            JdClient client = new DefaultJdClient(serverUrl, accessToken, appKey, appSecret);
            //SERVER_URL,网关调用地址
            ApiOrderBatchCreateOrderForISVLopRequest lopRequest = new ApiOrderBatchCreateOrderForISVLopRequest();

            CommonParam commonParam = new CommonParam();
            commonParam.setAppCode("EXPRESS_100");
            commonParam.setSource("1005");
            commonParam.setToken("a2d5bf4e72774135e5dd3797910844f5");

            lopRequest.setCommonParam(commonParam);
            BatchOrderRequest batchOrderRequest = new BatchOrderRequest();
            batchOrderRequest.setReqNo("202010101010101000000");
            OrderItemRequest orderItemRequest = makeOrderItemRequest();
            batchOrderRequest.setOrderItemRequestList(Collections.singletonList(orderItemRequest));

            lopRequest.setBatchOrderRequest(batchOrderRequest);
            ApiOrderBatchCreateOrderForISVResponse response = client.execute(lopRequest);
            System.out.println(response.getMsg());
        } catch (JdException e) {
            e.printStackTrace();
        }
    }

    private static OrderItemRequest makeOrderItemRequest() {
        OrderItemRequest orderItemRequest = new OrderItemRequest();
        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setCustomerCode("JJW00040001");
        customerInfo.setCustomerOrderNo("NO2020010110100001");
        customerInfo.setPlatformNo("PNO2020010110100001");
        orderItemRequest.setCustomerInfo(customerInfo);

        ConsignInfo consignInfo = new ConsignInfo();
        consignInfo.setConsignCount(1);
        consignInfo.setConsignType(1);
        consignInfo.setConsignWare("一封家书");
        consignInfo.setLength(BigDecimal.ONE);
        consignInfo.setWidth(BigDecimal.ONE);
        consignInfo.setHeight(BigDecimal.ONE);
        consignInfo.setWeight(BigDecimal.valueOf(0.1));
        consignInfo.setVolume(BigDecimal.ONE);
        orderItemRequest.setConsignInfo(consignInfo);

        ParticipantInfo senderInfo = new ParticipantInfo();
        senderInfo.setProvinceName("江苏省");
        senderInfo.setCityName("连云港市");
        senderInfo.setCountyName("赣榆区");
        senderInfo.setAddress("江苏地址");
        senderInfo.setContact("发件人");
        senderInfo.setPhone("15510052323");
        senderInfo.setCompany("众邮快递");

        ParticipantInfo receiverInfo = new ParticipantInfo();
        receiverInfo.setProvinceName("北京市");
        receiverInfo.setCityName("北京市");
        receiverInfo.setCountyName("大兴区");
        receiverInfo.setTownName("亦庄经济技术开发区");
        receiverInfo.setAddress("京东总部四号楼");
        receiverInfo.setContact("收件人");
        receiverInfo.setPhone("15510052424");
        receiverInfo.setCompany("京东总部");

        orderItemRequest.setSenderInfo(senderInfo);
        orderItemRequest.setReceiverInfo(receiverInfo);

        ShipmentInfo shipmentInfo = new ShipmentInfo();
        shipmentInfo.setDeliveryType(1);
        shipmentInfo.setPickupType(1);
        orderItemRequest.setShipmentInfo(shipmentInfo);

        orderItemRequest.setFreight(BigDecimal.ZERO);
        orderItemRequest.setPayType(1);
        orderItemRequest.setRemark("易碎物品，小心搬运");

        AddedServiceInfo addedServiceInfo = new AddedServiceInfo();
        addedServiceInfo.setServiceCode("ZY_DSHK");
        addedServiceInfo.setServiceValue("1000");
        AddedServiceInfo addedServiceInfo1 = new AddedServiceInfo();
        addedServiceInfo1.setServiceCode("ZY_BJFW");
        addedServiceInfo1.setServiceValue("1000");

        List<AddedServiceInfo> addedServiceInfoList = Arrays.asList(addedServiceInfo, addedServiceInfo1);
        orderItemRequest.setAddedServiceList(addedServiceInfoList);

        return orderItemRequest;
    }
}
