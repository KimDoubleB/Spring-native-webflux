package bb.aws.lambda.webfluxnativedemo.config;

import bb.aws.lambda.webfluxnativedemo.service.PrintService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfiguration {

    @Bean
    public PrintService printService() {
        return new PrintService();
    }

}
