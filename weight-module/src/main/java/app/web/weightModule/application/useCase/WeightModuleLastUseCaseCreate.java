package app.web.weightModule.application.useCase;

import app.web.weightModule.application.dto.WeightModuleCreateDto;
import app.web.weightModule.domain.WeightModuleLast;

public interface WeightModuleLastUseCaseCreate {
    WeightModuleLast create(WeightModuleCreateDto weightModuleCreateDto);
}
