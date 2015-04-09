package pti.jta.xa;

import com.ibatis.common.jdbc.ScriptRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import pti.jta.xa.demo.TransactionService;
import pti.jta.xa.demo.TransactionServiceIntf;
import pti.jta.xa.fly.FlyOrder;
import pti.jta.xa.hotel.HotelOrder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.sql.*;
import java.time.Instant;
import java.time.Period;
import java.util.Date;

/**
 * Created by yevhen.tsyba on 04.04.2015.
 */
public class Main {

    public static void main(String[] args) throws ClassNotFoundException {

//        ResourceDatabasePopulator rdp = new ResourceDatabasePopulator();
//        rdp.addScript(new ClassPathResource("sql/ddl-posgre-hotel.sql"));
//        rdp.addScript(new ClassPathResource("sql/ddl-posgre-fly.sql"));

//        Class.forName("org.postgresql.Driver");
//
//        Connection connection = null;
//
//        try {
//            connection = DriverManager.getConnection(
//                    "jdbc:postgresql://127.0.0.1:5432/flies", "admin",
//                    "admin");
//            Statement st = connection.createStatement();
//            ResultSet res = st.executeQuery("select * from tbl_fly_booking");
//            res.close();
//            st.close();
////            rdp.populate(connection);
//        } catch (SQLException e) {
//
//            System.out.println("Connection Failed! Check output console");
//            e.printStackTrace();
//            return;
//        }

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
