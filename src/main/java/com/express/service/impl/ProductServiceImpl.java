package com.express.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.express.dto.ProductDto;
import com.express.entity.DistributorProductEntity;
import com.express.entity.ProductEntity;
import com.express.entity.TemperatureTypeEntity;
import com.express.mapper.DistributorProductDao;
import com.express.mapper.ProductDao;
import com.express.service.DistributorProductService;
import com.express.service.ProductService;
import com.express.service.TemperatureTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service("productService")
public class ProductServiceImpl extends ServiceImpl<ProductDao, ProductEntity> implements ProductService {


    // 物料
    @Autowired
    private ProductDao productDao;

    // 经销商物料
    @Autowired
    private DistributorProductDao distributorProductDao;

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
    @Transactional
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

                // 更新成功
                if (update > 0) {
                    // 构建进销商物料
                    DistributorProductEntity distributorProductEntity = createDistributorProductEntity(productDto);
                    distributorProductEntity.setDistributorId(distributorId);
                    productEntities.forEach(productBySearch -> {
                        // 根据  物料id 更新  经销商物料信息
                        Long productId = productBySearch.getId();
                        distributorProductDao.update(distributorProductEntity
                                , new UpdateWrapper<DistributorProductEntity>()
                                        .eq("product_id", productId)
                                        .eq("distributor_id", distributorId));
                    });

                    flag = true;
                }
            }
            // 不存在就新增
            if (productEntities.size() == 0) {
                // 构建物料主表实体类
                ProductEntity productEntity = this.createProductEntity(productDto);
                productEntity.setDistributorId(distributorId);
                int insert = productDao.insertOne(productEntity);
                // 主表id
                Long productId = productEntity.getId();
                if (insert == 1) {
                    // 构建经销商物料实体
                    DistributorProductEntity distributorProductEntity = createDistributorProductEntity(productDto);
                    distributorProductEntity.setProductId(productId);
                    distributorProductEntity.setDistributorId(distributorId);
                    // 插入进销商附表
                    distributorProductDao.insertOne(distributorProductEntity);
                    flag = true;
                }
            }
        }

        return flag;
    }

    /**
     * 根据经销商id和物料编号查询
     *
     * @param distributorId
     * @param productNumber
     * @return
     */
    @Override
    public List<ProductDto> getByProductNumber(Long distributorId, String productNumber) {
        List<ProductDto> reList = new ArrayList<>();
        // 物料主表查询
        List<ProductEntity> productEntities = productDao.selectList(new QueryWrapper<ProductEntity>()
                .eq("distributor_id", distributorId)
                .eq("product_number", productNumber));

        // 构建dto
        if (null != productEntities && productEntities.size() != 0) {
            productEntities.forEach(productEntity -> {
                // 物料id
                Long productId = productEntity.getId();
                // 进销商物料
                List<DistributorProductEntity> distributorProductList = distributorProductDao.selectList(
                        new QueryWrapper<DistributorProductEntity>()
                                .eq("distributor_id", distributorId)
                                .eq("product_id", productId));
                distributorProductList.forEach(distributorProduct -> {
                    // 构建经销商物料dto
                    ProductDto productDto = createProductDto(distributorProduct, productEntity);
                    reList.add(productDto);
                });
            });
        }

        return reList;
    }

    /**
     * 构建进销商物料dto
     *
     * @param distributorProduct
     * @param productEntity
     * @return
     */
    private ProductDto createProductDto(DistributorProductEntity distributorProduct, ProductEntity productEntity) {
        // 存储方式
        List<TemperatureTypeEntity> temperatureTypeEntities = temperatureTypeService.getAll();
        ProductDto reDto = new ProductDto();
        // 物料编号
        if (null != productEntity.getProductNumber()) {
            reDto.setProductNumber(productEntity.getProductNumber());
        }
        // 物料名称
        if (null != productEntity.getProductName()) {
            reDto.setProductName(productEntity.getProductName());
        }
        // sku最小单位
        if (null != productEntity.getSkuUnit()) {
            reDto.setSkuUnit(productEntity.getSkuUnit());
        }
        // sku毛重
        if (null != productEntity.getSkuGrossWeight()) {
            reDto.setSkuGrossWeight(productEntity.getSkuGrossWeight());
        }
        // sku净重
        if (null != productEntity.getSkuWeight()) {
            reDto.setSkuWeight(productEntity.getSkuWeight());
        }
        // 规格
        if (null != productEntity.getSpec()) {
            reDto.setSpec(productEntity.getSpec());
        }
        // 保质期
        if (null != productEntity.getWarrantyDays()) {
            reDto.setWarrantyDays(productEntity.getWarrantyDays());
        }
        // 存储条件
        if (null != productEntity.getTemperatureTypeId()) {
            Long temperatureTypeId = productEntity.getTemperatureTypeId();
            temperatureTypeEntities.forEach(type -> {
                if (temperatureTypeId == type.getId()) {
                    reDto.setTemperatureType(type.getName());
                }
            });
        }
        // 箱长(公分, 小数后二位)
        if (null != productEntity.getBoxLoadedLength()) {
            reDto.setBoxLength(productEntity.getBoxLoadedLength().toString());
        }

        // 箱宽(公分, 小数后二位)
        if (null != productEntity.getBoxLoadedWidth()) {
            reDto.setBoxWidth(productEntity.getBoxLoadedWidth().toString());
        }

        // 箱高(公分, 小数后二位)
        if (null != productEntity.getBoxLoadedHeight()) {
            reDto.setBoxHeight(productEntity.getBoxLoadedHeight().toString());
        }

        //箱材积(立方公分, 小数后二位)
        if (null != productEntity.getBoxLoadedVolume()) {
            reDto.setBoxLoadedVolume(productEntity.getBoxLoadedVolume());
        }
        // 状态(0: 停用 / 1: 启用)
        if (null != productEntity.getStatusId()) {
            Long statusId = productEntity.getStatusId();
            if (2001L == statusId) {
                reDto.setStatus(1);
            }
            if (2002L == statusId) {
                reDto.setStatus(0);
            }
        }

        // 商品条码
        if (null != productEntity.getBarCode()) {
            reDto.setBarCode(productEntity.getBarCode());
        }

        // 单箱净重(KG, 小数后二位)
        if (null != productEntity.getBoxLoadedNetWeight()) {
            reDto.setBoxNetWeight(productEntity.getBoxLoadedNetWeight().toString());
        }

        // 单箱毛重(KG, 小数后二位)
        if (null != productEntity.getBoxLoadedGrossWeight()) {
            reDto.setBoxGrossWeight(productEntity.getBoxLoadedGrossWeight().toString());
        }

        // 单箱内sku数
        if (null != productEntity.getBoxLoadedAmount()) {
            reDto.setBoxLoadedAmount(productEntity.getBoxLoadedAmount());
        }

        // 最大库存量
        if (null != distributorProduct.getStocksAmountMax()){
            reDto.setStocksAmountMax(distributorProduct.getStocksAmountMax());
        }

        // 安全库存量
        if (null != distributorProduct.getSafeStockAmount()){
            reDto.setSafeStockAmount(distributorProduct.getSafeStockAmount());
        }

        // 最小起订量
        if (null != distributorProduct.getOrderAmountLeast()){
            reDto.setSafeStockAmount(distributorProduct.getOrderAmountLeast());
        }
        return reDto;
    }

    /**
     * 根据Dto构建进销商物料实体
     *
     * @param productDto
     * @return
     */
    private DistributorProductEntity createDistributorProductEntity(ProductDto productDto) {

        DistributorProductEntity reEntity = new DistributorProductEntity();

        // 物料编号
        if (null != productDto.getProductNumber()) {
            reEntity.setProductNumber(productDto.getProductNumber());
        }

        // 安全库存量
        if (null != productDto.getSafeStockAmount()) {
            reEntity.setSafeStockAmount(productDto.getSafeStockAmount());
        }
        // 最小起订量
        if (null != productDto.getOrderAmountLeast()) {
            reEntity.setOrderAmountLeast(productDto.getOrderAmountLeast());
        }
        // 最大起订量
        if (null != productDto.getStocksAmountMax()) {
            reEntity.setStocksAmountMax(productDto.getStocksAmountMax());
        }

        return reEntity;
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
        // 状态(0: 停用 / 1: 启用)
        if (null != productDto.getStatus()) {
            Integer status = productDto.getStatus();
            if (1 == status) {
                reEntity.setStatusId(2001L);
            }
            if (0 == status) {
                reEntity.setStatusId(2002L);
            }
        }
        return reEntity;
    }


}