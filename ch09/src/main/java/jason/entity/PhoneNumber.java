package jason.entity;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

/**
 * @author : yusik
 * @date : 25/11/2018
 */

@Embeddable
public class PhoneNumber {

    private String areaCode;
    private String localNumber;
    @ManyToOne PhoneServiceProvider provider; // entity 참조

}
