package app.web.adapter.persistence;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "report_dosing_last_devices")
@Getter()
@Setter(AccessLevel.PACKAGE)
public class ReportDosingDeviceLastEntity extends ReportDosingDeviceSuper {

    public ReportDosingDeviceLastEntity() {
        super();
    }

    public ReportDosingDeviceLastEntity(long id, long version, int recordNumber, float totalMaterialWeight, float correctPercent, float averageWeight) {
        super(id, version, recordNumber, totalMaterialWeight, correctPercent, averageWeight);
    }
}
