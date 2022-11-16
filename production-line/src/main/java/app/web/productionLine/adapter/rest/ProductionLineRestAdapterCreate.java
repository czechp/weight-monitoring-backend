package app.web.productionLine.adapter.rest;

import app.web.productionLine.application.dto.ProductionLineCreateDto;
import app.web.productionLine.application.useCase.ProductionLineUseCaseCreate;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/production-lines")
@CrossOrigin("*")
@AllArgsConstructor
@Validated
class ProductionLineRestAdapterCreate {
    private final ProductionLineUseCaseCreate productionLineUseCaseCreate;

    @PostMapping()
    @Secured({"ROLE_ADMIN"})
    @ResponseStatus(HttpStatus.CREATED)
    void createProductionLine(@RequestBody @Valid ProductionLineCreateDto dto) {
        productionLineUseCaseCreate.createProductionLine(dto);
    }

}
