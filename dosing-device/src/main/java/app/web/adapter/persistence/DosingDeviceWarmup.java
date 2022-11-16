package app.web.adapter.persistence;

import app.web.utilities.tools.LoggerInfo;
import org.junit.jupiter.api.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
@Profile({"development", "test"})
class DosingDeviceWarmup {
    private final Logger logger = LoggerFactory.getLogger(DosingDeviceWarmup.class);
    private final DosingDeviceFirstRepository firstRepository;
    private final DosingDeviceLastRepository lastRepository;

    DosingDeviceWarmup(DosingDeviceFirstRepository firstRepository, DosingDeviceLastRepository lastRepository) {
        this.firstRepository = firstRepository;
        this.lastRepository = lastRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    @Order(4)
    @Transactional
    public void init() {
        LoggerInfo.showInfo(logger, "Warmup for Dosing device first entity");
        createDosingDeviceFirst()
                .forEach(firstRepository::save);


        LoggerInfo.showInfo(logger, "Warmup for Dosing device last entity");
        createDosingDeviceLast()
                .forEach(lastRepository::save);

    }

    List<DosingDeviceFirstEntity> createDosingDeviceFirst() {
        return IntStream.range(0, 10)
                .boxed()
                .map(n -> n + 1)
                .map(n -> new DosingDeviceFirstEntity(
                        0L,
                        0L,
                        "L-01",
                        n,
                        n * 10,
                        n * 1,
                        n * 2,
                        n * 3,
                        n * 5,
                        n * 6,
                        n * 7,
                        new FirstModuleEntity(1L)
                ))
                .collect(Collectors.toList());
    }

    List<DosingDeviceLastEntity> createDosingDeviceLast() {
        return IntStream.range(0, 10)
                .boxed()
                .map(n -> n + 1)
                .map(n -> new DosingDeviceLastEntity(
                        0L,
                        0L,
                        "L-01",
                        n,
                        n * 10,
                        n * 1,
                        n * 2,
                        n * 3,
                        n * 5,
                        n * 6,
                        n * 7,
                        new LastModuleEntity(1L)
                ))
                .collect(Collectors.toList());
    }
}
