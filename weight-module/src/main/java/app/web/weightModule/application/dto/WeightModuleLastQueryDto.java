package app.web.weightModule.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeightModuleLastQueryDto extends WeightModuleQueryDto {
    private final ModuleLastInfoQuery moduleLastInfo;

    public WeightModuleLastQueryDto(long id,
                                    long productionLineId,
                                    String productionLineName,
                                    ProductInfoQueryDto productInfo,
                                    ModuleStatusQueryDto moduleStatus,
                                    ProductionIndicatorsQueryDto productionIndicators,
                                    ModuleLastInfoQuery moduleLastInfo) {
        super(id, productionLineId, productionLineName, productInfo, moduleStatus, productionIndicators);
        this.moduleLastInfo = moduleLastInfo;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class ModuleLastInfoQuery {
        private long incorrectProductPcs;
        private float weightDifference;
        private float correctToOverdosePercent;
        private long notRefilledProductPcs;
        private long overFilledProductPcs;
        private float overFilledToNotRefilledPercent;
    }
}
