package app.web.report.provider;

import app.web.report.dto.ReportLine;

import java.util.List;

public interface ReportLineProvider {
    List<? extends ReportLine> findAllLines();
}
