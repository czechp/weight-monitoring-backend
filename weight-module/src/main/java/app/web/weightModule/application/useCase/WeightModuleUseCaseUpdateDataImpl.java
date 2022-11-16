package app.web.weightModule.application.useCase;

import app.web.weightModule.application.dto.WeightModuleUpdateDto;
import app.web.weightModule.application.port.crud.WeightModulePortSave;
import app.web.weightModule.application.port.event.WeightModulePortEvent;
import app.web.weightModule.application.port.query.WeightModulePortFindById;
import app.web.weightModule.application.service.WeightModuleReportCreator;
import app.web.weightModule.domain.WeightModule;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
class WeightModuleUseCaseUpdateDataImpl implements WeightModuleUseCaseUpdateData {
    private final WeightModulePortFindById portFindById;

    private final WeightModulePortEvent portEvent;
    private final WeightModulePortSave portSave;

    private final WeightModuleReportCreator reportCreator;

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRES_NEW)
    public WeightModule updateWeightModuleData(long weightModuleId, WeightModuleUpdateDto dto) {
        WeightModule weightModuleToUpdate = portFindById.findByIdWeightModuleOrThrowException(weightModuleId);
        WeightModule updatedWeightModule = weightModuleToUpdate.updateData(dto);
        portEvent.notifyAboutUpdateDosingDevice(weightModuleId, dto.getDosingDevices(), true);
        portSave.saveWeightModule(updatedWeightModule);
        return updatedWeightModule;
    }
}
