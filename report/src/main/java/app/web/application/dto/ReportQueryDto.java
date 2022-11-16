package app.web.application.dto;

import app.web.domain.WorkShift;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public class ReportQueryDto {
    private final long id;
    private final LocalDate reportDate;
    private final String lineName;
    private final WorkShift workShift;
    private final long totalProductPcs;
    private final float totalMaterialWeight;
    private final float weightDifference;
    private final float correctProductPercent;
    private final long incorrectProductPcs;
    private final long overFilledProductPcs;
    private final long notRefilledProductPcs;
}
