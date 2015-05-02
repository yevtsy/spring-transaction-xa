package pti.jta.xa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pti.jta.xa.services.FlyService;
import pti.jta.xa.services.HotelService;
import pti.jta.xa.services.impl.FlyServiceImpl;
import pti.jta.xa.services.impl.HotelServiceImpl;
import pti.jta.xa.services.impl.TransactionServiceImpl;

/**
 * Created by yevhen.tsyba on 05.04.2015.
 */
@Configuration
@ComponentScan(basePackages = "pti.jta.xa")
public class Config {
    @Bean
    public FlyService flyService() {
        return new FlyServiceImpl();
    }

    @Bean
    public HotelService hotelService() {
        return new HotelServiceImpl();
    }

    @Bean
    public TransactionServiceImpl transactionService() {
        return new TransactionServiceImpl();
    }
}
