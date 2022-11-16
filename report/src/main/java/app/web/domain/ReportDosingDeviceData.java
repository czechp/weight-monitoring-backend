package app.web.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Getter(AccessLevel.PACKAGE)
class ReportDosingDeviceData {
    private final long id;
    private final long version;
    private final int recordNumber;
    private final float totalMaterialWeight;
    private final float correctPercent;
    private final float averageWeight;

    public ReportDosingDeviceData(int recordNumber, float totalMaterialWeight, float correctPercent, float averageWeight) {
        this.id = 0L;
        this.version = 0L;
        this.recordNumber = recordNumber;
        this.totalMaterialWeight = totalMaterialWeight;
        this.correctPercent = correctPercent;
        this.averageWeight = averageWeight;
    }
}
