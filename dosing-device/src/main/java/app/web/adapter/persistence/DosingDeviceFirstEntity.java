package app.web.adapter.persistence;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "first_dosing_device")
@NoArgsConstructor
@Getter()
@Setter(AccessLevel.PACKAGE)
public class DosingDeviceFirstEntity extends DosingSuperEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private FirstModuleEntity firstModuleEntity;

    public DosingDeviceFirstEntity(long id,
                                   long version,
                                   String lineName,
                                   int recordNumber,
                                   float totalMaterial,
                                   float lastMeasure,
                                   int amountBelowMeasures,
                                   int amountCorrectMeasures,
                                   int amountAboveMeasures,
                                   float averageMeasure,
                                   int correctMeasurePercent,
                                   FirstModuleEntity firstModuleEntity) {
        super(id,
                version,
                lineName,
                recordNumber,
                totalMaterial,
                lastMeasure,
                amountBelowMeasures,
                amountCorrectMeasures,
                amountAboveMeasures,
                averageMeasure,
                correctMeasurePercent);
        this.firstModuleEntity = firstModuleEntity;
    }
}
