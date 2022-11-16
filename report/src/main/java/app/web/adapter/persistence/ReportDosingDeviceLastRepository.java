package app.web.adapter.persistence;

import io.micrometer.core.instrument.Tags;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface ReportDosingDeviceLastRepository extends JpaRepository<ReportDosingDeviceLastEntity, Long> {
    List<ReportDosingDeviceLastEntity> findByReport_Id(long reportId, Pageable pageable);
}
