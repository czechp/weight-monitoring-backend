package app.web.weightModule.domain;

import app.web.weightModule.application.dto.WeightModuleLastUpdateDto;
import app.web.weightModule.application.dto.WeightModuleUpdateDto;
import lombok.AccessLevel;
import lombok.Getter;

@Getter(AccessLevel.PACKAGE)
public class WeightModuleLast extends WeightModuleAbstract {
    private ModuleLastInfoVO moduleLastInfo;

    WeightModuleLast(long id,
                            long version,
                            long productionLineId,
                            String productionLineName,
                            ProductInfoVO productInfo,
                            ModuleStatusVO moduleStatus,
                            ProductionIndicatorsVO productionIndicators,
                            ModuleLastInfoVO moduleLastInfo
    ) {
        super(id, version, productionLineId, productionLineName, productInfo, moduleStatus, productionIndicators);
        this.moduleLastInfo = moduleLastInfo;
    }

    WeightModuleLast(long productionLineId, String productionLineName){
        super(productionLineId, productionLineName);
        this.moduleLastInfo = new ModuleLastInfoVO();
    }

    public WeightModuleLast updateData(WeightModuleUpdateDto updateDto, WeightModuleLastUpdateDto lastUpdateDto){
        super.updateBasicData(updateDto);
        this.moduleLastInfo = new ModuleLastInfoVO(
                lastUpdateDto.getIncorrectProductPcs(),
                lastUpdateDto.getWeightDifference(),
                lastUpdateDto.getCorrectToOverdosePercent(),
                lastUpdateDto.getNotRefilledProductPcs(),
                lastUpdateDto.getOverFilledProductPcs(),
                lastUpdateDto.getOverFilledToNotRefilledPercent()
        );

        return this;
    }
}
