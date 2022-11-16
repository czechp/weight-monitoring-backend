package app.web.weightModule.adapter.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface WeightModuleJpaRepository extends JpaRepository<WeightModuleEntity, Long> {
    List<WeightModuleEntity> findByProductionLineSimpleEntity_Id(long id);
}
