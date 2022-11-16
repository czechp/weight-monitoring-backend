package app.web.productionLine.application.service;

import app.web.productionLine.application.port.query.ProductionLinePortFindAll;
import app.web.productionLine.domain.ProductionLineFactory;
import app.web.report.dto.ReportLine;
import app.web.report.provider.ReportLineProvider;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
class ReportLineProviderImpl implements ReportLineProvider {
    private final ProductionLinePortFindAll portFindAll;
    @Override
    public List<? extends ReportLine> findAllLines() {
        return portFindAll.findAll()
                .stream()
                .map(ProductionLineFactory::toReportDto)
                .collect(Collectors.toList());
    }
}
