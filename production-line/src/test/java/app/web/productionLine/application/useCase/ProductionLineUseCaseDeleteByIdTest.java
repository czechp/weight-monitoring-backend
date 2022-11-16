package app.web.productionLine.application.useCase;

import app.web.productionLine.application.port.crud.ProductionLinePortDeleteById;
import app.web.productionLine.application.port.crud.ProductionLinePortFindByIdOrException;
import app.web.productionLine.domain.ProductionLineTestCasesProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyLong;

@ExtendWith(MockitoExtension.class)
class ProductionLineUseCaseDeleteByIdTest {
    @Mock
    ProductionLinePortFindByIdOrException productionLinePortFindByIdOrException;
    @Mock
    ProductionLinePortDeleteById productionLinePortDeleteById;


    ProductionLineUseCaseDeleteById productionLineUseCaseDeleteById;

    @BeforeEach
    void init() {
        this.productionLineUseCaseDeleteById = new ProductionLineUseCaseDeleteImpl(
                productionLinePortFindByIdOrException,
                productionLinePortDeleteById
        );
    }

    @Test
    void deleteProductionLineByIdTest() {
        //given
        final var productionLineId = 1L;
        //when
        Mockito.when(productionLinePortFindByIdOrException.findProductionLineByIdOrException(anyLong()))
                .thenReturn(ProductionLineTestCasesProvider.getProductionLineToDelete());
        final var deletedProductionLine = productionLineUseCaseDeleteById.deleteById(productionLineId);
        //then
        Mockito.verify(productionLinePortDeleteById, Mockito.times(1))
                .deleteProductionLineById(anyLong());
    }
}
