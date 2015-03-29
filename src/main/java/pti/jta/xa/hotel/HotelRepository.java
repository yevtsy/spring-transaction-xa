package pti.jta.xa.hotel;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by yevhen.tsyba on 29.03.2015.
 */
public interface HotelRepository extends CrudRepository<HotelOrder, Long> {
}
