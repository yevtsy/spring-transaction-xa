package pti.jta.xa.fly;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by yevhen.tsyba on 29.03.2015.
 */
@Entity
@Table(name = "TBL_FLY_BOOKING")
public class FlyOrder{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "client_name")
    private String clientName;

    @Column(name = "fly_number")
    private String flyNumber;

    @Column
    private String leave;

    @Column
    private String arrive;

    @Column
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(final Date date) {
        this.date = date;
    }

    public String getArrive() {
        return arrive;
    }

    public void setArrive(final String arrive) {
        this.arrive = arrive;
    }

    public String getLeave() {

        return leave;
    }

    public void setLeave(final String leave) {
        this.leave = leave;
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
