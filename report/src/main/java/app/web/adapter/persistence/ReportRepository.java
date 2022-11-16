package app.web.adapter.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

interface ReportRepository extends JpaRepository<ReportEntity, Long> {
}
