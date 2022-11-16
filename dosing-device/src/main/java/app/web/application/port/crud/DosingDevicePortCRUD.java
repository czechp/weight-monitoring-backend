package app.web.application.port.crud;

import app.web.domain.DosingDevice;

import java.util.List;

public interface DosingDevicePortCRUD {
    DosingDevice save(DosingDevice dosingDevice);

    List<DosingDevice> findByModuleId(long moduleId, boolean isFirst);

    List<DosingDevice> findByLineName(String lineName, boolean isFirst);
}
