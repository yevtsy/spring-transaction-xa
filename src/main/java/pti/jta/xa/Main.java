package pti.jta.xa;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pti.jta.xa.demo.TransactionService;
import pti.jta.xa.demo.TransactionServiceIntf;
import pti.jta.xa.fly.FlyOrder;
import pti.jta.xa.hotel.HotelOrder;

/**
 * Created by yevhen.tsyba on 04.04.2015.
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[]{"spring.xml"});

        TransactionServiceIntf transactionService = (TransactionServiceIntf) context.getBean("transactionService");
        try {
            transactionService.persist(new HotelOrder(), new FlyOrder());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
