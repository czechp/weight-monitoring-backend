package app.web.productionLine.application.useCase;

import app.web.productionLine.domain.ProductionLine;

public interface ProductionLineUseCaseDeleteById {
    ProductionLine deleteById(long id);
}
