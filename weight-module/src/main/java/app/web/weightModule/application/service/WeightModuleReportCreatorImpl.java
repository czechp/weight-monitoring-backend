package app.web.weightModule.application.service;

import app.web.weightModule.application.port.crud.WeightModuleLastPortSave;
import app.web.weightModule.application.port.crud.WeightModulePortSave;
import app.web.weightModule.application.port.event.WeightModulePortEvent;
import app.web.weightModule.application.port.query.WeightModuleLastPortFindByProductionLineId;
import app.web.weightModule.application.port.query.WeightModulePortFindByProductionLineId;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
class WeightModuleReportCreatorImpl implements WeightModuleReportCreator {
    private final WeightModulePortFindByProductionLineId portFindByProductionLineId;
    private final WeightModuleLastPortFindByProductionLineId portFindLastByProductionLineId;
    private final WeightModulePortEvent portEvent;
    private final WeightModulePortSave portSave;
    private final WeightModuleLastPortSave portLastSave;

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRES_NEW)
    public void createReportForLine(long lineId) {
        portEvent.notifyAboutCreatingReportForLine(lineId);
        clearModuleProductData(lineId);
    }

    public void clearModuleProductData(long lineId) {
        portFindByProductionLineId.findByProductionLineIdWeightModules(lineId)
                .forEach(el -> {
                    el.clearProductInfo();
                    portSave.saveWeightModule(el);
                });

        portFindLastByProductionLineId.findByProductionLineId(lineId)
                .forEach(el -> {
                    el.clearProductInfo();
                    portLastSave.save(el);
                });
    }

}
