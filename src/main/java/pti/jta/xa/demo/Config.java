package pti.jta.xa.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pti.jta.xa.fly.FlyService;
import pti.jta.xa.fly.IFlyService;
import pti.jta.xa.hotel.HotelService;
import pti.jta.xa.hotel.IHotelService;

/**
 * Created by yevhen.tsyba on 05.04.2015.
 */
@Configuration
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
    public TransactionServiceIntf transactionService(){
        return new TransactionService();
    }
}
