package app.web.application.useCase;

import app.web.application.port.crud.DosingDevicePortCRUD;
import app.web.domain.DosingDevice;
import app.web.domain.DosingDeviceTestProvider;
import app.web.dosingDevice.dto.DosingDeviceUpdateData;
import app.web.exception.ConditionsNotFulFiledException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class DosingDeviceUseCaseUpdateTest {
    @Mock
    DosingDevicePortCRUD portCRUD;

    DosingDeviceUseCaseUpdate useCaseUpdate;

    @BeforeEach
    void init() {
        this.useCaseUpdate = new DosingDeviceUseCaseUpdateImpl(portCRUD);
    }

    @Test
    @DisplayName("Update dosing device data")
    void updateDosingDevicesByModuleIdTest() {
        //given
        final var moduleId = 1L;
        final var isFirst = true;
        List<DosingDeviceUpdateData> newData = provideListOfDto(10);
        List<DosingDevice> dosingDevices = provideDomainList(10);
        //when
        Mockito.when(portCRUD.findByModuleId(moduleId, true)).thenReturn(dosingDevices);
        List<DosingDevice> updateDosingDevices = useCaseUpdate.updateDosingDevicesByModuleId(moduleId, newData, true);
        //then
        Mockito.verify(portCRUD, Mockito.times(dosingDevices.size())).save(any());
    }

    @Test()
    @DisplayName("Not found dto for dosing device")
    void updateDosingDevicesByModuleIdNotFoundDtoForDomainTest() {
        //given
        final var moduleId = 1L;
        final var isFirst = true;
        List<DosingDeviceUpdateData> newData = provideListOfDto(9);
        List<DosingDevice> dosingDevices = provideDomainList(10);
        //when
        Mockito.when(portCRUD.findByModuleId(moduleId, true)).thenReturn(dosingDevices);
        //then
        assertThrows(ConditionsNotFulFiledException.class, () -> useCaseUpdate.updateDosingDevicesByModuleId(moduleId, newData, true));
    }

    private List<DosingDevice> provideDomainList(int size) {
        return IntStream.range(0, size)
                .boxed()
                .map(DosingDeviceTestProvider::getDomain)
                .collect(Collectors.toList());
    }

    private List<DosingDeviceUpdateData> provideListOfDto(int size) {
        return IntStream.range(0, size)
                .boxed()
                .map(n -> new DosingDeviceUpdateData() {
                    @Override
                    public int getRecordNumber() {
                        return n;
                    }

                    @Override
                    public float getLastMeasure() {
                        return (float) n;
                    }

                    @Override
                    public int getAmountBelowMeasures() {
                        return n;
                    }

                    @Override
                    public int getAmountCorrectMeasures() {
                        return n;
                    }

                    @Override
                    public int getAmountAboveMeasures() {
                        return n;
                    }

                    @Override
                    public float getAverageMeasure() {
                        return (float) n;
                    }

                    @Override
                    public int getCorrectMeasuresPercent() {
                        return n;
                    }

                    @Override
                    public float getTotalMaterial() {
                        return n;
                    }
                })
                .collect(Collectors.toList());
    }
}