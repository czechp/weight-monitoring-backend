package app.web.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class RabbitMqConfiguration {
    @Bean
    Jackson2JsonMessageConverter getMessageConverter(@Autowired ObjectMapper objectMapper){
        return  new Jackson2JsonMessageConverter(objectMapper);
    }
}
