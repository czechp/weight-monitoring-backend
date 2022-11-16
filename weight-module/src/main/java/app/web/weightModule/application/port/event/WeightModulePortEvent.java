package app.web.weightModule.application.port.event;

import app.web.dosingDevice.dto.DosingDeviceUpdateData;
import app.web.weightModule.application.dto.WeightModuleUpdateDto;
import app.web.weightModule.domain.WeightModule;
import app.web.weightModule.domain.WeightModuleAbstract;
import app.web.weightModule.event.WeightModuleCreateData;

import java.util.List;

public interface WeightModulePortEvent {
    void notifyAboutModuleCreating(WeightModuleAbstract weightModuleAbstract, int dosingDeviceAmount);
    void notifyAboutUpdateDosingDevice(long moduleId, List<? extends DosingDeviceUpdateData> dosingDeviceUpdateData, boolean isFirst);

    void notifyAboutCreatingReportForLine(long lineId);
}
