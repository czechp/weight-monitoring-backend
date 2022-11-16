package app.web.domain;

import app.web.adapter.persistence.ReportDosingDeviceFirstEntity;
import app.web.adapter.persistence.ReportDosingDeviceLastEntity;
import app.web.adapter.persistence.ReportDosingDeviceSuper;
import app.web.adapter.persistence.ReportEntity;
import app.web.application.dto.ReportDosingDeviceQueryDto;
import app.web.application.dto.ReportQueryDto;
import app.web.report.dto.ReportDosingDevice;
import app.web.report.dto.ReportSummary;

import java.util.List;
import java.util.stream.Collectors;

public class ReportFactory {
    public static Report create(
            String lineName,
            WorkShift workShift,
            ReportSummary reportSummary,
            List<ReportDosingDevice> firstDosingDevices,
            List<ReportDosingDevice> lastDosingDevices
    ) {
        ReportSummaryData reportSummaryData = createReportSummary(reportSummary);
        List<ReportDosingDeviceData> firstDosingDevicesData = createDosingDevices(firstDosingDevices);
        List<ReportDosingDeviceData> lastDosingDevicesData = createDosingDevices(lastDosingDevices);
        return new Report(
                lineName,
                workShift,
                reportSummaryData,
                firstDosingDevicesData,
                lastDosingDevicesData
        );
    }

    public static Report create(ReportEntity entity){
        return new Report(
                entity.getId(),
                entity.getVersion(),
                entity.getLineName(),
                entity.getReportDate(),
                entity.getWorkShift(),
                createReportSummary(entity),
                entity.getFirstDosingDevices().stream().map(ReportFactory::toReportDosingDevice).collect(Collectors.toList()),
                entity.getLastDosingDevices().stream().map(ReportFactory::toReportDosingDevice).collect(Collectors.toList())
        );
    }

    public static ReportQueryDto toSimpleDto(ReportEntity entity) {
        return new ReportQueryDto(
                entity.getId(),
                entity.getReportDate(),
                entity.getLineName(),
                entity.getWorkShift(),
                entity.getTotalProductPcs(),
                entity.getTotalMaterialWeight(),
                entity.getWeightDifference(),
                entity.getCorrectProductPercent(),
                entity.getIncorrectProductPcs(),
                entity.getOverFilledProductPcs(),
                entity.getNotRefilledProductPcs()
        );
    }

    public static ReportQueryDto toDto(ReportEntity entity) {

        return new ReportQueryDto(entity.getId(),
                entity.getReportDate(),
                entity.getLineName(),
                entity.getWorkShift(),
                entity.getTotalProductPcs(),
                entity.getTotalMaterialWeight(),
                entity.getWeightDifference(),
                entity.getCorrectProductPercent(),
                entity.getIncorrectProductPcs(),
                entity.getOverFilledProductPcs(),
                entity.getNotRefilledProductPcs()
        );
    }

    public static List<ReportDosingDeviceData> createDosingDevices(List<? extends ReportDosingDevice> reportDosingDevices) {
        return reportDosingDevices
                .stream()
                .map(n -> new ReportDosingDeviceData(n.getRecordNumber(), n.getTotalMaterial(), n.getCorrectPercent(), n.getAverageMeasure()))
                .collect(Collectors.toList());
    }

    public static ReportDosingDeviceQueryDto toDto(ReportDosingDeviceSuper entity) {
        return new ReportDosingDeviceQueryDto(entity.getId(),
                entity.getRecordNumber(),
                entity.getTotalMaterialWeight(),
                entity.getCorrectPercent(),
                entity.getAverageWeight());
    }

    private static ReportSummaryData createReportSummary(ReportSummary reportSummary) {
        return new ReportSummaryData(
                reportSummary.getTotalProductPcs(),
                reportSummary.getTotalMaterialWeight(),
                reportSummary.getWeightDifference(),
                reportSummary.getCorrectProductPercent(),
                reportSummary.getIncorrectProductPcs(),
                reportSummary.getOverFilledProductPcs(),
                reportSummary.getNotFulFilledProductPcs()
        );
    }

    private static ReportSummaryData createReportSummary(ReportEntity entity){
        return  new ReportSummaryData(
                entity.getTotalProductPcs(),
                entity.getTotalMaterialWeight(),
                entity.getWeightDifference(),
                entity.getCorrectProductPercent(),
                entity.getIncorrectProductPcs(),
                entity.getOverFilledProductPcs(),
                entity.getNotRefilledProductPcs()
        );
    }

    public static ReportEntity toEntity(Report report) {
        List<ReportDosingDeviceFirstEntity> firstDevices = report.getDosingDeviceFirstModule().stream()
                .map(ReportFactory::toFirstDosingDevicesEntity)
                .collect(Collectors.toList());

        List<ReportDosingDeviceLastEntity> lastDevices = report.getDosingDeviceLastModule().stream()
                .map(ReportFactory::toLastDosingDevicesEntity)
                .collect(Collectors.toList());


        return new ReportEntity(
                report.getId(),
                report.getVersion(),
                report.getLineName(),
                report.getReportDate(),
                report.getWorkShift(),
                report.getReportSummaryData().getTotalProductPcs(),
                report.getReportSummaryData().getTotalMaterialWeight(),
                report.getReportSummaryData().getWeightDifference(),
                report.getReportSummaryData().getCorrectProductPercent(),
                report.getReportSummaryData().getIncorrectProductPcs(),
                report.getReportSummaryData().getOverFilledProductPcs(),
                report.getReportSummaryData().getNotRefilledProductPcs(),
                firstDevices,
                lastDevices);
    }

    private static ReportDosingDeviceFirstEntity toFirstDosingDevicesEntity(ReportDosingDeviceData data) {
        return new ReportDosingDeviceFirstEntity(
                data.getId(),
                data.getVersion(),
                data.getRecordNumber(),
                data.getTotalMaterialWeight(),
                data.getCorrectPercent(),
                data.getAverageWeight()
        );
    }

    private static ReportDosingDeviceLastEntity toLastDosingDevicesEntity(ReportDosingDeviceData data) {
        return new ReportDosingDeviceLastEntity(
                data.getId(),
                data.getVersion(),
                data.getRecordNumber(),
                data.getTotalMaterialWeight(),
                data.getCorrectPercent(),
                data.getAverageWeight()
        );
    }

    private static ReportDosingDeviceData toReportDosingDevice(ReportDosingDeviceSuper entity){
        return new ReportDosingDeviceData(
                entity.getId(),
                entity.getVersion(),
                entity.getRecordNumber(),
                entity.getTotalMaterialWeight(),
                entity.getCorrectPercent(),
                entity.getAverageWeight()
        );
    }
}
