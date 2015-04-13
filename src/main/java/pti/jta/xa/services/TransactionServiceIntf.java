package pti.jta.xa.services;

import pti.jta.xa.dao.fly.FlyOrder;
import pti.jta.xa.dao.hotel.HotelOrder;

/**
 * Created by yevhen.tsyba on 04.04.2015.
 */
public interface TransactionServiceIntf {
    void persist(HotelOrder hotelOrder, FlyOrder flyOrder) throws Exception;
}
