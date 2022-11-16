package app.web.adapter.persistence;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter(AccessLevel.PACKAGE)
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@MappedSuperclass
class DosingSuperEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Version
    private long version;
    protected String lineName;
    private int recordNumber;
    private float totalMaterial;
    protected float lastMeasure;
    protected int amountBelowMeasures;
    protected int amountCorrectMeasures;
    protected int amountAboveMeasures;
    protected float averageMeasure;
    protected int correctMeasurePercent;
}
