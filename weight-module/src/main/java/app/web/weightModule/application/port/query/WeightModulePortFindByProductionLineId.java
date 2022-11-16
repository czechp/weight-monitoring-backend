package app.web.weightModule.application.port.query;

import app.web.weightModule.domain.WeightModule;

import java.util.List;

public interface WeightModulePortFindByProductionLineId {
    List<WeightModule> findByProductionLineIdWeightModules(long id);
}
