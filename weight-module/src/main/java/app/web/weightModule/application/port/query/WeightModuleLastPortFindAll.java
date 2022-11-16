package app.web.weightModule.application.port.query;

import app.web.weightModule.domain.WeightModuleLast;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface WeightModuleLastPortFindAll {
    List<WeightModuleLast> findAllWeightModuleLast(Pageable pageable);
}
