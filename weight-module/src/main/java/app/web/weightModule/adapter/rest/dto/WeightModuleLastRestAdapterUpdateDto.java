package app.web.weightModule.adapter.rest.dto;

import app.web.weightModule.application.dto.WeightModuleLastUpdateDto;
import app.web.weightModule.application.dto.WeightModuleUpdateDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WeightModuleLastRestAdapterUpdateDto {
    @JsonProperty("moduleInfo")
    private final WeightModuleUpdateDto weightModuleDto;
    @JsonProperty("lastModuleInfo")
    private final WeightModuleLastUpdateDto weightModuleLastDto;
}
