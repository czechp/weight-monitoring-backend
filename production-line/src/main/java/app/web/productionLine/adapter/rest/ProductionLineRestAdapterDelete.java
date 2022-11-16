package app.web.productionLine.adapter.rest;

import app.web.productionLine.application.useCase.ProductionLineUseCaseDeleteById;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/production-lines")
@AllArgsConstructor
class ProductionLineRestAdapterDelete {
    private final ProductionLineUseCaseDeleteById productionLineUseCaseDeleteById;

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Secured({"ROLE_ADMIN"})
    void deleteProductionLine(@PathVariable(name = "id") long productionLineId) {
        productionLineUseCaseDeleteById.deleteById(productionLineId);
    }
}
