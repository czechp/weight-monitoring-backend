package app.web.weightModule.application.useCase;

import app.web.exception.ConditionsNotFulFiledException;
import app.web.exception.NotFoundException;
import app.web.productionLine.dto.ProductionLineFacadeDto;
import app.web.utilities.tools.RandomValueGenerator;
import app.web.weightModule.application.dto.WeightModuleCreateDto;
import app.web.weightModule.application.port.crud.WeightModuleLastPortSave;
import app.web.weightModule.application.port.event.WeightModulePortEvent;
import app.web.weightModule.application.port.query.WeightModuleLastPortExistByProductionLineId;
import app.web.weightModule.application.port.query.WeightModulePortFindProductionLineById;
import app.web.weightModule.domain.WeightModuleLast;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

@ExtendWith(MockitoExtension.class)
class WeightModuleLastUseCaseCreateTest {
    @Mock
    WeightModuleLastPortSave portSave;

    @Mock
    WeightModulePortEvent portEvent;

    @Mock
    WeightModulePortFindProductionLineById portFindProductionLineById;

    @Mock
    WeightModuleLastPortExistByProductionLineId portExistByProductionLineId;


    WeightModuleLastUseCaseCreate useCaseCreate;

    @BeforeEach
    void init() {
        useCaseCreate = new WeightModuleLastUseCaseCreateImpl(portExistByProductionLineId, portFindProductionLineById, portEvent ,portSave);
    }

    @Test
    @DisplayName("Create a new weight last module")
    void createNewWeightModuleTest() {
        //given
        final var productionLineId = 1L;
        WeightModuleCreateDto weightModuleCreateDto = new WeightModuleCreateDto(productionLineId, RandomValueGenerator.randomInt());
        ProductionLineFacadeDto productionLine = new ProductionLineFacadeDto(productionLineId, "Some name");
        //when
        Mockito.when(portExistByProductionLineId.existsByProductionLineId(anyLong())).thenReturn(false);
        Mockito.when(portFindProductionLineById.findProductionLineById(anyLong())).thenReturn(Optional.of(productionLine));

        WeightModuleLast createWeightModule = useCaseCreate.create(weightModuleCreateDto);
        //then
        assertNotNull(createWeightModule);
        Mockito.verify(portSave, Mockito.times(1)).save(any());
    }


    @Test
    @DisplayName("Module already exists")
    void createNewWeightModuleAlreadyExistsTest() {
        //given
        final var productionLineId = 1L;
        WeightModuleCreateDto weightModuleCreateDto = new WeightModuleCreateDto(productionLineId, RandomValueGenerator.randomInt());
        ProductionLineFacadeDto productionLine = new ProductionLineFacadeDto(productionLineId, "Some name");
        //when
        Mockito.when(portExistByProductionLineId.existsByProductionLineId(anyLong())).thenReturn(true);
        //then
        assertThrows(ConditionsNotFulFiledException.class, () -> useCaseCreate.create(weightModuleCreateDto));
    }


    @Test
    @DisplayName("Line not found")
    void createNewWeightModuleLineNotFoundTest() {
        //given
        final var productionLineId = 1L;
        WeightModuleCreateDto weightModuleCreateDto = new WeightModuleCreateDto(productionLineId, RandomValueGenerator.randomInt());
        //when
        Mockito.when(portExistByProductionLineId.existsByProductionLineId(anyLong())).thenReturn(false);
        Mockito.when(portFindProductionLineById.findProductionLineById(anyLong())).thenReturn(Optional.empty());

        //then
        assertThrows(NotFoundException.class, () -> useCaseCreate.create(weightModuleCreateDto));

    }
}