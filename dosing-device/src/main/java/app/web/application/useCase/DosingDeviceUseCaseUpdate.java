package app.web.application.useCase;

import app.web.domain.DosingDevice;
import app.web.dosingDevice.dto.DosingDeviceUpdateData;

import java.util.List;

public interface DosingDeviceUseCaseUpdate {
    List<DosingDevice> updateDosingDevicesByModuleId(long moduleId, List<? extends DosingDeviceUpdateData> newValues, boolean isFirst);
}
