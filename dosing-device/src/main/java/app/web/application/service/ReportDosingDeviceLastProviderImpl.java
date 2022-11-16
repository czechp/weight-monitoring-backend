package app.web.application.service;

import app.web.application.port.crud.DosingDevicePortCRUD;
import app.web.domain.DosingDeviceFactory;
import app.web.report.dto.ReportDosingDevice;
import app.web.report.provider.ReportDosingDeviceLastProvider;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
class ReportDosingDeviceLastProviderImpl implements ReportDosingDeviceLastProvider {
    private final DosingDevicePortCRUD portCRUD;

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public List<ReportDosingDevice> findByLineName(String lineName) {
        return portCRUD.findByLineName(lineName, false)
                .stream()
                .map(DosingDeviceFactory::toReportDto)
                .collect(Collectors.toList());
    }
}
