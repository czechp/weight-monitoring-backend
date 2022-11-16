package app.web.report.provider;

import app.web.report.dto.ReportSummary;

import java.util.Optional;

public interface ReportSummaryProvider {
    Optional<ReportSummary> findByModuleId(long lineId);
}
