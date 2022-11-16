package app.web.weightModule.application.port.crud;

import app.web.weightModule.domain.WeightModule;

public interface WeightModulePortSave {
    WeightModule saveWeightModule(WeightModule weightModule);
}
