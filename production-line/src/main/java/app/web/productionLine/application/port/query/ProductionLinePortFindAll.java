package app.web.productionLine.application.port.query;

import app.web.productionLine.domain.ProductionLine;

import java.util.List;

public interface ProductionLinePortFindAll {
    List<ProductionLine> findAll();
}
