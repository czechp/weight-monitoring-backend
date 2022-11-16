package app.web.weightModule.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WeightModuleQueryDto {
    private final long id;
    private final long productionLineId;
    private final String productionLineName;
    private final ProductInfoQueryDto productInfo;
    private final ModuleStatusQueryDto moduleStatus;
    private final ProductionIndicatorsQueryDto productionIndicators;

    @Data
    @AllArgsConstructor
    public static class ProductInfoQueryDto {
        private float upRangeWeight;
        private float downRangeWeight;
    }

    @Data
    @AllArgsConstructor
    public static class ModuleStatusQueryDto {
        private final int currentDosingDevice;
        private final float currentMeasure;
        private final boolean status;
    }

    @Data
    @AllArgsConstructor
    public static class ProductionIndicatorsQueryDto {
        final float totalMaterialWeight;
        final long totalProductPcs;
        final float correctProductPercent;
    }

}




