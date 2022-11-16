package app.web.adapter.persistence;

import app.web.application.dto.DosingDeviceQueryDto;
import app.web.domain.DosingDevice;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface DosingDeviceLastRepository extends JpaRepository<DosingDeviceLastEntity, Long> {
    List<DosingDeviceLastEntity> findByLastModuleEntity_Id(long moduleId, Pageable pageable);


    List<DosingDeviceLastEntity> findByLineName(String lineName);
}
