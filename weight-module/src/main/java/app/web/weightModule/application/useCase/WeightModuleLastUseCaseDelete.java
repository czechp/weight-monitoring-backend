package app.web.weightModule.application.useCase;

import app.web.weightModule.domain.WeightModuleLast;

public interface WeightModuleLastUseCaseDelete {

    WeightModuleLast removeById(long moduleId);
}
