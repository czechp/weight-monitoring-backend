package app.web.productionLine.domain;

import app.web.productionLine.adapter.persistence.ProductionLineEntity;
import app.web.productionLine.application.dto.ProductionLineQueryDto;
import app.web.productionLine.application.dto.ReportLineDto;
import app.web.productionLine.dto.ProductionLineFacadeDto;
import app.web.report.dto.ReportLine;

public class ProductionLineFactory {
    public static ProductionLine create(String lineName) {
        return new ProductionLine(lineName);
    }

    public static ProductionLineEntity toEntity(ProductionLine productionLine) {
        return new ProductionLineEntity(
                productionLine.getId(),
                productionLine.getVersion(),
                productionLine.getLineName(),
                productionLine.getCreationTimestamp()
        );
    }

    public static ProductionLine toDomain(ProductionLineEntity productionLineEntity) {
        return new ProductionLine(productionLineEntity.getId(),
                productionLineEntity.getVersion(),
                productionLineEntity.getLineName(),
                productionLineEntity.getCreationTimestamp());
    }

    public static ProductionLineQueryDto toDto(ProductionLineEntity productionLineEntity) {
        return new ProductionLineQueryDto(productionLineEntity.getId(),
                productionLineEntity.getLineName(),
                productionLineEntity.getCreationTimestamp());

    }

    static public ProductionLineFacadeDto toFacadeDto(ProductionLine productionLine) {
        return new ProductionLineFacadeDto(productionLine.getId(), productionLine.getLineName());
    }

    public static  ReportLine toReportDto(ProductionLine productionLine) {
        return new ReportLineDto(productionLine.getId(), productionLine.getLineName());
    }
}
