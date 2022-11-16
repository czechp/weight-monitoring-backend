package app.web.application.service;

import app.web.application.port.crud.DosingDevicePortCRUD;
import app.web.domain.DosingDeviceFactory;
import app.web.report.dto.ReportDosingDevice;
import app.web.report.provider.ReportDosingDeviceFirstProvider;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
class ReportDosingDeviceFirstProviderImpl implements ReportDosingDeviceFirstProvider {
    private final DosingDevicePortCRUD portCRUD;

    @Override
    public List<ReportDosingDevice> findByLineName(String lineName) {
        return portCRUD.findByLineName(lineName, true)
                .stream()
                .map(DosingDeviceFactory::toReportDto)
                .collect(Collectors.toList());
    }
}
