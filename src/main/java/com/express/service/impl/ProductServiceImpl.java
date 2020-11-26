package com.express.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.express.dto.ProductDto;
import com.express.entity.ProductEntity;
import com.express.entity.TemperatureTypeEntity;
import com.express.mapper.ProductDao;
import com.express.service.ProductService;
import com.express.service.TemperatureTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("productService")
public class ProductServiceImpl extends ServiceImpl<ProductDao, ProductEntity> implements ProductService {


    // 物料
    @Autowired
    private ProductDao productDao;

    // 储存方式
    @Autowired
    private TemperatureTypeService temperatureTypeService;

    /**
     * 更新或者添加物料
     *
     * @param productList
     * @param distributorId
     * @return
     */
    @DS("master")
    @Override
    public boolean updateOrSave(List<ProductDto> productList, Long distributorId) {
        boolean flag = false;

        for (ProductDto productDto : productList) {
            // 根据物料编号和进销商id查询
            String productNumber = productDto.getProductNumber();
            List<ProductEntity> productEntities = productDao.selectList(new QueryWrapper<ProductEntity>()
                    .eq("product_number", productNumber)
                    .eq("distributor_id", distributorId));

            // 存在就更新
            if (productEntities.size() > 0) {
                // 构建物料主表实体类
                ProductEntity productEntity = this.createProductEntity(productDto);
                productEntity.setDistributorId(distributorId);
                // 根据物料id和进销商id修改物料主表
                int update = productDao.update(productEntity, new UpdateWrapper<ProductEntity>()
                        .eq("product_number", productNumber)
                        .eq("distributor_id", distributorId));

                if (update > 0) {
                    // 构建进销商物料 todo
                    productEntities.forEach(productBySearch->{
                        // 物料id
                        Long productId = productBySearch.getId();
                    });


                    flag = true;
                }
            }
            // 不存在就新增
            if (productEntities.size() == 0) {
                ProductEntity productEntity = this.createProductEntity(productDto);
                productEntity.setDistributorId(distributorId);
                int insert = productDao.insertOne(productEntity);
                if (insert == 1) {
                    flag = true;
                }
            }
        }

        return flag;
    }

    /**
     * 根据Dto构建物料实体
     *
     * @param productDto
     * @return ProductEntity
     */
    private ProductEntity createProductEntity(ProductDto productDto) {
        // 存储方式
        List<TemperatureTypeEntity> temperatureTypeEntities = temperatureTypeService.getAll();

        ProductEntity reEntity = new ProductEntity();
        // 物料编号
        if (null != productDto.getProductNumber()) {
            reEntity.setProductNumber(productDto.getProductNumber());
        }
        // 物料名称
        if (null != productDto.getProductName()) {
            reEntity.setProductName(productDto.getProductName());
        }
        // 规格
        if (null != productDto.getSpec()) {
            reEntity.setSpec(productDto.getSpec());
        }
        // 商品条码
        if (null != productDto.getBarCode()) {
            reEntity.setBarCode(productDto.getBarCode());
        }
        // sku最小单位
        if (null != productDto.getSkuUnit()) {
            reEntity.setSkuUnit(productDto.getSkuUnit());
        }
        // sku毛重
        if (null != productDto.getSkuGrossWeight()) {
            reEntity.setSkuGrossWeight(productDto.getSkuGrossWeight());
        }
        // sku净重
        if (null != productDto.getSkuWeight()) {
            reEntity.setSkuWeight(productDto.getSkuWeight());
        }
        //保质期
        if (null != productDto.getWarrantyDays()) {
            reEntity.setWarrantyDays(productDto.getWarrantyDays());
        }
        //储存条件: CW(常温), LC(冷藏), LD(冷冻)
        if (null != productDto.getTemperatureType()) {
            String temperatureType = productDto.getTemperatureType();
            temperatureTypeEntities.forEach(type -> {
                if (null != type.getName() && temperatureType.equals(type.getName())) {
                    reEntity.setTemperatureTypeId(type.getId());
                }
            });
        }
        // 箱长(公分, 小数后二位)
        if (null != productDto.getBoxLength()) {
            Double boxLengthDouble = new Double(productDto.getBoxLength());
            reEntity.setBoxLoadedLength(boxLengthDouble);
        }
        // 箱宽(公分, 小数后二位)
        if (null != productDto.getBoxWidth()) {
            Double boxWidthDouble = new Double(productDto.getBoxWidth());
            reEntity.setBoxLoadedWidth(boxWidthDouble);
        }
        // 箱高(公分, 小数后二位)
        if (null != productDto.getBoxHeight()) {
            Double boxHeightDouble = new Double(productDto.getBoxHeight());
            reEntity.setBoxLoadedHeight(boxHeightDouble);
        }
        // 箱材积(立方公分, 小数后二位)
        if (null != productDto.getBoxLoadedVolume()) {
            Double boxLoadedVolumeDouble = new Double(productDto.getBoxLoadedVolume());
            reEntity.setBoxLoadedVolume(boxLoadedVolumeDouble);
        }
        // 单箱净重(KG, 小数后二位)
        if (null != productDto.getBoxNetWeight()) {
            Double boxNetWeightDouble = new Double(productDto.getBoxNetWeight());
            reEntity.setBoxLoadedNetWeight(boxNetWeightDouble);
        }
        // 单箱毛重(KG, 小数后二位)
        if (null != productDto.getBoxGrossWeight()) {
            Double boxGrossWeightDouble = new Double(productDto.getBoxGrossWeight());
            reEntity.setBoxLoadedGrossWeight(boxGrossWeightDouble);
        }
        // 单箱内sku数
        if (null != productDto.getBoxLoadedAmount()) {
            reEntity.setBoxLoadedAmount(productDto.getBoxLoadedAmount());
        }
        // 最大库存量
        // 安全库存量
        // 最小起订量
        // 状态(0: 停用 / 1: 启用)
        if (null != productDto.getStatus()) {
            Integer status = productDto.getStatus();
            if (1 == status) {
                reEntity.setStatusId(2001L);
            }
            if (1 == status) {
                reEntity.setStatusId(2002L);
            }
        }
        return reEntity;
    }


}