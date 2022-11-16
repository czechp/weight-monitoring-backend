package app.web.productionLine;

import app.web.productionLine.dto.ProductionLineFacadeDto;

import java.util.Optional;

public interface ProductionLineFacade {
    Optional<ProductionLineFacadeDto> findProductionLineById(long id);
}
