package pti.jta.xa.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pti.jta.xa.dao.fly.FlyOrder;
import pti.jta.xa.dao.hotel.HotelOrder;
import pti.jta.xa.services.FlyService;
import pti.jta.xa.services.HotelService;
import pti.jta.xa.services.TransactionService;

/**
 * Created by yevhen.tsyba on 29.03.2015.
 */
@Component
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private FlyService flyService;

    @Autowired
    private HotelService hotelService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void persist(final HotelOrder hotelOrder, final FlyOrder flyOrder) throws Exception {
        flyService.order(flyOrder);
        hotelService.order(hotelOrder);
    }

    public HotelService getHotelService() {
        return hotelService;
    }

    public void setHotelService(final HotelService hotelService) {
        this.hotelService = hotelService;
    }

    public FlyService getFlyService() {

        return flyService;
    }

    public void setFlyService(final FlyService flyService) {
        this.flyService = flyService;
    }
}
