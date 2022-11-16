package app.web.productionLine.application.service;

import app.web.productionLine.ProductionLineFacade;
import app.web.productionLine.application.port.query.ProductionLinePortFindById;
import app.web.productionLine.domain.ProductionLineFactory;
import app.web.productionLine.dto.ProductionLineFacadeDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
class ProductionLineFacadeImpl implements ProductionLineFacade {
    private final ProductionLinePortFindById productionLinePortFindById;

    @Override
    public Optional<ProductionLineFacadeDto> findProductionLineById(long id) {
        return productionLinePortFindById.findProductionLineById(id)
                .map(ProductionLineFactory::toFacadeDto);
    }
}
