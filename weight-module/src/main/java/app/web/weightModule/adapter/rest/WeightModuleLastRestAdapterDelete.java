package app.web.weightModule.adapter.rest;


import app.web.weightModule.application.useCase.WeightModuleLastUseCaseDelete;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/weight-modules-last")
@CrossOrigin("*")
@AllArgsConstructor
class WeightModuleLastRestAdapterDelete {
    private final WeightModuleLastUseCaseDelete useCaseDelete;

    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Secured({"ROLE_ADMIN"})
    void deleteWeightModuleLastById(@PathVariable(name = "id") long moduleId) {
        useCaseDelete.removeById(moduleId);
    }
}
