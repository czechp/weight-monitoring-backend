package app.web.application.useCase;

import app.web.application.port.ReportPortCrud;
import app.web.domain.Report;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
class ReportUseCaseRemoveImpl implements  ReportUseCaseRemove{
    private final ReportPortCrud portCrud;

    @Override
    public void removeById(long reportId) {
        portCrud.removeById(reportId);
    }
}
