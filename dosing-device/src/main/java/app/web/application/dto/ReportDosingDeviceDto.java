package app.web.application.dto;

import app.web.report.dto.ReportDosingDevice;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ReportDosingDeviceDto implements ReportDosingDevice {
    private final int recordNumber;
    private final float totalMaterial;
    private final float correctPercent;
    private final float averageMeasure;

    @Override
    public int getRecordNumber() {
        return recordNumber;
    }

    @Override
    public float getTotalMaterial() {
        return totalMaterial;
    }

    @Override
    public float getCorrectPercent() {
        return correctPercent;
    }

    @Override
    public float getAverageMeasure() {
        return averageMeasure;
    }
}
