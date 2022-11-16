package app.web.weightModule.adapter.rest;

import app.web.weightModule.application.dto.WeightModuleUpdateDto;
import app.web.weightModule.application.useCase.WeightModuleUseCaseUpdateData;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/weight-modules/data")
@CrossOrigin("*")
@AllArgsConstructor
class WeightModuleRestAdapterUpdateData {
    private final WeightModuleUseCaseUpdateData useCaseUpdateData;

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateWeightModuleData(@PathVariable(name = "id") long weightModuleId, @RequestBody WeightModuleUpdateDto weightModuleUpdateDto) {
        useCaseUpdateData.updateWeightModuleData(weightModuleId, weightModuleUpdateDto);
    }

}
