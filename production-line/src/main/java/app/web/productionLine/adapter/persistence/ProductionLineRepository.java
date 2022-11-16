package app.web.productionLine.adapter.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ProductionLineRepository extends JpaRepository<ProductionLineEntity, Long> {
    boolean existsByLineName(String lineName);
}
