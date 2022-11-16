package app.web.application.query;

import app.web.application.dto.ReportDosingDeviceQueryDto;
import app.web.application.dto.ReportQueryDto;
import app.web.application.port.ReportPortQuery;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
class ReportQueryImpl implements ReportQuery{
    private final ReportPortQuery reportPortQuery;
    @Override
    public List<ReportQueryDto> findAll(Pageable pageable) {
        return reportPortQuery.findAll(pageable);
    }

    @Override
    public Optional<ReportQueryDto> findById(long id) {
        return reportPortQuery.findById(id);
    }

    @Override
    public List<ReportDosingDeviceQueryDto> findAllFirstDosingDevices(long reportId, Pageable pageable) {
        return reportPortQuery.findAllFirstDosingDevices(reportId, pageable);
    }

    @Override
    public List<ReportDosingDeviceQueryDto> findAllLastDosingDevices(long reportId, Pageable pageable) {
        return reportPortQuery.findAllLastDosingDevices(reportId, pageable);
    }
}
