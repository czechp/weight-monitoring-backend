package app.web.productionLine.application.useCase;

import app.web.exception.ConditionsNotFulFiledException;
import app.web.productionLine.application.dto.ProductionLineCreateDto;
import app.web.productionLine.application.port.crud.ProductionLinePortSave;
import app.web.productionLine.application.port.query.ProductionLinePortExistByName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductionLineUseCaseCreateTest {
    @Mock
    ProductionLinePortExistByName productionLinePortExistsByName;

    @Mock
    ProductionLinePortSave productionLinePortSave;

    ProductionLineUseCaseCreate productionLineUseCaseCreate;

    @BeforeEach
    void init() {
        this.productionLineUseCaseCreate = new ProductionLineUseCaseCreateImpl(
                productionLinePortExistsByName,
                productionLinePortSave);
    }

    @Test
    void productionLineCreateTest() {
        //given
        final var productionLineCreateDto = new ProductionLineCreateDto("Some a new line");
        //when
        Mockito.when(productionLinePortExistsByName.existsByName(anyString())).thenReturn(false);
        final var createdProductionLine = productionLineUseCaseCreate.createProductionLine(productionLineCreateDto);
        //then
        assertEquals(productionLineCreateDto.getLineName(), createdProductionLine.getLineName());
        verify(productionLinePortSave, times(1)).saveProductionLine(any());
    }

    @Test
    void productionLineCreateLineNameAlreadyExistsTest() {
        //given
        final var productionLineCreateDto = new ProductionLineCreateDto("Some a new line");
        //when
        Mockito.when(productionLinePortExistsByName.existsByName(anyString())).thenReturn(true);
        //then
        assertThrows(ConditionsNotFulFiledException.class, () -> productionLineUseCaseCreate.createProductionLine(productionLineCreateDto));
    }
}
