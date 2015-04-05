package pti.jta.xa.demo;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import pti.jta.xa.fly.FlyOrder;
import pti.jta.xa.hotel.HotelOrder;

import java.time.Instant;
import java.time.Period;
import java.util.Date;

@ContextConfiguration("classpath:spring.xml")
public class RunTests extends AbstractTestNGSpringContextTests {

    @Autowired
    private TransactionServiceIntf transactionService;

    @Test
    public void testSuccessOrder() throws Exception {
        System.out.println("******** Valid transaction ***********");
        transactionService.persist(getCorrectHotelOrder(), getCorrectFlyOrder());
    }

    FlyOrder getCommonFlyOrder() {
        FlyOrder flyOrder = new FlyOrder();
        flyOrder.setClientName("Nik");
        flyOrder.setFlyNumber("KLM 1382");
        flyOrder.setFrom("KBP");
        flyOrder.setTo("AMS");

        return flyOrder;
    }

    FlyOrder getCorrectFlyOrder() {
        FlyOrder flyOrder = getCommonFlyOrder();
        flyOrder.setDate(Date.from(Instant.now().plus(Period.ofDays(3))));

        return flyOrder;
    }

    FlyOrder getIncorrectFlyOrder() {
        FlyOrder flyOrder = getCommonFlyOrder();
        flyOrder.setDate(Date.from(Instant.now().minus(Period.ofDays(3))));

        return flyOrder;
    }

    HotelOrder getCommonHotelOrder() {
        HotelOrder hotelOrder = new HotelOrder();
        hotelOrder.setClintName("Nik");
        hotelOrder.setHotelName("Hilton");
        hotelOrder.setArrival(Date.from(Instant.now()));

        return hotelOrder;
    }

    HotelOrder getCorrectHotelOrder() {
        HotelOrder hotelOrder = getCommonHotelOrder();
        hotelOrder.setDeparture(Date.from(Instant.now().plus(Period.ofDays(3))));

        return hotelOrder;
    }

    HotelOrder getIncorrectHotelOrder() {
        HotelOrder hotelOrder = getCommonHotelOrder();
        hotelOrder.setDeparture(Date.from(Instant.now().minus(Period.ofDays(3))));

        return hotelOrder;
    }
}