package app.web.weightModule.application.query;

import app.web.weightModule.application.dto.WeightModuleQueryDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface WeightModuleQuery {
    List<WeightModuleQueryDto> findAllWeightModule(Pageable pageable);

    WeightModuleQueryDto findByIdWeightModule(long id);

    List<WeightModuleQueryDto> findByProductionLineIdWeightModules(long id);
}
