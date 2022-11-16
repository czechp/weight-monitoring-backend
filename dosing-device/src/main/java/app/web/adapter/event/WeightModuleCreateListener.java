package app.web.adapter.event;

import app.web.application.useCase.DosingDeviceUseCaseCreate;
import app.web.weightModule.event.WeightModuleCreateEvent;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
class WeightModuleCreateListener implements ApplicationListener<WeightModuleCreateEvent> {
    private final DosingDeviceUseCaseCreate useCaseCreate;

    @Override
    public void onApplicationEvent(WeightModuleCreateEvent event) {
        useCaseCreate.createDosingDevices(
                event.getData().getDosingDeviceAmount(),
                event.getData().getModuleId(),
                event.getData().getLineName(),
                event.getData().isFirst()
                );
    }
}
