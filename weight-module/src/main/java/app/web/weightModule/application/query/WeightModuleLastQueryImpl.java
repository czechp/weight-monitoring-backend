package app.web.weightModule.application.query;

import app.web.weightModule.application.dto.WeightModuleLastQueryDto;
import app.web.weightModule.application.port.query.WeightModuleLastPortFindAll;
import app.web.weightModule.application.port.query.WeightModuleLastPortFindByIdOrThrow;
import app.web.weightModule.application.port.query.WeightModuleLastPortFindByProductionLineId;
import app.web.weightModule.domain.WeightModuleLastFactory;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
class WeightModuleLastQueryImpl implements WeightModuleLastQuery {
    private final WeightModuleLastPortFindAll portFindAll;
    private final WeightModuleLastPortFindByIdOrThrow portFindByIdOrThrow;
    private final WeightModuleLastPortFindByProductionLineId portFindByProductionLineId;
    @Override
    public List<WeightModuleLastQueryDto> findAllWeightModuleLast(Pageable pageable) {
        return portFindAll.findAllWeightModuleLast(pageable)
                .stream()
                .map(WeightModuleLastFactory::toQueryDto)
                .collect(Collectors.toList());
    }

    @Override
    public WeightModuleLastQueryDto findByWeightModuleLastByIdOrThrow(long id) {
        return WeightModuleLastFactory.toQueryDto(portFindByIdOrThrow.findByIdOrThrowException(id));
    }

    @Override
    public List<WeightModuleLastQueryDto> findByProductionLineId(long id) {
        return  portFindByProductionLineId.findByProductionLineId(id)
                .stream()
                .map(WeightModuleLastFactory::toQueryDto)
                .collect(Collectors.toList());
    }
}
