package app.web.weightModule.application.port.query;

import app.web.weightModule.domain.WeightModule;

public interface WeightModulePortFindById {
    WeightModule findByIdWeightModuleOrThrowException(long id);
}
