package app.web.weightModule.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter(AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
class ModuleLastInfoVO {
    private long incorrectProductPcs;
    private float weightDifference;
    private float correctToOverdosePercent;
    private long notRefilledProductPcs;
    private long overFilledProductPcs;
    private float overFilledToNotRefilledPercent;

    ModuleLastInfoVO() {

    }
}
