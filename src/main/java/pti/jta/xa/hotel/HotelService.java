package pti.jta.xa.hotel;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by yevhen.tsyba on 29.03.2015.
 */
@Service
public class HotelService implements IHotelService {
    private static final Logger _log = Logger.getLogger(HotelService.class);

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void order(final HotelOrder hotelOrder) throws Exception {
        if (hotelOrder.getDeparture().before(hotelOrder.getArrival()))
            throw new Exception("Departure date cannot be before arrival date");

        _log.debug("Hotel order successfully has been stored to database");

        hotelRepository.save(hotelOrder);
    }
}
