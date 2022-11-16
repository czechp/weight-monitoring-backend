package app.web.weightModule.application.port.query;

import app.web.weightModule.domain.WeightModuleLast;

import java.util.List;

public interface WeightModuleLastPortFindByProductionLineId {
    List<WeightModuleLast> findByProductionLineId(long id);
}
