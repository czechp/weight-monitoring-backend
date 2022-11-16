package app.web.weightModule.adapter.provider;

import app.web.productionLine.ProductionLineFacade;
import app.web.productionLine.dto.ProductionLineFacadeDto;
import app.web.weightModule.application.port.query.WeightModulePortFindProductionLineById;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
class ProductionLineProvider implements WeightModulePortFindProductionLineById {
    private final ProductionLineFacade productionLineFacade;

    @Override
    public Optional<ProductionLineFacadeDto> findProductionLineById(long id) {
        return productionLineFacade.findProductionLineById(id);
    }
}
