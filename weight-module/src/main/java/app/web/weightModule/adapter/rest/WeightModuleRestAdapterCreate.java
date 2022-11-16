package app.web.weightModule.adapter.rest;

import app.web.weightModule.application.dto.WeightModuleCreateDto;
import app.web.weightModule.application.useCase.WeightModuleUseCaseCreate;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
@RequestMapping("/api/weight-modules")
class WeightModuleRestAdapterCreate {
    private final WeightModuleUseCaseCreate useCaseCreate;

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Secured({"ROLE_ADMIN"})
    void createWeightModule(@RequestBody WeightModuleCreateDto createDto) {
        useCaseCreate.createWeighModule(createDto);
    }
}
