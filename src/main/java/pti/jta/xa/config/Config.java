package pti.jta.xa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pti.jta.xa.services.impl.FlyService;
import pti.jta.xa.services.IFlyService;
import pti.jta.xa.services.impl.HotelService;
import pti.jta.xa.services.IHotelService;
import pti.jta.xa.services.impl.TransactionService;

/**
 * Created by yevhen.tsyba on 05.04.2015.
 */
@Configuration
@ComponentScan
public class Config {
    @Bean
    public IFlyService flyService(){
        return new FlyService();
    }

    @Bean
    public IHotelService hotelService(){
        return new HotelService();
    }

    @Bean
    public TransactionService transactionService(){
        return new TransactionService();
    }
}
