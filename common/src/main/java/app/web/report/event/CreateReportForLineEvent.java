package app.web.report.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class CreateReportForLineEvent extends ApplicationEvent {

    private long lineId;

    public CreateReportForLineEvent(Object source, long lineId) {
        super(source);
        this.lineId = lineId;
    }
}
