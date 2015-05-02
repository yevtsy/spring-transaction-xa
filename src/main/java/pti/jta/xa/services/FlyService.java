package pti.jta.xa.services;

import pti.jta.xa.dao.fly.FlyOrder;

/**
 * Created by yevhen.tsyba on 29.03.2015.
 */
public interface FlyService {
    public void order(FlyOrder flyOrder) throws Exception;
}
