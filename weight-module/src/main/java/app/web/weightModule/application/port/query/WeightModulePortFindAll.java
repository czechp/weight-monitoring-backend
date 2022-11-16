package app.web.weightModule.application.port.query;

import app.web.weightModule.domain.WeightModule;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface WeightModulePortFindAll {
    List<WeightModule> findAllWeightModule(Pageable pageable);
}
