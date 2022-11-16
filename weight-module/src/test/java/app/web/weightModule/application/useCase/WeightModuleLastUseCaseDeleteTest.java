package app.web.weightModule.application.useCase;

import app.web.weightModule.application.port.crud.WeightModuleLastPortRemove;
import app.web.weightModule.application.port.query.WeightModuleLastPortFindByIdOrThrow;
import app.web.weightModule.domain.WeightModuleLastTestProvider;
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
class WeightModuleLastUseCaseDeleteTest {

    @Mock
    WeightModuleLastPortFindByIdOrThrow portFindByIdOrThrow;
    @Mock
    WeightModuleLastPortRemove portRemove;

    WeightModuleLastUseCaseDelete useCaseDelete;

    @BeforeEach
    void init() {
        this.useCaseDelete = new WeightModuleLastUseCaseDeleteImpl(portFindByIdOrThrow, portRemove);
    }

    @Test
    @DisplayName("Remove by id")
    void removeWeightModuleLastTest() {
        //given
        final var moduleId = 1L;
        final var weightModuleToRemove = WeightModuleLastTestProvider.domain();
        //when
        Mockito.when(portFindByIdOrThrow.findByIdOrThrowException(anyLong())).thenReturn(weightModuleToRemove);
        final var removeModule = useCaseDelete.removeById(moduleId);
        //then
        Mockito.verify(portRemove, Mockito.times(1)).remove(any());
    }
}