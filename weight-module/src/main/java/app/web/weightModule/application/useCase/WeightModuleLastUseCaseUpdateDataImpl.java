package app.web.weightModule.application.useCase;

import app.web.weightModule.application.dto.WeightModuleLastUpdateDto;
import app.web.weightModule.application.dto.WeightModuleUpdateDto;
import app.web.weightModule.application.port.crud.WeightModuleLastPortSave;
import app.web.weightModule.application.port.event.WeightModulePortEvent;
import app.web.weightModule.application.port.query.WeightModuleLastPortFindByIdOrThrow;
import app.web.weightModule.application.service.WeightModuleReportCreator;
import app.web.weightModule.domain.WeightModuleLast;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
class WeightModuleLastUseCaseUpdateDataImpl implements WeightModuleLastUseCaseUpdateData {
    private final WeightModuleLastPortFindByIdOrThrow portFindByIdOrThrow;
    private final WeightModulePortEvent portEvent;
    private final WeightModuleLastPortSave portSave;

    private final WeightModuleReportCreator reportCreator;
    @Override
    @Transactional()
    public WeightModuleLast updateModuleData(long moduleId, WeightModuleUpdateDto moduleDataDto, WeightModuleLastUpdateDto lastData) {
        WeightModuleLast weightModuleLast = portFindByIdOrThrow.findByIdOrThrowException(moduleId);
        final var dataChanged = weightModuleLast.productDataChanged(moduleDataDto.getProductDownRangeWeight(),
                moduleDataDto.getProductUpRangeWeight());

        if (dataChanged) {
            reportCreator.createReportForLine(weightModuleLast.getProductionLineId());
            return weightModuleLast;
        } else {
            WeightModuleLast updatedWeightModuleLast = weightModuleLast.updateData(moduleDataDto, lastData);
            portEvent.notifyAboutUpdateDosingDevice(moduleId, moduleDataDto.getDosingDevices(), false);
            portSave.save(weightModuleLast);
            return updatedWeightModuleLast;
        }

    }
}
