package app.web.weightModule.application.useCase;

import app.web.exception.NotFoundException;
import app.web.productionLine.dto.ProductionLineFacadeDto;
import app.web.weightModule.application.dto.WeightModuleCreateDto;
import app.web.weightModule.application.port.crud.WeightModulePortSave;
import app.web.weightModule.application.port.event.WeightModulePortEvent;
import app.web.weightModule.application.port.query.WeightModulePortFindProductionLineById;
import app.web.weightModule.domain.WeightModule;
import app.web.weightModule.domain.WeightModuleFactory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
class WeightModuleUseCaseCreateImpl implements WeightModuleUseCaseCreate {
    private final WeightModulePortFindProductionLineById portFindProductionLineById;
    private final WeightModulePortEvent portEvent;
    private final WeightModulePortSave portSave;

    @Override
    @Transactional
    public WeightModule createWeighModule(WeightModuleCreateDto weightModuleCreateDto) {
        ProductionLineFacadeDto productionLine = portFindProductionLineById.findProductionLineById(weightModuleCreateDto.getProductionLineId())
                .orElseThrow(() -> new NotFoundException("Linia produkcyjna z id: " + weightModuleCreateDto.getProductionLineId() + " nie istnieje"));
        WeightModule weightModule = WeightModuleFactory.createWeightModule(productionLine.getProductionLineId(), productionLine.getProductionLineName());
        WeightModule createdWeightModule = portSave.saveWeightModule(weightModule);
        portEvent.notifyAboutModuleCreating(createdWeightModule, weightModuleCreateDto.getDosingDevicesAmount());
        return weightModule;

    }
}
