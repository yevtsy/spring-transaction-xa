package pti.jta.xa.fly;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by yevhen.tsyba on 29.03.2015.
 */
@Entity
@Table(name = "TBL_FLY_BOOKING")
public class FlyOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FLYGEN")
    @SequenceGenerator(name = "FLYGEN", sequenceName = "fly_booking_id_seq")
    private Long id;

    @Column(name = "client_name")
    private String clientName;

    @Column(name = "fly_number")
    private String flyNumber;

    @Column
    private String from;

    @Column
    private String to;

    @Column
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(final Date date) {
        this.date = date;
    }

    public String getTo() {

        return to;
    }

    public void setTo(final String to) {
        this.to = to;
    }

    public String getFrom() {

        return from;
    }

    public void setFrom(final String from) {
        this.from = from;
    }

    public String getFlyNumber() {

        return flyNumber;
    }

    public void setFlyNumber(final String flyNumber) {
        this.flyNumber = flyNumber;
    }

    public String getClientName() {

        return clientName;
    }

    public void setClientName(final String clientName) {
        this.clientName = clientName;
    }

    public Long getId() {

        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }
}
