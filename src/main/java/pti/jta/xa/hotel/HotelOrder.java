package pti.jta.xa.hotel;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by yevhen.tsyba on 29.03.2015.
 */
@Entity
@Table(name = "TBL_HOTEL_BOOKING")
public class HotelOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HOTELGEN")
    @SequenceGenerator(name = "HOTELGEN", sequenceName = "hotel_booking_id_seq")
    private Long id;

    @Column(name = "client_name")
    private String clintName;

    @Column(name = "hotel_name")
    private String hotelName;

    @Column
    private Date arrival;

    @Column
    private Date departure;

    public Date getDeparture() {
        return departure;
    }

    public void setDeparture(final Date departure) {
        this.departure = departure;
    }

    public Date getArrival() {

        return arrival;
    }

    public void setArrival(final Date arrival) {
        this.arrival = arrival;
    }

    public String getHotelName() {

        return hotelName;
    }

    public void setHotelName(final String hotelName) {
        this.hotelName = hotelName;
    }

    public String getClintName() {

        return clintName;
    }

    public void setClintName(final String clintName) {
        this.clintName = clintName;
    }

    public Long getId() {

        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }
}
