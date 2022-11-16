package app.web.weightModule.application.port.query;

import app.web.weightModule.domain.WeightModuleLast;

public interface WeightModuleLastPortFindByIdOrThrow {
    WeightModuleLast findByIdOrThrowException(long id);
}
