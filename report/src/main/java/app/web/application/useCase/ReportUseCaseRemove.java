package app.web.application.useCase;

import app.web.domain.Report;

public interface ReportUseCaseRemove {
    void removeById(long reportId);
}
