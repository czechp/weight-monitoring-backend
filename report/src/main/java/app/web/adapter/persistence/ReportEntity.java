package app.web.adapter.persistence;

import app.web.domain.WorkShift;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "reports")
@NoArgsConstructor
@Getter()
@Setter(AccessLevel.PACKAGE)
public class ReportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Version
    private long version;
    private String lineName;
    private LocalDate reportDate;
    @Enumerated(EnumType.STRING)
    private WorkShift workShift;
    private long totalProductPcs;
    private float totalMaterialWeight;
    private float weightDifference;
    private float correctProductPercent;
    private long incorrectProductPcs;
    private long overFilledProductPcs;
    private long notRefilledProductPcs;
    @OneToMany(mappedBy = "report", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ReportDosingDeviceFirstEntity> firstDosingDevices = new ArrayList<>();
    @OneToMany(mappedBy = "report", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ReportDosingDeviceLastEntity> lastDosingDevices = new ArrayList<>();

    public ReportEntity(long id,
                        long version,
                        String lineName,
                        LocalDate reportDate,
                        WorkShift workShift,
                        long totalProductPcs,
                        float totalMaterialWeight,
                        float weightDifference,
                        float correctProductPercent,
                        long incorrectProductPcs,
                        long overFilledProductPcs,
                        long notRefilledProductPcs) {
        this.id = id;
        this.version = version;
        this.lineName = lineName;
        this.reportDate = reportDate;
        this.workShift = workShift;
        this.totalProductPcs = totalProductPcs;
        this.totalMaterialWeight = totalMaterialWeight;
        this.weightDifference = weightDifference;
        this.correctProductPercent = correctProductPercent;
        this.incorrectProductPcs = incorrectProductPcs;
        this.overFilledProductPcs = overFilledProductPcs;
        this.notRefilledProductPcs = notRefilledProductPcs;
    }

    public ReportEntity(long id,
                        long version,
                        String lineName,
                        LocalDate reportDate,
                        WorkShift workShift,
                        long totalProductPcs,
                        float totalMaterialWeight,
                        float weightDifference,
                        float correctProductPercent,
                        long incorrectProductPcs,
                        long overFilledProductPcs,
                        long notRefilledProductPcs,
                        List<ReportDosingDeviceFirstEntity> firstDosingDevices,
                        List<ReportDosingDeviceLastEntity> lastDosingDevices
                        ) {
        this.id = id;
        this.version = version;
        this.lineName = lineName;
        this.reportDate = reportDate;
        this.workShift = workShift;
        this.totalProductPcs = totalProductPcs;
        this.totalMaterialWeight = totalMaterialWeight;
        this.weightDifference = weightDifference;
        this.correctProductPercent = correctProductPercent;
        this.incorrectProductPcs = incorrectProductPcs;
        this.overFilledProductPcs = overFilledProductPcs;
        this.notRefilledProductPcs = notRefilledProductPcs;
        firstDosingDevices.forEach(this::addFirstDosingDevice);
        lastDosingDevices.forEach(this::addLastDosingDevice);
    }


    void addFirstDosingDevice(ReportDosingDeviceFirstEntity entity) {
        this.firstDosingDevices.add(entity);
        entity.setReport(this);
    }


    void addLastDosingDevice(ReportDosingDeviceLastEntity entity) {
        this.lastDosingDevices.add(entity);
        entity.setReport(this);
    }
}
