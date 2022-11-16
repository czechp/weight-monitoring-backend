package app.web.adapter.persistence;

import app.web.application.port.ReportPortCrud;
import app.web.domain.Report;
import app.web.domain.ReportFactory;
import app.web.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
class ReportPersistenceAdapterCrud implements ReportPortCrud {
    private final ReportRepository repository;

    @Override
    public void removeById(long reportId) {
        repository.findById(reportId)
                .ifPresentOrElse(
                        repository::delete,
                        () -> {throw new NotFoundException("Raport z id: " + reportId + " nie istnieje");}
                );
    }

    @Override
    public Report save(Report report) {
        final ReportEntity reportEntity = ReportFactory.toEntity(report);
        return  ReportFactory.create(repository.save(reportEntity));
    }
}
