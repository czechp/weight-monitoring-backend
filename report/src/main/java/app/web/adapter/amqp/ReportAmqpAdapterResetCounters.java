package app.web.adapter.amqp;

import app.web.application.port.ReportPortResetCounters;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
class ReportAmqpAdapterResetCounters implements ReportPortResetCounters {
    private final RabbitTemplate rabbitTemplate;


    private final Logger logger = LoggerFactory.getLogger(ReportAmqpAdapterResetCounters.class);
    @Value("${rabbitmq.weight.monitoring.exchange}")
    private String RESET_COUNTERS_EXCHANGE;

    ReportAmqpAdapterResetCounters(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void resetAllLinesCounters(List<Long> lineIds) {
        final var message = new ResetMessage(lineIds);
        rabbitTemplate.convertAndSend(RESET_COUNTERS_EXCHANGE, "", message);
        logger.info("----------------------Msg sent to {} order to reset PLC counters----------------------", RESET_COUNTERS_EXCHANGE);
    }

    @Data
    private class ResetMessage {
        private LocalDateTime date = LocalDateTime.now();
        private List<Long> lineIds = new ArrayList<>();

        public ResetMessage(List<Long> lineIds) {
            this.lineIds = lineIds;
        }
    }
}
