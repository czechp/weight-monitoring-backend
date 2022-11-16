package app.web.weightModule.adapter.rest;


import app.web.weightModule.application.dto.WeightModuleCreateDto;
import app.web.weightModule.application.useCase.WeightModuleLastUseCaseCreate;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/weight-modules-last")
@CrossOrigin("*")
@AllArgsConstructor
class WeightModuleLastRestAdapterCreate {
    private final WeightModuleLastUseCaseCreate useCaseCreate;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Secured({"ROLE_ADMIN"})
    void createWeightModuleLast(@RequestBody WeightModuleCreateDto dto){
        useCaseCreate.create(dto);
    }
}
