package app.web.productionLine.adapter.persistence;

import app.web.utilities.tools.LoggerInfo;
import org.junit.jupiter.api.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Profile({"development", "test", "integration-development"})
class ProductionLineWarmup {
    private final Logger logger;
    private final ProductionLineRepository productionLineRepository;

    public ProductionLineWarmup(ProductionLineRepository productionLineRepository) {
        this.productionLineRepository = productionLineRepository;
        this.logger = LoggerFactory.getLogger(ProductionLineWarmup.class);
    }

    @EventListener(ApplicationReadyEvent.class)
    @Order(2)
    void init() {
        LoggerInfo.showInfo(logger, "Warmup for Production line entity");
        List<ProductionLineEntity> lines = createLines();
        lines.forEach(productionLineRepository::save);
    }

    private List<ProductionLineEntity> createLines() {
        return List.of(
                ProductionLineEntity.builder().withLineName("L-01").withCreationTimestamp(LocalDateTime.now()).build(),
                ProductionLineEntity.builder().withLineName("L-02").withCreationTimestamp(LocalDateTime.now()).build(),
                ProductionLineEntity.builder().withLineName("L-03").withCreationTimestamp(LocalDateTime.now()).build()
        );
    }

}
