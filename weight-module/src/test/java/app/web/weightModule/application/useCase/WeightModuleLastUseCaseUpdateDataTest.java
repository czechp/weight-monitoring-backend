package app.web.weightModule.application.useCase;

import app.web.utilities.tools.RandomValueGenerator;
import app.web.weightModule.application.port.crud.WeightModuleLastPortSave;
import app.web.weightModule.application.port.event.WeightModulePortEvent;
import app.web.weightModule.application.port.query.WeightModuleLastPortFindByIdOrThrow;
import app.web.weightModule.application.service.WeightModuleReportCreator;
import app.web.weightModule.domain.WeightModuleLast;
import app.web.weightModule.domain.WeightModuleLastTestProvider;
import app.web.weightModule.domain.WeightModuleTestProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

@ExtendWith(MockitoExtension.class)
class WeightModuleLastUseCaseUpdateDataTest {
    @Mock
    WeightModuleLastPortSave portSave;
    @Mock
    WeightModuleLastPortFindByIdOrThrow portFindByIdOrThrow;

    @Mock
    WeightModulePortEvent eventPort;

    @Mock
    WeightModuleReportCreator weightModuleReportCreator;
    WeightModuleLastUseCaseUpdateData useCaseUpdateData;

    @BeforeEach
    void init() {
        this.useCaseUpdateData = new WeightModuleLastUseCaseUpdateDataImpl(portFindByIdOrThrow, eventPort, portSave, weightModuleReportCreator);
    }

    @Test
    @DisplayName("Update data")
    void updateDataTest() {
        //given
        final var moduleId = RandomValueGenerator.randomLong();
        final var moduleDataDto = WeightModuleTestProvider.updateDto();
        final var moduleLastDto = WeightModuleLastTestProvider.updateDto();
        final var module = WeightModuleLastTestProvider.domain();
        //when
        Mockito.when(portFindByIdOrThrow.findByIdOrThrowException(anyLong())).thenReturn(module);
        WeightModuleLast updatedModule = useCaseUpdateData.updateModuleData(moduleId, moduleDataDto, moduleLastDto);
        //then
        Mockito.verify(portSave, Mockito.times(1)).save(any());
    }

}