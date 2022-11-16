package app.web.weightModule.application.useCase;

import app.web.productionLine.dto.ProductionLineFacadeDto;
import app.web.utilities.tools.RandomValueGenerator;
import app.web.weightModule.application.dto.WeightModuleCreateDto;
import app.web.weightModule.application.port.crud.WeightModulePortSave;
import app.web.weightModule.application.port.event.WeightModulePortEvent;
import app.web.weightModule.application.port.query.WeightModulePortFindProductionLineById;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

@ExtendWith(MockitoExtension.class)
class WeightModuleUseCaseCreateTest {
    @Mock
    WeightModulePortFindProductionLineById portFindProductionLineById;
    @Mock
    WeightModulePortSave portSave;

    @Mock
    WeightModulePortEvent portEvent;

    WeightModuleUseCaseCreate weightModuleUseCaseCreate;

    @BeforeEach
    void init() {
        this.weightModuleUseCaseCreate = new WeightModuleUseCaseCreateImpl(portFindProductionLineById, portEvent, portSave);
    }

    @Test
    void createWeightModuleTest() {
        //given
        final var productionLineId = 1L;
        final var productionLineName = "Line name";
        final var weightModuleCreateDto = new WeightModuleCreateDto(productionLineId, RandomValueGenerator.randomInt());
        final var productionLineFacadeDto = new ProductionLineFacadeDto(productionLineId, productionLineName);
        //when
        Mockito.when(portFindProductionLineById.findProductionLineById(anyLong())).thenReturn(Optional.of(productionLineFacadeDto));
        final var createdWeightModule = weightModuleUseCaseCreate.createWeighModule(weightModuleCreateDto);
        //then
        assertNotNull(createdWeightModule);
        Mockito.verify(portSave, Mockito.times(1)).saveWeightModule(any());
    }

}