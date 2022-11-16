package app.web.application.query;

import app.web.application.dto.ReportDosingDeviceQueryDto;
import app.web.application.dto.ReportQueryDto;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ReportQuery {
    List<ReportQueryDto> findAll(Pageable pageable);
    Optional<ReportQueryDto> findById(long id);
    List<ReportDosingDeviceQueryDto> findAllFirstDosingDevices(long reportId, Pageable pageable);
    List<ReportDosingDeviceQueryDto> findAllLastDosingDevices(long reportId, Pageable pageable);
}
