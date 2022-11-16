package app.web.weightModule.application.useCase;

import app.web.exception.ConditionsNotFulFiledException;
import app.web.exception.NotFoundException;
import app.web.weightModule.application.dto.WeightModuleCreateDto;
import app.web.weightModule.application.port.crud.WeightModuleLastPortSave;
import app.web.weightModule.application.port.event.WeightModulePortEvent;
import app.web.weightModule.application.port.query.WeightModuleLastPortExistByProductionLineId;
import app.web.weightModule.application.port.query.WeightModulePortFindProductionLineById;
import app.web.weightModule.domain.WeightModuleLast;
import app.web.weightModule.domain.WeightModuleLastFactory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
class WeightModuleLastUseCaseCreateImpl implements WeightModuleLastUseCaseCreate {
    private final WeightModuleLastPortExistByProductionLineId portExistsByProductionLineId;
    private final WeightModulePortFindProductionLineById portFindProductionLineById;
    private final WeightModulePortEvent portEvent;
    private final WeightModuleLastPortSave portSave;

    @Override
    public WeightModuleLast create(WeightModuleCreateDto weightModuleCreateDto) {
        final var productionLineId = weightModuleCreateDto.getProductionLineId();

        moduleForThisLineDoesNotExistOrException(productionLineId);
        final var productionLine = portFindProductionLineById.findProductionLineById(productionLineId)
                .orElseThrow(() -> new NotFoundException("Linia z id: " + productionLineId));
        final var weightModuleLast = WeightModuleLastFactory.create(productionLine.getProductionLineId(), productionLine.getProductionLineName());
        WeightModuleLast createdModule = portSave.save(weightModuleLast);
        portEvent.notifyAboutModuleCreating(createdModule, weightModuleCreateDto.getDosingDevicesAmount());
        return weightModuleLast;
    }

    private void moduleForThisLineDoesNotExistOrException(long productionLineId){
        boolean modulesExist = portExistsByProductionLineId.existsByProductionLineId(productionLineId);
        if(modulesExist)
            throw new ConditionsNotFulFiledException("Linia może mieć tylko jeden moduł kończący");
    }
}

