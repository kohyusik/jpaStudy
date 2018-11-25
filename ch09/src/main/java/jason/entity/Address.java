package jason.entity;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

/**
 * @author : yusik
 * @date : 25/11/2018
 */

@Data
@Embeddable
public class Address {

    private String city;
    private String street;
    private String state;

    @Embedded Zipcode zipcode;
}
