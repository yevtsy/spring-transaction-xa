package pti.jta.xa.services.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pti.jta.xa.dao.hotel.HotelOrder;
import pti.jta.xa.services.IHotelService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by yevhen.tsyba on 29.03.2015.
 */
@Component
public class HotelService implements IHotelService {
    private static final Logger _log = Logger.getLogger(HotelService.class);

    @Autowired
    @PersistenceContext(unitName = "PersistenceUnit2")
    private EntityManager entityManager;

    @Override
    @Transactional
    public void order(final HotelOrder hotelOrder) throws Exception {
        if (hotelOrder.getDeparture().before(hotelOrder.getArrival()))
            throw new Exception("Departure date cannot be before arrival date");

        _log.debug("Hotel order successfully has been stored to database");

        entityManager.persist(hotelOrder);
        System.out.println("HOTEL service commited: " + entityManager.contains(hotelOrder));
    }
}
