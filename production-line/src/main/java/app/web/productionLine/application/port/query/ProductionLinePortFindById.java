package app.web.productionLine.application.port.query;

import app.web.productionLine.domain.ProductionLine;

import java.util.Optional;

public interface ProductionLinePortFindById {
    Optional<ProductionLine> findProductionLineById(long id);
}
