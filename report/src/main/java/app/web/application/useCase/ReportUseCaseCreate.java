package app.web.application.useCase;

import app.web.domain.Report;
import app.web.domain.WorkShift;

import java.util.List;

public interface ReportUseCaseCreate {
    List<Report> createForAllLines(WorkShift workShift);

    Report createForSingleLine(long lineId);
}
