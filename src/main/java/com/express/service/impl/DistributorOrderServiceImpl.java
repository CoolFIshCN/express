package com.express.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.express.dto.OrderDto;
import com.express.dto.OrderProductsDto;
import com.express.entity.*;
import com.express.mapper.*;
import com.express.service.DistributorOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service("distributorOrderService")
public class DistributorOrderServiceImpl extends ServiceImpl<DistributorOrderDao, DistributorOrderEntity> implements DistributorOrderService {

    @Autowired
    private DistributorOrderDao distributorOrderDao;

    @Autowired
    private DistributorOrderItemDao distributorOrderItemDao;
    // 经销商门店
    @Autowired
    private DistributorStoreDao distributorStoreDao;

    @Autowired
    private ChinaProvinceDao chinaProvinceDao;

    @Autowired
    private ChinaCityDao chinaCityDao;

    @Autowired
    private ChinaAreaDao chinaAreaDao;

    @Autowired
    private DistributorAccountDao distributorAccountDao;

    /**
     * 批量更新或新增
     *
     * @param orderDtoList
     * @param distributorId
     * @return
     */
    @Transactional
    @Override
    public boolean updateOrSaveList(List<OrderDto> orderDtoList, Long distributorId) {
        final boolean[] flag = {true};
        orderDtoList.forEach(orderDto -> {

            // 根据订单编号和经销商id查询 是否订单已存在
            List<DistributorOrderEntity> countList = distributorOrderDao.selectList(
                    new QueryWrapper<DistributorOrderEntity>()
                            .eq("original_order_number", orderDto.getOrderNo())
                            .eq("distributor_id", distributorId));

            // 更新
            if (countList.size() > 0) {
                // 构建订单
                DistributorOrderEntity updateEntity = this.setDistributorOrder(orderDto, distributorId);
                // 更新订单
                int updateOrder = distributorOrderDao.update(updateEntity
                        , new UpdateWrapper<DistributorOrderEntity>()
                                .eq("original_order_number", orderDto.getOrderNo())
                                .eq("distributor_id", distributorId));
                if (updateOrder > 0) {
                    Long orderId = countList.get(0).getId();

                    List<OrderProductsDto> products = orderDto.getProducts();
                    products.forEach(orderProductsDto -> {
                        // 构建订单详情
                        DistributorOrderItemEntity updateItemEntity = this.setDistributorOrderItem(orderProductsDto);
                        updateItemEntity.setDistributorOrderId(orderId);
                        updateItemEntity.setDistributorId(distributorId);
                        if (null != updateItemEntity.getDistributorAccountId()){
                            updateItemEntity.setDistributorAccountId(updateItemEntity.getDistributorAccountId());
                        }
                        // 更新订单详情
                        int updateOrderItem = distributorOrderItemDao.update(updateItemEntity
                                , new UpdateWrapper<DistributorOrderItemEntity>()
                                        .eq("distributor_id", distributorId)
                                        .eq("distributor_order_id", orderId));
                        if (updateOrderItem <= 0) {
                            flag[0] = false;
                        }
                    });
                } else {
                    flag[0] = false;
                }
            }

            // 新增
            if (countList.size() == 0) {
                // 构建订单
                DistributorOrderEntity saveEntity = this.setDistributorOrder(orderDto, distributorId);
                // 新增订单
                int save = distributorOrderDao.insertOne(saveEntity);
                Long orderId = saveEntity.getId();
                if (save == 1) {
                    List<OrderProductsDto> products = orderDto.getProducts();
                    products.forEach(orderProductsDto -> {
                        // 构建订单详情
                        DistributorOrderItemEntity saveItemEntity = this.setDistributorOrderItem(orderProductsDto);
                        saveItemEntity.setDistributorOrderId(orderId);
                        saveItemEntity.setDistributorId(distributorId);
                        if (null != saveEntity.getDistributorAccountId()){
                            saveItemEntity.setDistributorAccountId(saveEntity.getDistributorAccountId());
                        }
                        // 新增订单详情
                        int saveItem = distributorOrderItemDao.insertOne(saveItemEntity);
                    });
                } else {
                    flag[0] = false;
                }
            }
        });


        return flag[0];
    }

    /**
     * 构建 经销商订单
     *
     * @param orderDto
     * @return
     */
    private DistributorOrderEntity setDistributorOrder(OrderDto orderDto, Long distributorId) {
        DistributorOrderEntity reEntity = new DistributorOrderEntity();

        // 订单编号 distributor_order.original_order_number
        if (null != orderDto.getOrderNo()) {
            reEntity.setOriginalOrderNumber(orderDto.getOrderNo());
        }
        // 订单内存码 distributor_order.original_request_id
        if (null != orderDto.getOrderId()) {
            reEntity.setOriginalRequestId(orderDto.getOrderId());
        }

        // 订单号创始人 distributor_order.from_distributor_order_payer
        if (null != orderDto.getCreatorName()) {
            reEntity.setFromDistributorOrderPayer(orderDto.getCreatorName());
        }

        // 门店编号 distributor_order.distributor_store_id
        // select id as distributor_store_id from distributor_store where distributor_id = ? and store_number_original = storeNo
        if (null != orderDto.getStoreNo()) {
            String storeNo = orderDto.getStoreNo();
            List<DistributorStoreEntity> storeList = distributorStoreDao.selectList(new QueryWrapper<DistributorStoreEntity>()
                    .eq("distributor_id", distributorId)
                    .eq("store_number_original", storeNo));

            if (null != storeList && storeList.size() > 0 && null != storeList.get(0).getId()) {
                Long distributorStoreId = storeList.get(0).getId();
                reEntity.setDistributorStoreId(distributorStoreId);
            }
        }


        // 出货日期 distributor_order.original_delivery_date_string --> distributor_order.delivery_date
        if (null != orderDto.getDeliveryDate()) {
            String deliveryDate = orderDto.getDeliveryDate();
            reEntity.setOriginalDeliveryDateString(deliveryDate);
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date deliveryDateDate = df.parse(deliveryDate);
                reEntity.setDeliveryDate(deliveryDateDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        // 省级地址
        if (null != orderDto.getProvince() && !"".equals(orderDto.getProvince())) {
            String storeProvinceOriginal = orderDto.getProvince();
            List<ChinaProvinceEntity> province = chinaProvinceDao.selectList(new QueryWrapper<ChinaProvinceEntity>()
                    .likeRight("cn_name", storeProvinceOriginal));
            if (null != province && province.size() > 0) {
                Long id = province.get(0).getId();
                reEntity.setDeliveryProvinceId(id);
            }
        }
        // 城市地址
        if (null != orderDto.getCity() && !"".equals(orderDto.getCity())) {
            String storeCityOriginal = orderDto.getCity();
            List<ChinaCityEntity> city = chinaCityDao.selectList(new QueryWrapper<ChinaCityEntity>()
                    .likeRight("cn_name", storeCityOriginal));
            if (null != city && city.size() > 0) {
                Long id = city.get(0).getId();
                reEntity.setDeliveryCityId(id);
            }
        }
        // 区/县地址
        if (null != orderDto.getCounty() && !"".equals(orderDto.getCounty())) {
            String storeCountyOriginal = orderDto.getCounty();
            List<ChinaAreaEntity> county = chinaAreaDao.selectList(new QueryWrapper<ChinaAreaEntity>()
                    .likeRight("cn_name", storeCountyOriginal));
            if (null != county && county.size() > 0) {
                Long id = county.get(0).getId();
                reEntity.setDeliveryAreaId(id);
            }
        }

        // 详细地址
        if (null != orderDto.getAddress()) {
            reEntity.setDeliveryAddressDetail(orderDto.getAddress());
        }

        // 状态
        if (null != orderDto.getStatus() && orderDto.getStatus() == 1) {
            reEntity.setStatusId(3005L);
        }
        if (null != orderDto.getStatus() && orderDto.getStatus() ==0){
        }
        // 版本
        reEntity.setVersion(new Date());
        // 进销商id
        reEntity.setDistributorId(distributorId);
        // 订单类型
        reEntity.setDistributorOrderTypeId(1L);
        // accountName
        List<DistributorAccountEntity> distributorAccountEntities = distributorAccountDao.selectList(
                new QueryWrapper<DistributorAccountEntity>()
                        .eq("account_name", "admin")
                        .eq("distributor_id", distributorId));
        if (null != distributorAccountEntities && distributorAccountEntities.size() > 0) {
            DistributorAccountEntity distributorAccountEntity = distributorAccountEntities.get(0);
            Long accountEntityId = distributorAccountEntity.getId();
            reEntity.setDistributorAccountId(accountEntityId);
        }else {
            new RuntimeException("accountId 未找到！distributor_id="+distributorId);
        }

        return reEntity;
    }

    /**
     * 构建经销商订单明细表
     *
     * @param
     * @return
     */
    private DistributorOrderItemEntity setDistributorOrderItem(OrderProductsDto orderProductsDto) {
        DistributorOrderItemEntity reEntity = new DistributorOrderItemEntity();

        // 物料编号
        if (null != orderProductsDto.getProductNo() && !"".equals(orderProductsDto.getProductNo())) {
            String productNo = orderProductsDto.getProductNo();
            reEntity.setItemNumber(productNo);
        }

        // 单位
        if (null != orderProductsDto.getUnit() && !"".equals(orderProductsDto.getUnit())) {
            String unit = orderProductsDto.getUnit();
            reEntity.setSkuUnit(unit);
        }

        // 数量
        if (null != orderProductsDto.getAmount()) {
            String amount = orderProductsDto.getAmount();
            reEntity.setSubTotal(new Double(amount));
        }
        // 版本
        reEntity.setVersion(new Date());
        // 状态
        reEntity.setStatusId(3005L);

        return reEntity;
    }
}