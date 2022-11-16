package app.web.productionLine.application.useCase;

import app.web.productionLine.application.dto.ProductionLineCreateDto;
import app.web.productionLine.domain.ProductionLine;

public interface ProductionLineUseCaseCreate {
    ProductionLine createProductionLine(ProductionLineCreateDto dto);
}
