package app.web.adapter.scheduler;

import app.web.application.useCase.ReportUseCaseCreate;
import app.web.domain.WorkShift;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
class ReportSchedulerAdapterCreate {
    private final ReportUseCaseCreate reportUseCaseCreate;
    private final Logger logger = LoggerFactory.getLogger(ReportSchedulerAdapterCreate.class);

    public ReportSchedulerAdapterCreate(ReportUseCaseCreate reportUseCaseCreate) {
        this.reportUseCaseCreate = reportUseCaseCreate;
    }

    @Scheduled(cron = "0 58 6 * * *")
    @Transactional
    public void createReportForFirstWorkShift(){
        createReports(WorkShift.III);
    }

    @Scheduled(cron = "0 58 14 * * *")
    @Transactional
    public void createReportForSecondWorkShift(){
        createReports(WorkShift.I);
    }

    @Scheduled(cron = "0 58 22 * * *")
    @Transactional
    public void createReportForThirdWorkShift(){
        createReports(WorkShift.II);
    }

    public void createReports(WorkShift workShift){
        logger.info("----------------------------------------------------------------------------");
        logger.info("Create reports for: {} - work shift: {}", LocalDateTime.now().toString(), workShift);
        reportUseCaseCreate.createForAllLines(workShift);
        logger.info("----------------------------------------------------------------------------");
    }
}
