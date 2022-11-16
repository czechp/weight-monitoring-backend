package app.web.weightModule.adapter.persistence;

import app.web.utilities.tools.LoggerInfo;
import org.junit.jupiter.api.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile({"development", "test"})
class WeightModuleLastWarmup {
    private final Logger logger = LoggerFactory.getLogger(WeightModuleLastWarmup.class);
    private final WeightModuleLastRepository repository;

    @Autowired
    public WeightModuleLastWarmup(WeightModuleLastRepository repository) {
        this.repository = repository;
    }

    @EventListener(ApplicationReadyEvent.class)
    @Order(3)
    void init() {
        LoggerInfo.showInfo(logger, "Warmup for WeightModuleLast entity");

        List.of(
                        new WeightModuleLastEntity(
                                0L,
                                0L,
                                new ProductionLineSimpleEntity(1L, ""),
                                17f,
                                15f,
                                11,
                                16.4f,
                                true,
                                200.0f,
                                300_000l,
                                78.0f,
                                100_000L,
                                -200.3f,
                                60.0f,
                                100_000L,
                                75_000,
                                33.4f
                        )
                )
                .forEach(repository::save);
    }
}
