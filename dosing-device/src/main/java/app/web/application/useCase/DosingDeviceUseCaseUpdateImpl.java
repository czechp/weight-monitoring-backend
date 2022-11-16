package app.web.application.useCase;

import app.web.application.port.crud.DosingDevicePortCRUD;
import app.web.domain.DosingDevice;
import app.web.dosingDevice.dto.DosingDeviceUpdateData;
import app.web.exception.ConditionsNotFulFiledException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
class DosingDeviceUseCaseUpdateImpl implements DosingDeviceUseCaseUpdate {
    private final DosingDevicePortCRUD portCRUD;

    @Override
    public List<DosingDevice> updateDosingDevicesByModuleId(long moduleId, List<? extends DosingDeviceUpdateData> newValues, boolean isFirst) {
        List<DosingDevice> dosingDevices = portCRUD.findByModuleId(moduleId, isFirst);
        List<DosingDevice> updatedDosingDevices = dosingDevices.stream()
                .map(dosingDevice -> {
                    final var appropriateDto = newValues.stream()
                            .filter(dto -> dto.getRecordNumber() == dosingDevice.getRecordNumber())
                            .findAny()
                            .orElseThrow(() -> new ConditionsNotFulFiledException("Lack of appropriate dto for dosing device domain. Record nr.:" + dosingDevice.getRecordNumber()));
                    dosingDevice.updateData(appropriateDto);
                    portCRUD.save(dosingDevice);
                    return dosingDevice;
                })
                .collect(Collectors.toList());
        return updatedDosingDevices;
    }
}
