package app.web.weightModule.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter(AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
class ProductionIndicatorsVO {
    final float totalMaterialWeight;
    final long totalProductPcs;
    final float correctProductPercent;


    ProductionIndicatorsVO() {
        this.totalMaterialWeight = 0f;
        this.totalProductPcs = 0l;
        this.correctProductPercent = 0f;
    }
}
