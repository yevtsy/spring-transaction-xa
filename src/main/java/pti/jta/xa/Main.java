package pti.jta.xa;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pti.jta.xa.services.TransactionServiceIntf;
import pti.jta.xa.dao.fly.FlyOrder;
import pti.jta.xa.dao.hotel.HotelOrder;

import java.time.Instant;
import java.time.Period;
import java.util.Date;

/**
 * Created by yevhen.tsyba on 04.04.2015.
 */
public class Main {

    public static void main(String[] args) throws ClassNotFoundException {

        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[]{"spring.xml"});

        TransactionServiceIntf transactionService = (TransactionServiceIntf) context.getBean("transactionService");
        try {
            transactionService.persist(getCorrectHotelOrder(), getCorrectFlyOrder());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static FlyOrder getCommonFlyOrder() {
        FlyOrder flyOrder = new FlyOrder();
        flyOrder.setClientName("Nik");
        flyOrder.setFlyNumber("KLM 1382");
        flyOrder.setLeave("KBP");
        flyOrder.setArrive("AMS");

        return flyOrder;
    }

    static FlyOrder getCorrectFlyOrder() {
        FlyOrder flyOrder = getCommonFlyOrder();
        flyOrder.setDate(Date.from(Instant.now().plus(Period.ofDays(3))));

        return flyOrder;
    }

    static HotelOrder getCommonHotelOrder() {
        HotelOrder hotelOrder = new HotelOrder();
        hotelOrder.setClintName("Nik");
        hotelOrder.setHotelName("Hilton");
        hotelOrder.setArrival(Date.from(Instant.now()));

        return hotelOrder;
    }

    static HotelOrder getCorrectHotelOrder() {
        HotelOrder hotelOrder = getCommonHotelOrder();
        hotelOrder.setDeparture(Date.from(Instant.now().plus(Period.ofDays(3))));

        return hotelOrder;
    }
}
