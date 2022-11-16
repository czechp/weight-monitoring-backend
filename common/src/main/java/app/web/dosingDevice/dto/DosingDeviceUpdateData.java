package app.web.dosingDevice.dto;

public interface DosingDeviceUpdateData {
    int getRecordNumber();
    float getLastMeasure();
    int getAmountBelowMeasures();
    int getAmountCorrectMeasures();
    int getAmountAboveMeasures();
    float getAverageMeasure();
    int getCorrectMeasuresPercent();
    float getTotalMaterial();
}
