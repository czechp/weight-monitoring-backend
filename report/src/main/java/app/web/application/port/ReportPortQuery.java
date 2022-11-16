package app.web.application.port;

import app.web.application.dto.ReportDosingDeviceQueryDto;
import app.web.application.dto.ReportQueryDto;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ReportPortQuery {
    List<ReportQueryDto> findAll(Pageable pageable);
    Optional<ReportQueryDto> findById(long id);

    List<ReportDosingDeviceQueryDto> findAllFirstDosingDevices(long reportId, Pageable pageable);

    List<ReportDosingDeviceQueryDto> findAllLastDosingDevices(long reportId, Pageable pageable);
}
