package pti.jta.xa.services.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pti.jta.xa.dao.hotel.HotelOrder;
import pti.jta.xa.services.HotelService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * Created by yevhen.tsyba on 29.03.2015.
 */
@Component
public class HotelServiceImpl implements HotelService {
    private static final Logger _log = Logger.getLogger(HotelServiceImpl.class);
    private EntityManager entityManager;

    @Autowired
    @Qualifier("entityManagerFactory1")
    private EntityManagerFactory emf;

    @Override
    @Transactional
    public void order(final HotelOrder hotelOrder) throws Exception {
        entityManager = emf.createEntityManager();

        if (hotelOrder.getDeparture().before(hotelOrder.getArrival()))
            throw new Exception("Departure date cannot be before arrival date");

        _log.debug("Hotel order successfully has been stored to database");

        entityManager.persist(hotelOrder);
        entityManager.flush();
        emf.close();
    }
}
