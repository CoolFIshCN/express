package com.express.dto;

import java.util.List;

/**
 * 外部传入出货单参数列表
 */
public class DeliveryOrderForm {
    private String pointTo;

    private List<DeliveryOrderDTO> paramList;

    public String getPointTo() {
        return pointTo;
    }

    public void setPointTo(String pointTo) {
        this.pointTo = pointTo;
    }

    public List<DeliveryOrderDTO> getParamList() {
        return paramList;
    }

    public void setParamList(List<DeliveryOrderDTO> paramList) {
        this.paramList = paramList;
    }
}
