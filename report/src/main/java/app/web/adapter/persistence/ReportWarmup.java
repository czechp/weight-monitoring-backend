package app.web.adapter.persistence;

import app.web.domain.WorkShift;
import app.web.utilities.tools.LoggerInfo;
import org.junit.jupiter.api.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
@Profile({"test", "development"})
class ReportWarmup {
    private final Logger logger = LoggerFactory.getLogger(ReportWarmup.class);
    private final ReportRepository repository;

    public ReportWarmup(ReportRepository repository) {
        this.repository = repository;
    }

    @EventListener(ApplicationReadyEvent.class)
    @Order(5)
    void init() {
        LoggerInfo.showInfo(logger, "Warmup for Report entity");


        IntStream.range(1, 4)
                .boxed()
                .map(n -> new ReportEntity(0, 0, "L-01", LocalDate.now().minusDays(n), WorkShift.I, n * 1, n * 2, n * 3, n * 4, n * 5, n * 6, n * 7))
                .forEach(n -> {
                    List<ReportDosingDeviceFirstEntity> firstDosingDevices = IntStream.range(1, 21)
                            .boxed()
                            .map(a -> new ReportDosingDeviceFirstEntity(0, 0, a, a * 10, a * 11, a * 12))
                            .collect(Collectors.toList());

                    List<ReportDosingDeviceLastEntity> lastDosingDevices = IntStream.range(1, 21)
                            .boxed()
                            .map(b -> new ReportDosingDeviceLastEntity(0, 0, b, b * 10, b * 11, b * 12))
                            .collect(Collectors.toList());
                    firstDosingDevices.forEach(n::addFirstDosingDevice);
                    lastDosingDevices.forEach(n::addLastDosingDevice);
                    repository.save(n);
                });

    }
}
