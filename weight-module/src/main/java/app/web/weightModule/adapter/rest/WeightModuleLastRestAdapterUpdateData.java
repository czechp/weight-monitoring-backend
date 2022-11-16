package app.web.weightModule.adapter.rest;


import app.web.weightModule.adapter.rest.dto.WeightModuleLastRestAdapterUpdateDto;
import app.web.weightModule.application.dto.WeightModuleUpdateDto;
import app.web.weightModule.application.useCase.WeightModuleLastUseCaseUpdateData;
import app.web.weightModule.application.useCase.WeightModuleUseCaseUpdateData;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/weight-modules-last/data")
@CrossOrigin("*")
@AllArgsConstructor
class WeightModuleLastRestAdapterUpdateData {

    private final WeightModuleLastUseCaseUpdateData useCaseUpdateData;

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateWeightModuleData(@PathVariable(name = "id") long moduleId, @RequestBody WeightModuleLastRestAdapterUpdateDto dto) {
        useCaseUpdateData.updateModuleData(moduleId, dto.getWeightModuleDto(), dto.getWeightModuleLastDto());
    }


}
