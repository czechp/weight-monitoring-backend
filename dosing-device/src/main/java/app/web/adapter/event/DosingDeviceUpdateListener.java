package app.web.adapter.event;

import app.web.application.useCase.DosingDeviceUseCaseUpdate;
import app.web.dosingDevice.dto.DosingDeviceUpdateEvent;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
class DosingDeviceUpdateListener implements ApplicationListener<DosingDeviceUpdateEvent> {
    private final DosingDeviceUseCaseUpdate useCaseUpdate;
    @Override
    public void onApplicationEvent(DosingDeviceUpdateEvent event) {
        useCaseUpdate.updateDosingDevicesByModuleId(event.getModuleId(), event.getUpdateDtoList(), event.isFirst());
    }
}
