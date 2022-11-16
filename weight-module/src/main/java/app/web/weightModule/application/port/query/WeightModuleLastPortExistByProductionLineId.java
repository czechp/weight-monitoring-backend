package app.web.weightModule.application.port.query;

public interface WeightModuleLastPortExistByProductionLineId {
    boolean existsByProductionLineId(long productionLineId);
}
