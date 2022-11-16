package app.web.weightModule.adapter.persistence;

import app.web.utilities.tools.LoggerInfo;
import org.junit.jupiter.api.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile({"development", "test"})
class WeightModuleWarmup {
    private final WeightModuleJpaRepository weightModuleJpaRepository;
    private final Logger logger;

    public WeightModuleWarmup(WeightModuleJpaRepository weightModuleJpaRepository) {
        this.weightModuleJpaRepository = weightModuleJpaRepository;
        this.logger = LoggerFactory.getLogger(WeightModuleWarmup.class);
    }

    @EventListener(ApplicationReadyEvent.class)
    @Order(3)
    void init() {
        LoggerInfo.showInfo(logger, "Warmup for WeightModule entity");
        final var weightModules = List.of(
                new WeightModuleEntity(0L,
                        0L,
                        new ProductionLineSimpleEntity(1L, ""),
                        13f,
                        11f,
                        7,
                        12.3f,
                        true,
                        100.0f,
                        123_000,
                        75.0f
                ),
                new WeightModuleEntity(0L,
                        0L,
                        new ProductionLineSimpleEntity(2L, ""),
                        15f,
                        13f,
                        12,
                        14.3f,
                        false,
                        112.0f,
                        321_000,
                        50.0f
                )
        );

        weightModules.forEach(weightModuleJpaRepository::save);
    }
}
