package pti.jta.xa.services.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pti.jta.xa.dao.fly.FlyOrder;
import pti.jta.xa.services.IFlyService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.Instant;
import java.util.Date;

/**
 * Created by yevhen.tsyba on 29.03.2015.
 */
@Component
public class FlyService implements IFlyService {
    private static final Logger _log = Logger.getLogger(FlyService.class);

    @Autowired
    @PersistenceContext(unitName = "PersistenceUnit1")
    private EntityManager entityManager;

    @Override
    @Transactional
    public void order(final FlyOrder flyOrder) throws Exception {
        if (flyOrder.getDate().before(Date.from(Instant.now())))
            throw new Exception("Cannot book tickets before current");

        _log.debug("Fly booking has been successfully");

        entityManager.persist(flyOrder);
        System.out.println("FLY service commited: " + entityManager.contains(flyOrder));
    }
}
