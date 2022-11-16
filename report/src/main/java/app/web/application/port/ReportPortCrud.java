package app.web.application.port;

import app.web.domain.Report;

public interface ReportPortCrud {
    Report save(Report report);
    void removeById(long reportId);
}
