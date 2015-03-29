package pti.jta.xa.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pti.jta.xa.fly.IFlyService;
import pti.jta.xa.hotel.IHotelService;

/**
 * Created by yevhen.tsyba on 29.03.2015.
 */
@Service
public class IntegrationService {

    @Autowired
    private IFlyService flyService;

    @Autowired
    private IHotelService hotelService;

    /*
        Notes how to connect several DataSources with txManager (two instances of PostgreSQL):
        http://www.coderanch.com/t/558790/Spring/Spring-JPA-Hibernate-multiple-Database
     */
}
