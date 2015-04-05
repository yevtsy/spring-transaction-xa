package pti.jta.xa.demo;

import pti.jta.xa.fly.FlyOrder;
import pti.jta.xa.hotel.HotelOrder;

/**
 * Created by yevhen.tsyba on 04.04.2015.
 */
public interface TransactionServiceIntf {
    void persist(HotelOrder hotelOrder, FlyOrder flyOrder) throws Exception;
}
