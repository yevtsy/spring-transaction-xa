package pti.jta.xa;

import org.springframework.context.ApplicationContext;
import pti.jta.xa.demo.TransactionService;
import pti.jta.xa.demo.TransactionServiceIntf;
import pti.jta.xa.fly.FlyOrder;
import pti.jta.xa.hotel.HotelOrder;

import java.time.Instant;
import java.time.Period;
import java.util.Date;

/**
 * Created by yevhen.tsyba on 04.04.2015.
 */
public class Main {

    public static void main(String[] args) {

        TransactionServiceIntf transactionService = new TransactionService();

        System.out.println("******** Valid transaction ***********");
        try {
            transactionService.persist(getCorrectHotelOrder(), getCorrectFlyOrder());
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("******** Non Valid transaction: incorrect Fly order ***********");
        try {
            transactionService.persist(getCorrectHotelOrder(), getIncorrectFlyOrder());
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("******** Non Valid transaction: incorrect Hotel order ***********");
        try {
            transactionService.persist(getIncorrectHotelOrder(), getCorrectFlyOrder());
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("******** Non Valid transaction: invalid both orders ***********");
        try {
            transactionService.persist(getIncorrectHotelOrder(), getIncorrectFlyOrder());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static FlyOrder getCommonFlyOrder() {
        FlyOrder flyOrder = new FlyOrder();
        flyOrder.setClientName("Nik");
        flyOrder.setFlyNumber("KLM 1382");
        flyOrder.setFrom("KBP");
        flyOrder.setTo("AMS");

        return flyOrder;
    }

    static FlyOrder getCorrectFlyOrder() {
        FlyOrder flyOrder = getCommonFlyOrder();
        flyOrder.setDate(Date.from(Instant.now().plus(Period.ofDays(3))));

        return flyOrder;
    }

    static FlyOrder getIncorrectFlyOrder() {
        FlyOrder flyOrder = getCommonFlyOrder();
        flyOrder.setDate(Date.from(Instant.now().minus(Period.ofDays(3))));

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

    static HotelOrder getIncorrectHotelOrder() {
        HotelOrder hotelOrder = getCommonHotelOrder();
        hotelOrder.setDeparture(Date.from(Instant.now().minus(Period.ofDays(3))));

        return hotelOrder;
    }


}
