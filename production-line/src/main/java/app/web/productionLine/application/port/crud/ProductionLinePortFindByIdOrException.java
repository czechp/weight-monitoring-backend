package app.web.productionLine.application.port.crud;

import app.web.productionLine.domain.ProductionLine;

public interface ProductionLinePortFindByIdOrException {
    ProductionLine findProductionLineByIdOrException(long lineId);
}
