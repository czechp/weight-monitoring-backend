package app.web.productionLine.application.query;

import app.web.productionLine.application.dto.ProductionLineQueryDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductionLineQuery {
    ProductionLineQueryDto findProductionLineById(long id);

    List<ProductionLineQueryDto> findAllProductionLines(Pageable pageable);
}
