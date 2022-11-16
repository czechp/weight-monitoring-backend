package app.web.weightModule.adapter.event;

import app.web.dosingDevice.dto.DosingDeviceUpdateData;
import app.web.dosingDevice.dto.DosingDeviceUpdateEvent;
import app.web.report.event.CreateReportForLineEvent;
import app.web.weightModule.application.port.event.WeightModulePortEvent;
import app.web.weightModule.domain.WeightModule;
import app.web.weightModule.domain.WeightModuleAbstract;
import app.web.weightModule.event.WeightModuleCreateData;
import app.web.weightModule.event.WeightModuleCreateEvent;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
class WeightModuleEventAdapterPublisher implements WeightModulePortEvent {
    private final ApplicationEventPublisher publisher;

    @Override
    public void notifyAboutModuleCreating(WeightModuleAbstract module, int dosingDeviceAmount) {
        WeightModuleCreateEvent event = new WeightModuleCreateEvent(this, new EventData(module, dosingDeviceAmount));
        publisher.publishEvent(event);
    }

    @Override
    public void notifyAboutUpdateDosingDevice(long moduleId, List<? extends DosingDeviceUpdateData> dosingDeviceUpdateData, boolean isFirst) {
        DosingDeviceUpdateEvent event = new DosingDeviceUpdateEvent(this, moduleId, dosingDeviceUpdateData, isFirst);
        publisher.publishEvent(event);
    }

    @Override
    public void notifyAboutCreatingReportForLine(long lineId) {
        CreateReportForLineEvent event = new CreateReportForLineEvent(this, lineId);
        publisher.publishEvent(event);
    }

    @AllArgsConstructor
    public class EventData implements WeightModuleCreateData{
        private final WeightModuleAbstract module;
        private final int dosingDeviceAmount;

        @Override
        public long getModuleId() {
            return module.getId();
        }

        @Override
        public String getLineName() {
            return module.getProductionLineName();
        }

        @Override
        public boolean isFirst() {
            return module instanceof WeightModule;
        }

        @Override
        public int getDosingDeviceAmount() {
            return dosingDeviceAmount;
        }
    }
}
