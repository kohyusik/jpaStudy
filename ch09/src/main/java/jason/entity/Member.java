package jason.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Member {
    
    
    public Member() {}
    public Member(String name) {
        this.name = name;
    }

    @Id @GeneratedValue
    private Long id;

    private String name;

    @Embedded
    Period workPeriod;

    @Embedded
    Address homeAddress;

//    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(name = "city", column = @Column(name = "COMPANY_CITY")),
//            @AttributeOverride(name = "street", column = @Column(name = "COMPANY_STREET")),
//            @AttributeOverride(name = "state", column = @Column(name = "COMPANY_STATE")),
//            @AttributeOverride(name = "zipcode", column = @Column(name = "COMPANY_ZIPCODE"))
//    })
//    Address companyAddress;

    @Embedded
    PhoneNumber phoneNumber;

}

