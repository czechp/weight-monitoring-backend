package app.web.weightModule.application.dto;

import app.web.dosingDevice.dto.DosingDeviceUpdateData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeightModuleUpdateDto {
    private float productUpRangeWeight = 0f;
    private float productDownRangeWeight = 0f;
    private int currentDosingDevice = 0;
    private float currentMeasure = 0f;
    private boolean status = false;
    private float totalMaterialWeight = 0f;
    private long totalProductPcs = 0L;
    private float correctProductPercent = 0f;
    private List<DosingDeviceUpdateDto> dosingDevices;
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class DosingDeviceUpdateDto implements DosingDeviceUpdateData {
        private  int recordNumber;
        private float lastMeasure;
        private int amountBelowMeasures;
        private int amountCorrectMeasures;
        private int amountAboveMeasures;
        private float averageMeasure;
        private int correctMeasuresPercent;
        private float totalMaterial;
    }
}
