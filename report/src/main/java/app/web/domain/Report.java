package app.web.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Report extends ReportSuper{
     Report(long id,
                  long version,
                  LocalDateTime creationDate,
                  String lineName,
                  LocalDate reportDate,
                  WorkShift workShift,
                  ReportSummaryData reportSummaryData,
                  List<ReportDosingDeviceData> dosingDeviceFirstModule,
                  List<ReportDosingDeviceData> dosingDeviceLastModule) {
        super(id, version, creationDate, lineName, reportDate, workShift, reportSummaryData, dosingDeviceFirstModule, dosingDeviceLastModule);
    }

     Report(String lineName,
                  WorkShift workShift,
                  ReportSummaryData reportSummaryData,
                  List<ReportDosingDeviceData> dosingDeviceFirstModule,
                  List<ReportDosingDeviceData> dosingDeviceLastModule) {
        super(lineName, workShift, reportSummaryData, dosingDeviceFirstModule, dosingDeviceLastModule);
    }
}
