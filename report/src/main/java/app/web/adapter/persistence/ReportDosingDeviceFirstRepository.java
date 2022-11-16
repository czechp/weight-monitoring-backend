package app.web.adapter.persistence;

import io.micrometer.core.instrument.binder.db.MetricsDSLContext;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface ReportDosingDeviceFirstRepository extends JpaRepository<ReportDosingDeviceFirstEntity, Long> {
    List<ReportDosingDeviceFirstEntity> findByReport_Id(long reportId, Pageable pageable);

}
