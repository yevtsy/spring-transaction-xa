package pti.jta.xa.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pti.jta.xa.dao.fly.FlyOrder;
import pti.jta.xa.services.IFlyService;
import pti.jta.xa.dao.hotel.HotelOrder;
import pti.jta.xa.services.IHotelService;
import pti.jta.xa.services.TransactionServiceIntf;

/**
 * Created by yevhen.tsyba on 29.03.2015.
 */
@Component
public class TransactionService implements TransactionServiceIntf {

    @Autowired
    private IFlyService flyService;

    @Autowired
    private IHotelService hotelService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void persist(final HotelOrder hotelOrder, final FlyOrder flyOrder) throws Exception {
        flyService.order(flyOrder);
        hotelService.order(hotelOrder);
    }

    public IHotelService getHotelService() {
        return hotelService;
    }

    public void setHotelService(final IHotelService hotelService) {
        this.hotelService = hotelService;
    }

    public IFlyService getFlyService() {

        return flyService;
    }

    public void setFlyService(final IFlyService flyService) {
        this.flyService = flyService;
    }
}
