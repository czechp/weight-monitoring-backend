package app.web.adapter.persistence;

import lombok.*;

import javax.persistence.*;

@MappedSuperclass()
@Getter
@Setter(AccessLevel.PACKAGE)
@NoArgsConstructor
public abstract class ReportDosingDeviceSuper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Version
    private long version;
    private  int recordNumber=0;
    private  float totalMaterialWeight=0;
    private  float correctPercent=0;
    private  float averageWeight=0;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private ReportEntity report;

    public ReportDosingDeviceSuper(long id, long version, int recordNumber, float totalMaterialWeight, float correctPercent, float averageWeight) {
        this.id = id;
        this.version = version;
        this.recordNumber = recordNumber;
        this.totalMaterialWeight = totalMaterialWeight;
        this.correctPercent = correctPercent;
        this.averageWeight = averageWeight;
    }
}
