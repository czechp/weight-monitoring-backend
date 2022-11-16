package app.web.productionLine.application.useCase;

import app.web.exception.ConditionsNotFulFiledException;
import app.web.productionLine.application.dto.ProductionLineCreateDto;
import app.web.productionLine.application.port.crud.ProductionLinePortSave;
import app.web.productionLine.application.port.query.ProductionLinePortExistByName;
import app.web.productionLine.domain.ProductionLine;
import app.web.productionLine.domain.ProductionLineFactory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
class ProductionLineUseCaseCreateImpl implements ProductionLineUseCaseCreate {
    private final ProductionLinePortExistByName productionLinePortExistByName;
    private final ProductionLinePortSave productionLinePortSave;

    @Override
    public ProductionLine createProductionLine(ProductionLineCreateDto dto) {
        if (!productionLinePortExistByName.existsByName(dto.getLineName())) {
            final var createdLine = ProductionLineFactory.create(dto.getLineName());
            productionLinePortSave.saveProductionLine(createdLine);
            return createdLine;
        } else throw new ConditionsNotFulFiledException("Linia o takiej nazwie już istnieje");

    }
}

