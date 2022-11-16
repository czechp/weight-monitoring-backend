package app.web.application.useCase;

import app.web.domain.DosingDevice;

import java.util.List;

public interface DosingDeviceUseCaseCreate {
    List<DosingDevice> createDosingDevices(int amount, long moduleId, String lineName, boolean first);
}
