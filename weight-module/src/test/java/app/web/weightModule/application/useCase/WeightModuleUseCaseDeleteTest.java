package app.web.weightModule.application.useCase;

import app.web.exception.NotFoundException;
import app.web.weightModule.application.port.crud.WeightModulePortRemove;
import app.web.weightModule.application.port.query.WeightModulePortFindById;
import app.web.weightModule.application.port.query.WeightModulePortFindByProductionLineId;
import app.web.weightModule.domain.WeightModuleTestProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

@ExtendWith({MockitoExtension.class})
class WeightModuleUseCaseDeleteTest {
    @Mock
    WeightModulePortFindById portFindById;
    @Mock
    WeightModulePortRemove portRemove;

    @Mock
    WeightModulePortFindByProductionLineId portFindByProductionLineId;

    WeightModuleUseCaseDelete useCaseDelete;

    @BeforeEach
    void init() {
        this.useCaseDelete = new WeightModuleUseCaseDeleteImpl(portFindById, portFindByProductionLineId, portRemove);
    }

    @Test
    @DisplayName("Weight module delete by id")
    void deleteWeightModuleByIdTest() {
        //given
        final long id = 1L;
        //when
        Mockito.when(portFindById.findByIdWeightModuleOrThrowException(anyLong())).thenReturn(WeightModuleTestProvider.domain());
        final var removedWeightModule = useCaseDelete.deleteWeightModuleById(id);
        //then
        Mockito.verify(portRemove, Mockito.times(1)).removeWeightModule(any());
    }

    @Test
    @DisplayName("Weight module delete by id - not found")
    void deleteWeightModuleByIdNotFoundTest() {
        //given
        final long id = 1L;
        //when
        Mockito.when(portFindById.findByIdWeightModuleOrThrowException(anyLong())).thenThrow(NotFoundException.class);
        //then
        assertThrows(NotFoundException.class, () -> useCaseDelete.deleteWeightModuleById(id));

    }


}