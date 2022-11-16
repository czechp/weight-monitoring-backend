package app.web.weightModule.application.useCase;

import app.web.weightModule.application.port.crud.WeightModuleLastPortRemove;
import app.web.weightModule.application.port.query.WeightModuleLastPortFindByIdOrThrow;
import app.web.weightModule.domain.WeightModuleLast;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
class WeightModuleLastUseCaseDeleteImpl implements WeightModuleLastUseCaseDelete {
    private final WeightModuleLastPortFindByIdOrThrow portFindByIdOrThrow;
    private final WeightModuleLastPortRemove portRemove;

    @Override
    @Transactional
    public WeightModuleLast removeById(long moduleId) {
        WeightModuleLast module = portFindByIdOrThrow.findByIdOrThrowException(moduleId);
        portRemove.remove(module);
        return module;
    }
}
