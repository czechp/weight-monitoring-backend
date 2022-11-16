package app.web.weightModule.adapter.persistence;

import app.web.weightModule.domain.WeightModuleLast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface WeightModuleLastRepository extends JpaRepository<WeightModuleLastEntity, Long> {
    List<WeightModuleLastEntity> findByProductionLineSimpleEntity_Id(long id);

    boolean existsByProductionLineSimpleEntity_Id(long productionLineId);
}
