package app.web.weightModule.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

public class WeightModuleCreateEvent extends ApplicationEvent {

    @Getter
    private final WeightModuleCreateData data;

    public WeightModuleCreateEvent(Object source, WeightModuleCreateData data) {
        super(source);
        this.data = data;
    }
}
