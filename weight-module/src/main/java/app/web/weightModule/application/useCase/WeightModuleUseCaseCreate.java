package app.web.weightModule.application.useCase;

import app.web.weightModule.application.dto.WeightModuleCreateDto;
import app.web.weightModule.domain.WeightModule;

public interface WeightModuleUseCaseCreate {
    WeightModule createWeighModule(WeightModuleCreateDto weightModuleCreateDto);
}
