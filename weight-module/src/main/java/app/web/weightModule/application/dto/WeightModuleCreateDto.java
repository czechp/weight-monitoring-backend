package app.web.weightModule.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeightModuleCreateDto {
    private long productionLineId;
    @Min(1)
    @NotNull
    private int dosingDevicesAmount;
}
