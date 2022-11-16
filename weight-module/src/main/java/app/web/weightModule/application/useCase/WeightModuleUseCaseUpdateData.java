package app.web.weightModule.application.useCase;

import app.web.weightModule.application.dto.WeightModuleUpdateDto;
import app.web.weightModule.domain.WeightModule;

public interface WeightModuleUseCaseUpdateData {
    WeightModule updateWeightModuleData(long weightModuleId, WeightModuleUpdateDto weightModuleUpdateDto);
}
