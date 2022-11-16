package app.web.weightModule.domain;

import app.web.weightModule.adapter.persistence.ProductionLineSimpleEntity;
import app.web.weightModule.adapter.persistence.WeightModuleEntity;
import app.web.weightModule.application.dto.WeightModuleQueryDto;

public class WeightModuleFactory {
    public static WeightModule toWeightModuleDomain(WeightModuleEntity weightModuleEntity) {
        final ProductInfoVO productInfo = new ProductInfoVO(weightModuleEntity.getProductUpRangeWeight(),
                weightModuleEntity.getProductDownRangeWeight());

        final ModuleStatusVO processStatus = new ModuleStatusVO(
                weightModuleEntity.getCurrentDosingDevice(),
                weightModuleEntity.getCurrentMeasure(),
                weightModuleEntity.isStatus()
        );

        final ProductionIndicatorsVO productionInfo = new ProductionIndicatorsVO(
                weightModuleEntity.getTotalMaterialWeight(),
                weightModuleEntity.getTotalProductPcs(),
                weightModuleEntity.getCorrectProductPercent()
        );

        return new WeightModule(weightModuleEntity.getId(),
                weightModuleEntity.getVersion(),
                weightModuleEntity.getProductionLineSimpleEntity().getId(),
                weightModuleEntity.getProductionLineSimpleEntity().getLineName(),
                productInfo,
                processStatus,
                productionInfo);
    }

    public static WeightModuleEntity toWeightModuleEntity(WeightModule domain) {
        return new WeightModuleEntity(
                domain.getId(),
                domain.getVersion(),
                new ProductionLineSimpleEntity(domain.getProductionLineId(), domain.getProductionLineName()),
                domain.getProductInfo().getUpRangeWeight(),
                domain.getProductInfo().getDownRangeWeight(),
                domain.getModuleStatus().getCurrentDosingDevice(),
                domain.getModuleStatus().getCurrentMeasure(),
                domain.getModuleStatus().isStatus(),
                domain.getProductionIndicators().getTotalMaterialWeight(),
                domain.getProductionIndicators().getTotalProductPcs(),
                domain.getProductionIndicators().getCorrectProductPercent()
        );
    }

    public static WeightModuleQueryDto toWeightModuleQueryDto(WeightModule domain) {
        return new WeightModuleQueryDto(
                domain.getId(),
                domain.getProductionLineId(),
                domain.getProductionLineName(),
                new WeightModuleQueryDto.ProductInfoQueryDto(
                        domain.getProductInfo().getUpRangeWeight(),
                        domain.getProductInfo().getDownRangeWeight()
                ),
                new WeightModuleQueryDto.ModuleStatusQueryDto(
                        domain.getModuleStatus().getCurrentDosingDevice(),
                        domain.getModuleStatus().getCurrentMeasure(),
                        domain.getModuleStatus().isStatus()
                ),
                new WeightModuleQueryDto.ProductionIndicatorsQueryDto(
                        domain.getProductionIndicators().getTotalMaterialWeight(),
                        domain.getProductionIndicators().getTotalProductPcs(),
                        domain.getProductionIndicators().getCorrectProductPercent()
                )
        );
    }

    public static WeightModule createWeightModule(long productionLineId, String productionLineName) {
        return new WeightModule(productionLineId, productionLineName);
    }
}
