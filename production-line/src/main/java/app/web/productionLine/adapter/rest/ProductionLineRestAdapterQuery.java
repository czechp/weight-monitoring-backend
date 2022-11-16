package app.web.productionLine.adapter.rest;

import app.web.productionLine.application.dto.ProductionLineQueryDto;
import app.web.productionLine.application.query.ProductionLineQuery;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/production-lines")
@CrossOrigin("*")
@AllArgsConstructor
class ProductionLineRestAdapterQuery {
    private final ProductionLineQuery productionLineQuery;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<ProductionLineQueryDto> findAllProductionLines(Pageable pageable) {
        return productionLineQuery.findAllProductionLines(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ProductionLineQueryDto findByIdProductionLine(@PathVariable(name = "id") long lineId) {
        return productionLineQuery.findProductionLineById(lineId);
    }
}
