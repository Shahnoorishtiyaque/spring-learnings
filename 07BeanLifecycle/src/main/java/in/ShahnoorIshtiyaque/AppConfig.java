package in.ShahnoorIshtiyaque;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan("in.ShahnoorIshtiyaque")
public class AppConfig {

//    @Bean(initMethod = "start" , destroyMethod ="stop")
//    public CardService getCardBean(){
//        return new CardService();
//    }
}
