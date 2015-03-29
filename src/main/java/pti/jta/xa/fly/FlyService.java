package pti.jta.xa.fly;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Date;

/**
 * Created by yevhen.tsyba on 29.03.2015.
 */
@Service
public class FlyService implements IFlyService {
    private static final Logger _log = Logger.getLogger(FlyService.class);

    @Autowired
    private FlyRepository flyRepository;

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void order(final FlyOrder flyOrder) throws Exception {
        if (flyOrder.getDate().before(Date.from(Instant.now())))
            throw new Exception("Cannot book tickets before current");

        _log.debug("Fly booking has been successfully");


        flyRepository.save(flyOrder);
    }
}