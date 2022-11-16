package app.web.weightModule.adapter.rest;

import app.web.weightModule.application.useCase.WeightModuleUseCaseDelete;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/weight-modules")
@CrossOrigin("*")
@AllArgsConstructor
class WeightModuleRestAdapterDelete {
    private final WeightModuleUseCaseDelete useCaseDelete;

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void removeWeightModule(@PathVariable(name = "id") long weightModuleId) {
        useCaseDelete.deleteWeightModuleById(weightModuleId);
    }
}
