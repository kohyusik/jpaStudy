package jason.entity;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * @author : yusik
 * @date : 25/11/2018
 */
@Embeddable
public class Period {

    @Temporal(TemporalType.DATE)
    Date startDate;

    @Temporal(TemporalType.DATE)
    Date endDate;

    public boolean isWork(Date date) {
        return true;
    }
}
