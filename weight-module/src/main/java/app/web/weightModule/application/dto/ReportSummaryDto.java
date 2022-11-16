package app.web.weightModule.application.dto;

import app.web.report.dto.ReportSummary;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public
class ReportSummaryDto implements ReportSummary {
    private final String lineName;
    private final long totalProductPcs;
    private final float totalMaterialWeight;
    private final float weightDifference;
    private final float correctProductPercent;
    private final long incorrectProductPcs;
    private final long overFilledProductPcs;
    private final long notFulFilledProductPcs;
}
