package app.web.application.dto;

import app.web.adapter.persistence.DosingDeviceFirstEntity;
import app.web.adapter.persistence.DosingDeviceLastEntity;
import app.web.domain.ModuleType;

public class DosingDeviceDtoFactory {
    public static DosingDeviceQueryDto toQueryDto(DosingDeviceFirstEntity entity){
        return  new DosingDeviceQueryDto(
                entity.getId(),
                new DosingDeviceQueryDto.ModuleInfoDto(entity.getFirstModuleEntity().getId(), entity.getLineName()),
                ModuleType.FIRST,
                entity.getRecordNumber(),
                entity.getTotalMaterial(),
                new DosingDeviceQueryDto.MeasuresDto(
                        entity.getCorrectMeasurePercent(),
                        entity.getLastMeasure(),
                        entity.getAmountBelowMeasures(),
                        entity.getAmountCorrectMeasures(),
                        entity.getAmountAboveMeasures(),
                        entity.getAverageMeasure()
                )
        );
    }
    public static DosingDeviceQueryDto toQueryDto(DosingDeviceLastEntity entity){
        return  new DosingDeviceQueryDto(
                entity.getId(),
                new DosingDeviceQueryDto.ModuleInfoDto(entity.getLastModuleEntity().getId(), entity.getLineName()),
                ModuleType.LAST,
                entity.getRecordNumber(),
                entity.getTotalMaterial(),
                new DosingDeviceQueryDto.MeasuresDto(
                        entity.getCorrectMeasurePercent(),
                        entity.getLastMeasure(),
                        entity.getAmountBelowMeasures(),
                        entity.getAmountCorrectMeasures(),
                        entity.getAmountAboveMeasures(),
                        entity.getAverageMeasure()
                )
        );
    }
}
