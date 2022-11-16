package app.web.weightModule.application.query;

import app.web.weightModule.application.dto.WeightModuleLastQueryDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface WeightModuleLastQuery {
    List<WeightModuleLastQueryDto> findAllWeightModuleLast(Pageable pageable);
    WeightModuleLastQueryDto findByWeightModuleLastByIdOrThrow(long id);
    List<WeightModuleLastQueryDto> findByProductionLineId(long id);
}
