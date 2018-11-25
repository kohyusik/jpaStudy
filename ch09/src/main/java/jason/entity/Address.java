package jason.entity;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

/**
 * @author : yusik
 * @date : 25/11/2018
 */

@Embeddable
public class Address {

    private String city;
    private String street;
    private String state;

    @Embedded Zipcode zipcode;
}
