package app.web.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
@Getter(AccessLevel.PACKAGE)
class Measures {
    protected float lastMeasure;
    protected int amountBelowMeasures;
    protected int amountCorrectMeasures;
    protected int amountAboveMeasures;
    protected float averageMeasure;
    protected int correctMeasurePercent;

}
