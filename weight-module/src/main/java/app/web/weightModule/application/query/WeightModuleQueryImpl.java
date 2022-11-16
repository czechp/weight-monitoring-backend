package app.web.weightModule.application.query;

import app.web.weightModule.application.dto.WeightModuleQueryDto;
import app.web.weightModule.application.port.query.WeightModulePortFindAll;
import app.web.weightModule.application.port.query.WeightModulePortFindById;
import app.web.weightModule.application.port.query.WeightModulePortFindByProductionLineId;
import app.web.weightModule.domain.WeightModuleFactory;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
class WeightModuleQueryImpl implements WeightModuleQuery {
    private final WeightModulePortFindAll portFindAll;
    private final WeightModulePortFindById portFindById;
    private final WeightModulePortFindByProductionLineId portFindByProductionLineId;

    @Override
    public List<WeightModuleQueryDto> findAllWeightModule(Pageable pageable) {
        return portFindAll.findAllWeightModule(pageable)
                .stream()
                .map(WeightModuleFactory::toWeightModuleQueryDto)
                .collect(Collectors.toList());
    }

    @Override
    public WeightModuleQueryDto findByIdWeightModule(long id) {
        return WeightModuleFactory.toWeightModuleQueryDto(portFindById.findByIdWeightModuleOrThrowException(id));
    }

    @Override
    public List<WeightModuleQueryDto> findByProductionLineIdWeightModules(long id) {
        return portFindByProductionLineId.findByProductionLineIdWeightModules(id)
                .stream()
                .map(WeightModuleFactory::toWeightModuleQueryDto)
                .collect(Collectors.toList());
    }
}
