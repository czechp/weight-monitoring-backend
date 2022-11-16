package app.web.weightModule.application.useCase;

import app.web.weightModule.application.port.crud.WeightModulePortSave;
import app.web.weightModule.application.port.event.WeightModulePortEvent;
import app.web.weightModule.application.port.query.WeightModulePortFindById;
import app.web.weightModule.application.service.WeightModuleReportCreator;
import app.web.weightModule.domain.WeightModule;
import app.web.weightModule.domain.WeightModuleTestProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class WeightModuleUseCaseUpdateDataTest {

    @Mock
    WeightModulePortFindById portFindById;

    @Mock
    WeightModulePortSave portSave;

    @Mock
    WeightModulePortEvent eventPort;

    @Mock
    WeightModuleReportCreator weightModuleReportCreator;

    WeightModuleUseCaseUpdateData useCaseUpdateData;

    @BeforeEach
    void init() {
        this.useCaseUpdateData = new WeightModuleUseCaseUpdateDataImpl(portFindById, eventPort, portSave, weightModuleReportCreator);
    }

    @Test
    void updateWeightModuleDataTest() {
        //given
        final var weightModuleId = 1L;
        final var weightModuleUpdateDto = WeightModuleTestProvider.updateDto();
        //when
        Mockito.when(portFindById.findByIdWeightModuleOrThrowException(anyLong())).thenReturn(WeightModuleTestProvider.domain());
        WeightModule updatedWeightModule = useCaseUpdateData.updateWeightModuleData(weightModuleId, weightModuleUpdateDto);
        //then
        Mockito.verify(portSave, times(1)).saveWeightModule(any());
    }
}