package app.web.adapter.persistence;

import app.web.application.dto.DosingDeviceQueryDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface DosingDeviceFirstRepository extends JpaRepository<DosingDeviceFirstEntity, Long> {
    List<DosingDeviceFirstEntity> findByFirstModuleEntity_Id(long moduleId, Pageable pageable);

    List<DosingDeviceFirstEntity> findByLineName(String lineName);
}
