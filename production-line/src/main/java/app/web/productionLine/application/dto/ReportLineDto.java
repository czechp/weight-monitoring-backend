package app.web.productionLine.application.dto;

import app.web.report.dto.ReportLine;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ReportLineDto implements ReportLine {
    private final long lineId;
    private final String lineName;

    @Override
    public long getLineId() {
        return lineId;
    }

    @Override
    public String getLineName() {
        return lineName;
    }
}
