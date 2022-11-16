package app.web.weightModule.domain;

import app.web.weightModule.application.dto.WeightModuleUpdateDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter()
@Setter(value = AccessLevel.PROTECTED)
public abstract class WeightModuleAbstract {
    private long id;
    private long version;
    private long productionLineId;
    private String productionLineName;
    private ProductInfoVO productInfo;
    private ModuleStatusVO moduleStatus;
    private ProductionIndicatorsVO productionIndicators;

    public WeightModuleAbstract(long id,
                                long version,
                                long productionLineId,
                                String productionLineName,
                                ProductInfoVO productInfo,
                                ModuleStatusVO moduleStatus,
                                ProductionIndicatorsVO productionIndicators) {
        this.id = id;
        this.productionLineId = productionLineId;
        this.productionLineName = productionLineName;
        this.productInfo = productInfo;
        this.moduleStatus = moduleStatus;
        this.productionIndicators = productionIndicators;
        this.version = version;
    }

    public WeightModuleAbstract(long productionLineId, String productionLineName) {
        this.productionLineId = productionLineId;
        this.productionLineName = productionLineName;
        this.productInfo = new ProductInfoVO();
        this.moduleStatus = new ModuleStatusVO();
        this.productionIndicators = new ProductionIndicatorsVO();
    }

    protected void updateBasicData(WeightModuleUpdateDto dto) {
        this.setProductInfo(new ProductInfoVO(dto.getProductUpRangeWeight(), dto.getProductDownRangeWeight()));
        this.setModuleStatus(new ModuleStatusVO(dto.getCurrentDosingDevice(), dto.getCurrentMeasure(), dto.isStatus()));
        this.setProductionIndicators(new ProductionIndicatorsVO(dto.getTotalMaterialWeight(), dto.getTotalProductPcs(), dto.getCorrectProductPercent()));
    }

    public boolean productDataChanged(float productDownRange, float productUpRange) {
        final var differentThanZero = this.productInfo.isNotZero();
        final var dataChanged = this.productInfo.areDifferent(productDownRange, productUpRange);
        return differentThanZero && dataChanged;
    }

    public void clearProductInfo() {
        this.productInfo = new ProductInfoVO();
    }
}
