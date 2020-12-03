package com.express.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.express.dto.ProductDto;
import com.express.entity.DistributorProductEntity;
import com.express.entity.ProductEntity;
import com.express.entity.SysUser;
import com.express.entity.TemperatureTypeEntity;
import com.express.mapper.DistributorProductDao;
import com.express.mapper.ProductDao;
import com.express.service.ProductService;
import com.express.service.TemperatureTypeService;
import com.express.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
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
     * @param
     * @return
     */
    @DS("master")
    @Transactional
    @Override
    public R updateOrSave(List<ProductDto> productList, SysUser user) {
        List<String> okList = new ArrayList<>();
        List<String> errorList = new ArrayList<>();

        List<ProductDto> operationList = new ArrayList<>();

        productList.forEach(productDto -> {
            Boolean aBoolean = this.checkSellUnit(productDto);
            if (aBoolean){
                operationList.add(productDto);
            }else {
                String productNumber = productDto.getProductNumber();
                errorList.add("productNumber:"+ productNumber+",'sellUnit' value of the field is error;");
            }
        });


        for (ProductDto productDto : operationList) {
            // 根据物料编号和进销商id查询
            String productNumber = productDto.getProductNumber();
            List<ProductEntity> productEntities = productDao.selectList(new QueryWrapper<ProductEntity>()
                    .eq("product_number", productNumber)
                    .eq("distributor_id", user.getDistributorId()));

            // 存在就更新
            if (productEntities.size() > 0) {
                // 构建物料主表实体类
                ProductEntity productEntity = this.createProductEntity(productDto);
                productEntity.setDistributorId( user.getDistributorId());
                // 更新人和更新时间
                productEntity.setModifierId(Long.parseLong(user.getId()));
                productEntity.setModifyDate(new Date());
                // 根据物料id和进销商id修改物料主表
                int update = productDao.update(productEntity, new UpdateWrapper<ProductEntity>()
                        .eq("product_number", productNumber)
                        .eq("distributor_id",  user.getDistributorId()));

                // 更新成功
                if (update > 0) {
                    // 构建进销商物料
                    DistributorProductEntity distributorProductEntity = createDistributorProductEntity(productDto);
                    distributorProductEntity.setDistributorId( user.getDistributorId());
                    // 更新人和更新时间
                    distributorProductEntity.setModifierId(Long.parseLong(user.getId()));
                    distributorProductEntity.setModifyDate(new Date());
                    productEntities.forEach(productBySearch -> {
                        // 根据  物料id 更新  经销商物料信息
                        Long productId = productBySearch.getId();
                        distributorProductDao.update(distributorProductEntity
                                , new UpdateWrapper<DistributorProductEntity>()
                                        .eq("product_id", productId)
                                        .eq("distributor_id",user.getDistributorId()));
                    });
                    okList.add("productNumber："+ productNumber + ",Update successful;");
                }
            }
            // 不存在就新增
            if (productEntities.size() == 0) {
                // 构建物料主表实体类
                ProductEntity productEntity = this.createProductEntity(productDto);
                productEntity.setDistributorId( user.getDistributorId());
                // 添加人 和添加时间
                productEntity.setCreatorId(Long.parseLong(user.getId()));
                productEntity.setCreateDate(new Date());
                int insert = productDao.insertOne(productEntity);
                // 主表id
                Long productId = productEntity.getId();
                if (insert == 1) {
                    // 构建经销商物料实体
                    DistributorProductEntity distributorProductEntity = this.createDistributorProductEntity(productDto);
                    distributorProductEntity.setProductId(productId);
                    distributorProductEntity.setDistributorId(user.getDistributorId());
                    // 添加人和添加时间
                    distributorProductEntity.setCreatorId(Long.parseLong(user.getId()));
                    distributorProductEntity.setCreateDate(new Date());
                    // 插入进销商附表
                    distributorProductDao.insertOne(distributorProductEntity);

                    okList.add("productNumber："+ productNumber + ",Save successful;");
                }
            }
        }

        return R.ok().put("okList",okList).put("errorList",errorList);
    }

    /**
     * 根据经销商id和物料编号查询
     *
     * @param distributorId
     * @param
     * @return
     */
    @Override
    public List<ProductDto> getByProductNumber(Long distributorId, List<String> productNumberList) {
        List<ProductDto> reList = new ArrayList<>();
        // 物料主表查询
        List<ProductEntity> productEntities = productDao.selectList(new QueryWrapper<ProductEntity>()
                .eq("distributor_id", distributorId)
                .in("product_number", productNumberList));

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
        // sku毛重 (公斤, 小数后二位)
        if (null != productEntity.getSkuGrossWeight()) {
            String skuGrossWeightStr = String.format("%.2f", productEntity.getSkuGrossWeight());
            reDto.setSkuGrossWeight(new Double(skuGrossWeightStr));
        }
        // sku净重 (公斤, 小数后二位)
        if (null != productEntity.getSkuWeight()) {
            String skuWeightStr = String.format("%.2f", productEntity.getSkuWeight());
            reDto.setSkuWeight(new Double(skuWeightStr));
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
            String boxLength = String.format("%.2f", productEntity.getBoxLoadedLength());
            reDto.setBoxLength(boxLength);
        }

        // 箱宽(公分, 小数后二位)
        if (null != productEntity.getBoxLoadedWidth()) {
            String boxWidth = String.format("%.2f", productEntity.getBoxLoadedWidth());
            reDto.setBoxWidth(boxWidth);
        }

        // 箱高(公分, 小数后二位)
        if (null != productEntity.getBoxLoadedHeight()) {
            String boxHeight = String.format("%.2f", productEntity.getBoxLoadedHeight());

            reDto.setBoxHeight(boxHeight);
        }

        //箱材积(立方公分, 小数后二位)
        if (null != productEntity.getBoxLoadedVolume()) {
            String boxLoadedVolume = String.format("%.2f", productEntity.getBoxLoadedVolume());
            reDto.setBoxLoadedVolume(new Double(boxLoadedVolume));
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
            String boxNetWeight = String.format("%.2f", productEntity.getBoxLoadedNetWeight());
            reDto.setBoxNetWeight(boxNetWeight);
        }

        // 单箱毛重(KG, 小数后二位)
        if (null != productEntity.getBoxLoadedGrossWeight()) {
            String boxGrossWeight = String.format("%.2f", productEntity.getBoxLoadedGrossWeight());
            reDto.setBoxGrossWeight(boxGrossWeight);
        }

        // 单箱内sku数
        if (null != productEntity.getBoxLoadedAmount()) {
            reDto.setBoxLoadedAmount(productEntity.getBoxLoadedAmount());
        }

        // 最大库存量
        if (null != distributorProduct.getStocksAmountMax()) {
            reDto.setStocksAmountMax(distributorProduct.getStocksAmountMax());
        }

        // 安全库存量
        if (null != distributorProduct.getSafeStockAmount()) {
            reDto.setSafeStockAmount(distributorProduct.getSafeStockAmount());
        }

        // 最小起订量
        if (null != distributorProduct.getOrderAmountLeast()) {
            reDto.setOrderAmountLeast(distributorProduct.getOrderAmountLeast());
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
        // 物料名称
        if (null != productDto.getProductName()){
            reEntity.setProductName(productDto.getProductName());
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

        // 重/抛货
        if (null != productDto.getBoxLoadedVolume()
                && new Double(0) < productDto.getBoxLoadedVolume()
                && null != productDto.getBoxGrossWeight()
                && new Double(0) < new Double(productDto.getBoxGrossWeight())) {

            // 材积
            Double boxLoadedVolume = productDto.getBoxLoadedVolume();

            // 单箱毛重
            String boxGrossWeight = productDto.getBoxGrossWeight();


            Double divisor = new Double(1000000);
            // 获取立方米材积
            Double stere = boxLoadedVolume / divisor;
            //  一立方米货物重量 = 单箱毛重/立方米材积
            Double stereWeight = new Double(boxGrossWeight) / stere;
            // 判断是否重抛货
            if (stereWeight > 210.0D) {
                reEntity.setProductStockTypeId(1000L);
            } else {
                reEntity.setProductStockTypeId(2000L);
            }
        }

        // erpSellingUnit
        if (null != productDto.getSellUnit()){
            reEntity.setSellUnit(productDto.getSellUnit());
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
            Double boxLengthDouble = new Double(String.format("%.2f",new Double(productDto.getBoxLength())));
            reEntity.setBoxLoadedLength(boxLengthDouble);
        }
        // 箱宽(公分, 小数后二位)
        if (null != productDto.getBoxWidth()) {
            Double boxWidthDouble = new Double(String.format("%.2f",new Double(productDto.getBoxWidth())));
            reEntity.setBoxLoadedWidth(boxWidthDouble);
        }
        // 箱高(公分, 小数后二位)
        if (null != productDto.getBoxHeight()) {
            Double boxHeightDouble = new Double(String.format("%.2f",new Double(productDto.getBoxHeight())));
            reEntity.setBoxLoadedHeight(boxHeightDouble);
        }
        // 箱材积(立方公分, 小数后二位)
        if (null != productDto.getBoxLoadedVolume()) {
            Double boxLoadedVolumeDouble = new Double(String.format("%.2f",productDto.getBoxLoadedVolume()));
            reEntity.setBoxLoadedVolume(boxLoadedVolumeDouble);
        }
        // 单箱净重(KG, 小数后二位)
        if (null != productDto.getBoxNetWeight()) {
            Double boxNetWeightDouble = new Double(String.format("%.2f",new Double(productDto.getBoxNetWeight())));
            reEntity.setBoxLoadedNetWeight(boxNetWeightDouble);
        }
        // 单箱毛重(KG, 小数后二位)
        if (null != productDto.getBoxGrossWeight()) {
            Double boxGrossWeightDouble = new Double(String.format("%.2f",new Double(productDto.getBoxGrossWeight())));
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
        // erp 销售单位
        if(null != productDto.getBoxUnit()){
            reEntity.setErpSellingUnit(productDto.getBoxUnit());
        }
        return reEntity;
    }

    /**
     * 校验零售单位
     * @param productDto
     * @return
     */
    private Boolean checkSellUnit(ProductDto productDto){
        String boxUnit = productDto.getBoxUnit();
        String skuUnit = productDto.getSkuUnit();

        String sellUnit = productDto.getSellUnit();

        if (null != sellUnit &&null != boxUnit && null != skuUnit){
            if (sellUnit.equals(boxUnit) || sellUnit.equals(skuUnit)){
                return true;
            }
        }

        return false;
    }


}