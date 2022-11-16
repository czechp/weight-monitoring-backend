package app.web.domain;

import app.web.adapter.persistence.DosingDeviceFirstEntity;
import app.web.adapter.persistence.DosingDeviceLastEntity;
import app.web.adapter.persistence.FirstModuleEntity;
import app.web.adapter.persistence.LastModuleEntity;
import app.web.application.dto.ReportDosingDeviceDto;
import app.web.report.dto.ReportDosingDevice;

public class DosingDeviceFactory {
    public static DosingDevice toDomain(DosingDeviceFirstEntity entity) {
        return new DosingDeviceFirst(
                entity.getId(),
                entity.getVersion(),
                new ModuleInfo(entity.getFirstModuleEntity().getId(), entity.getLineName()),
                entity.getRecordNumber(),
                entity.getTotalMaterial(),
                new Measures(
                        entity.getLastMeasure(),
                        entity.getAmountBelowMeasures(),
                        entity.getAmountCorrectMeasures(),
                        entity.getAmountAboveMeasures(),
                        entity.getAverageMeasure(),
                        entity.getCorrectMeasurePercent()
                )
        );
    }

    public static DosingDevice toDomain(DosingDeviceLastEntity entity) {
        return new DosingDeviceLast(
                entity.getId(),
                entity.getVersion(),
                new ModuleInfo(entity.getLastModuleEntity().getId(), entity.getLineName()),
                entity.getRecordNumber(),
                entity.getTotalMaterial(),
                new Measures(
                        entity.getLastMeasure(),
                        entity.getAmountBelowMeasures(),
                        entity.getAmountCorrectMeasures(),
                        entity.getAmountAboveMeasures(),
                        entity.getAverageMeasure(),
                        entity.getCorrectMeasurePercent()
                )
        );
    }

    public static DosingDeviceFirstEntity toEntity(DosingDeviceFirst domain) {
        return toDosingDeviceFirstEntity(domain);
    }

    public static DosingDeviceLastEntity toEntity(DosingDeviceLast domain) {
        return toDosingDeviceLastEntity(domain);
    }

    public static DosingDevice createDosingDevice(long moduleId, String lineName, int recordNr, boolean first) {
        ModuleInfo moduleInfo = new ModuleInfo(moduleId, lineName);
        return first ? new DosingDeviceFirst(moduleInfo, recordNr) : new DosingDeviceLast(moduleInfo, recordNr);
    }

    private static DosingDeviceFirstEntity toDosingDeviceFirstEntity(DosingDevice domain) {
        return new DosingDeviceFirstEntity(
                domain.getId(),
                domain.getVersion(),
                domain.getModuleInfo().getLineName(),
                domain.getRecordNumber(),
                domain.getTotalMaterial(),
                domain.getMeasures().getLastMeasure(),
                domain.getMeasures().getAmountBelowMeasures(),
                domain.getMeasures().getAmountCorrectMeasures(),
                domain.getMeasures().getAmountAboveMeasures(),
                domain.getMeasures().getAverageMeasure(),
                domain.getMeasures().getCorrectMeasurePercent(),
                new FirstModuleEntity(domain.getModuleInfo().getModuleId())
        );
    }

    private static DosingDeviceLastEntity toDosingDeviceLastEntity(DosingDevice domain) {
        return new DosingDeviceLastEntity(
                domain.getId(),
                domain.getVersion(),
                domain.getModuleInfo().getLineName(),
                domain.getRecordNumber(),
                domain.getTotalMaterial(),
                domain.getMeasures().getLastMeasure(),
                domain.getMeasures().getAmountBelowMeasures(),
                domain.getMeasures().getAmountCorrectMeasures(),
                domain.getMeasures().getAmountAboveMeasures(),
                domain.getMeasures().getAverageMeasure(),
                domain.getMeasures().getCorrectMeasurePercent(),
                new LastModuleEntity(domain.getModuleInfo().getModuleId())
        );
    }


    public static ReportDosingDevice toReportDto(DosingDevice dosingDevice) {
        return new ReportDosingDeviceDto(
                dosingDevice.getRecordNumber(),
                dosingDevice.getTotalMaterial(),
                dosingDevice.getMeasures().getCorrectMeasurePercent(),
                dosingDevice.getMeasures().getAverageMeasure()
        );
    }
}
