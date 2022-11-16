package app.web.weightModule.application.useCase;

import app.web.weightModule.application.dto.WeightModuleLastUpdateDto;
import app.web.weightModule.application.dto.WeightModuleUpdateDto;
import app.web.weightModule.domain.WeightModuleLast;

public interface WeightModuleLastUseCaseUpdateData {

    WeightModuleLast updateModuleData(long moduleId, WeightModuleUpdateDto moduleDataDto, WeightModuleLastUpdateDto moduleLastDto);
}
