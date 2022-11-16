package app.web.adapter.persistence;

import app.web.application.dto.ReportDosingDeviceQueryDto;
import app.web.application.dto.ReportQueryDto;
import app.web.application.port.ReportPortQuery;
import app.web.domain.ReportFactory;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
class ReportPersistenceAdapterQuery implements ReportPortQuery {
    private final ReportRepository repository;
    private final ReportDosingDeviceFirstRepository firstRepository;
    private final ReportDosingDeviceLastRepository lastRepository;

    @Override
    public List<ReportQueryDto> findAll(Pageable pageable) {
        return repository.findAll(pageable)
                .stream()
                .map(ReportFactory::toSimpleDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ReportQueryDto> findById(long id) {
        return repository.findById(id)
                .map(ReportFactory::toDto);
    }

    @Override
    public List<ReportDosingDeviceQueryDto> findAllFirstDosingDevices(long reportId, Pageable pageable) {
        return firstRepository.findByReport_Id(reportId, pageable)
                .stream()
                .map(ReportFactory::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ReportDosingDeviceQueryDto> findAllLastDosingDevices(long reportId, Pageable pageable) {
        return lastRepository.findByReport_Id(reportId, pageable)
                .stream()
                .map(ReportFactory::toDto)
                .collect(Collectors.toList());
    }
}
