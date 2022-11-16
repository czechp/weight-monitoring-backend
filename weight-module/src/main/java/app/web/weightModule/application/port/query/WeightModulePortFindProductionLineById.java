package app.web.weightModule.application.port.query;

import app.web.productionLine.dto.ProductionLineFacadeDto;

import java.util.Optional;

public interface WeightModulePortFindProductionLineById {
    Optional<ProductionLineFacadeDto> findProductionLineById(long id);
}
