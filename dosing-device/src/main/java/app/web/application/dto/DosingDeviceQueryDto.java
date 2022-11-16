package app.web.application.dto;

import app.web.domain.ModuleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DosingDeviceQueryDto {
    private long id;
    private ModuleInfoDto moduleInfo;
    private ModuleType moduleType;
    private int recordNumber;
    private float totalMaterial;
    private MeasuresDto measures;

    @AllArgsConstructor
    @Data
    public static
    class ModuleInfoDto {
        private final long moduleId;
        private final String lineName;
    }

    @AllArgsConstructor
    @Data
    public static class MeasuresDto {
        protected float correctMeasurePercent;
        private float lastMeasure;
        private int amountBelowMeasures;
        private int amountCorrectMeasures;
        private int amountAboveMeasures;
        private float averageMeasure;
    }


}
