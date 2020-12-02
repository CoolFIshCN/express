package com.express.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.express.entity.*;
import com.express.mapper.ChinaAreaDao;
import com.express.mapper.ChinaCityDao;
import com.express.mapper.ChinaProvinceDao;
import com.express.mapper.DistributorStoreDao;
import com.express.service.DistributorStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 进销商门店
 *
 * @author Rock.Zhou
 * @email cool_fish@aliyun.com
 * @date 2020-12-02 11:02:17
 */
@Service("distributorStoreService")
public class DistributorStoreServiceImpl extends ServiceImpl<DistributorStoreDao, DistributorStoreEntity> implements DistributorStoreService {

    // 进销商门店
    @Autowired
    private DistributorStoreDao distributorStoreDao;
    // 中国省份
    @Autowired
    private ChinaProvinceDao chinaProvinceDao;
    // 中国城市
    @Autowired
    private ChinaCityDao chinaCityDao;
    // 中国区/县
    @Autowired
    private ChinaAreaDao chinaAreaDao;

    /**
     * 批量修改或者新增
     *
     * @param entityList
     * @param user
     * @return
     */
    @Override
    public boolean updateOrSave(List<DistributorStoreEntity> entityList, SysUser user) {
        boolean flag = false;

        for (DistributorStoreEntity entity : entityList) {

            // 门店编码
            String storeNumberOriginal = entity.getStoreNumberOriginal();
            // 经销商编号
            Long distributorId = user.getDistributorId();
            entity.setDistributorId(distributorId);

            List<DistributorStoreEntity> distributorStoreEntities = distributorStoreDao.selectList(new QueryWrapper<DistributorStoreEntity>()
                    .eq("distributor_id", distributorId)
                    .eq("store_number_original", storeNumberOriginal));

            // 存在 更新
            if (distributorStoreEntities.size() > 0) {
                // 状态(0: 停用 / 1: 启用)
                if (0 <= entity.getStatusIdOriginal()) {
                    Integer status = entity.getStatusIdOriginal();
                    if (1 == status) {
                        entity.setStatusId(2001L);
                    }
                    if (0 == status) {
                        entity.setStatusId(2002L);
                    }
                }
                // 设置地址id
                entity = this.setLocation(entity);
                int update = distributorStoreDao.update(entity, new UpdateWrapper<DistributorStoreEntity>()
                        .eq("store_number_original", storeNumberOriginal)
                        .eq("distributor_id", distributorId));
                if (update == distributorStoreEntities.size()) {
                    flag = true;
                }
            }
            // 不存在 新增
            if (distributorStoreEntities.size() == 0) {
                // 状态(0: 停用 / 1: 启用)
                if (0 <= entity.getStatusIdOriginal()) {
                    Integer status = entity.getStatusIdOriginal();
                    if (1 == status) {
                        entity.setStatusId(2001L);
                    }
                    if (0 == status) {
                        entity.setStatusId(2002L);
                    }
                }
                // 设置地址id
                entity = this.setLocation(entity);
                // 新增时间
                entity.setCreateDate(new Date());
                //  新增
                int save = distributorStoreDao.insertOne(entity);
                if (save == 1) {
                    flag = true;
                }
            }
        }
        return flag;
    }


    /**
     * 批量查询门店
     * @param storeNumberList
     * @param distributorId
     * @return
     */
    @Override
    public List<DistributorStoreEntity> getByStoreNumber(List<String> storeNumberList, Long distributorId) {

        List<DistributorStoreEntity> entityList = distributorStoreDao.selectList(new QueryWrapper<DistributorStoreEntity>()
                .eq("distributor_id", distributorId)
                .in("store_number_original", storeNumberList));

        entityList.forEach(entity ->{
            if (null != entity.getStatusId()){
                Long statusId = entity.getStatusId();
                if (2001L == statusId){
                    entity.setStatusIdOriginal(1);
                }
                if (2002L == statusId){
                    entity.setStatusIdOriginal(0);
                }
            }
        });

        return entityList;
    }


    /**
     * 设置地址id
     *
     * @param store
     * @return
     */
    private DistributorStoreEntity setLocation(DistributorStoreEntity store) {

        // 省级地址
        if (null != store.getStoreProvinceOriginal() && !"".equals(store.getStoreProvinceOriginal())) {
            String storeProvinceOriginal = store.getStoreProvinceOriginal();
            List<ChinaProvinceEntity> province = chinaProvinceDao.selectList(new QueryWrapper<ChinaProvinceEntity>()
                    .likeRight("cn_name", storeProvinceOriginal));
            if (null != province && province.size() > 0) {
                Long id = province.get(0).getId();
                store.setDeliveryProvinceId(id);
            }
        }
        // 城市地址
        if (null != store.getStoreCityOriginal() && !"".equals(store.getStoreCountyOriginal())) {
            String storeCityOriginal = store.getStoreCityOriginal();
            List<ChinaCityEntity> city = chinaCityDao.selectList(new QueryWrapper<ChinaCityEntity>()
                    .likeRight("cn_name", storeCityOriginal));
            if (null != city && city.size() > 0) {
                Long id = city.get(0).getId();
                store.setDeliveryCityId(id);
            }
        }
        // 区/县地址
        if (null != store.getStoreCountyOriginal() && !"".equals(store.getStoreCountyOriginal())) {
            String storeCountyOriginal = store.getStoreCountyOriginal();
            List<ChinaAreaEntity> county = chinaAreaDao.selectList(new QueryWrapper<ChinaAreaEntity>()
                    .likeRight("cn_name", storeCountyOriginal));
            if (null != county && county.size() > 0) {
                Long id = county.get(0).getId();
                store.setDeliveryAreaId(id);
            }
        }


        return store;
    }
}