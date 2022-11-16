package app.web.adapter.persistence;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "report_dosing_first_devices")
@Getter()
@Setter(AccessLevel.PACKAGE)
public class ReportDosingDeviceFirstEntity extends ReportDosingDeviceSuper {

    public ReportDosingDeviceFirstEntity() {
        super();
    }

    public ReportDosingDeviceFirstEntity(long id, long version, int recordNumber, float totalMaterialWeight, float correctPercent, float averageWeight) {
        super(id, version, recordNumber, totalMaterialWeight, correctPercent, averageWeight);
    }
}
