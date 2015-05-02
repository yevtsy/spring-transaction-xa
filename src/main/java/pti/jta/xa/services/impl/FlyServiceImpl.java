package pti.jta.xa.services.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pti.jta.xa.dao.fly.FlyOrder;
import pti.jta.xa.services.FlyService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.time.Instant;
import java.util.Date;

/**
 * Created by yevhen.tsyba on 29.03.2015.
 */
@Component
public class FlyServiceImpl implements FlyService {
    private static final Logger _log = Logger.getLogger(FlyServiceImpl.class);
    private EntityManager entityManager;

    @Autowired
    @Qualifier("entityManagerFactory2")
    private EntityManagerFactory emf;

    @Override
    @Transactional
    public void order(final FlyOrder flyOrder) throws Exception {
        entityManager = emf.createEntityManager();

        if (flyOrder.getDate().before(Date.from(Instant.now())))
            throw new Exception("Cannot book tickets before current");

        _log.debug("Fly booking has been successfully");

        entityManager.persist(flyOrder);
        entityManager.flush();
        emf.close();
    }
}
