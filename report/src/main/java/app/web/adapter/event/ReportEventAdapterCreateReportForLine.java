package app.web.adapter.event;

import app.web.application.useCase.ReportUseCaseCreate;
import app.web.report.event.CreateReportForLineEvent;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
class ReportEventAdapterCreateReportForLine implements ApplicationListener<CreateReportForLineEvent> {
    private final ReportUseCaseCreate useCaseCreate;
    @Override
    public void onApplicationEvent(CreateReportForLineEvent event) {
        useCaseCreate.createForSingleLine(event.getLineId());
    }
}
