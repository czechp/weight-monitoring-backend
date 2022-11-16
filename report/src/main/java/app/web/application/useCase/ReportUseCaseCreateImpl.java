package app.web.application.useCase;

import app.web.application.port.ReportPortCrud;
import app.web.application.port.ReportPortResetCounters;
import app.web.application.service.WorkShiftProvider;
import app.web.domain.Report;
import app.web.domain.ReportFactory;
import app.web.domain.WorkShift;
import app.web.exception.ConditionsNotFulFiledException;
import app.web.report.dto.ReportDosingDevice;
import app.web.report.dto.ReportLine;
import app.web.report.dto.ReportSummary;
import app.web.report.provider.ReportDosingDeviceFirstProvider;
import app.web.report.provider.ReportDosingDeviceLastProvider;
import app.web.report.provider.ReportLineProvider;
import app.web.report.provider.ReportSummaryProvider;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
class ReportUseCaseCreateImpl implements ReportUseCaseCreate {
    private final ReportLineProvider reportLineProvider;
    private final ReportSummaryProvider reportSummaryProvider;
    private final ReportDosingDeviceFirstProvider reportDosingDeviceFirstProvider;
    private final ReportDosingDeviceLastProvider reportDosingDeviceLastProvider;

    private final ReportPortResetCounters resetCounters;
    private final ReportPortCrud portCrud;

    @Override
    public List<Report> createForAllLines(WorkShift workShift) {
        List<Report> reports = reportLineProvider.findAllLines()
                .stream()
                .map((reportLine -> createSingleReport(reportLine, workShift)))
                .filter(Report::isNotEmpty)
                .map(portCrud::save)
                .collect(Collectors.toList());

        List<Long> lineIds = reportLineProvider.findAllLines().stream()
                .map(ReportLine::getLineId)
                .collect(Collectors.toList());

        resetCounters.resetAllLinesCounters(lineIds);
        return reports;
    }

    @Override
    public Report createForSingleLine(long lineId) {
        WorkShift workShift = WorkShiftProvider.forTime(LocalTime.now());
        Report report = reportLineProvider.findAllLines()
                .stream()
                .filter(reportLine -> reportLine.getLineId() == lineId)
                .map(reportLine -> createSingleReport(reportLine, workShift))
                .findAny()
                .orElseThrow(() -> new ConditionsNotFulFiledException("There is not line with id: " + lineId));

        if (report.isNotEmpty()) {
            portCrud.save(report);
            resetCounters.resetAllLinesCounters(List.of(lineId));
        }

        return report;
    }

    private Report createSingleReport(ReportLine reportLine, WorkShift workShift) {
        ReportSummary reportSummary = reportSummaryProvider.findByModuleId(reportLine.getLineId())
                .orElse(new EmptyReportSummary());
        List<ReportDosingDevice> firstDosingDevices
                = reportDosingDeviceFirstProvider.findByLineName(reportLine.getLineName());
        List<ReportDosingDevice> lastDosingDevices =
                reportDosingDeviceLastProvider.findByLineName(reportLine.getLineName());

        return ReportFactory.create(
                reportLine.getLineName(),
                workShift,
                reportSummary,
                firstDosingDevices,
                lastDosingDevices
        );
    }


    private class EmptyReportSummary implements ReportSummary {
        @Override
        public String getLineName() {
            return "";
        }

        @Override
        public long getTotalProductPcs() {
            return 0;
        }

        @Override
        public float getTotalMaterialWeight() {
            return 0;
        }

        @Override
        public float getWeightDifference() {
            return 0;
        }

        @Override
        public float getCorrectProductPercent() {
            return 0;
        }

        @Override
        public long getIncorrectProductPcs() {
            return 0;
        }

        @Override
        public long getOverFilledProductPcs() {
            return 0;
        }

        @Override
        public long getNotFulFilledProductPcs() {
            return 0;
        }
    }
}
