package app.web.weightModule.adapter.persistence;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "weight_modules_last")
@Getter()
@Setter(AccessLevel.PACKAGE)
public
class WeightModuleLastEntity extends WeightModuleSuperEntity {
    private long incorrectProductPcs;
    private float weightDifference;
    private float correctToOverdosePercent;
    private long notRefilledProductPcs;
    private long overFilledProductPcs;
    private float overFilledToNotRefilledPercent;

    WeightModuleLastEntity() {
        super();
    }

    public WeightModuleLastEntity(long id, long version, ProductionLineSimpleEntity productionLineSimpleEntity, float productUpRangeWeight, float productDownRangeWeight, int currentDosingDevice, float currentMeasure, boolean status, float totalMaterialWeight, long totalProductPcs, float correctProductPercent, long incorrectProductPcs, float weightDifference, float correctToOverdosePercent, long notRefilledProductPcs, long overFilledProductPcs, float overFilledToNotRefilledPercent) {
        super(id, version, productionLineSimpleEntity, productUpRangeWeight, productDownRangeWeight, currentDosingDevice, currentMeasure, status, totalMaterialWeight, totalProductPcs, correctProductPercent);
        this.incorrectProductPcs = incorrectProductPcs;
        this.weightDifference = weightDifference;
        this.correctToOverdosePercent = correctToOverdosePercent;
        this.notRefilledProductPcs = notRefilledProductPcs;
        this.overFilledProductPcs = overFilledProductPcs;
        this.overFilledToNotRefilledPercent = overFilledToNotRefilledPercent;
    }
}
