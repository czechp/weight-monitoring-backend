package app.web.weightModule.application.service;

import app.web.report.dto.ReportSummary;
import app.web.report.provider.ReportSummaryProvider;
import app.web.weightModule.application.port.query.WeightModuleLastPortFindByProductionLineId;
import app.web.weightModule.domain.WeightModuleLastFactory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
class ReportSummaryProviderImpl implements ReportSummaryProvider {
    private final WeightModuleLastPortFindByProductionLineId portFindByProductionLineId;

    @Override
    public Optional<ReportSummary> findByModuleId(long lineId) {
        return portFindByProductionLineId.findByProductionLineId(lineId)
                .stream()
                .map(WeightModuleLastFactory::toReportDto)
                .findAny();
    }
}
