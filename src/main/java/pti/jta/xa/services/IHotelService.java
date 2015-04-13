package pti.jta.xa.services;

import pti.jta.xa.dao.hotel.HotelOrder;

/**
 * Created by yevhen.tsyba on 29.03.2015.
 */
public interface IHotelService {
    public void order(HotelOrder hotelOrder) throws Exception;
}
