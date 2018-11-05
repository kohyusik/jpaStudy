package jason.entity;

import javax.persistence.*;

/**
 * @author : kohyusik
 * @version : 1.0
 * @date : 2018-11-02
 * @description :
 */

@Entity
@Table
public class Locker {
    
    public Locker(String name) {
        
        this.name = name;
    }
    
    public Locker() {
    
    }
    
    @Id
    @GeneratedValue
    private Long id;
    
    private String name;
    
    @OneToOne(mappedBy = "locker")
    private Member member;
    
    @Override
    public String toString() {
        
        return "\n[ Locker ]\n{\n" +
                "\n- id=" + id +
                "\n- name=" + name +
                "\n- member=" + member +
                "\n}";
    }
    
    public Long getId() {
        
        return id;
    }
    
    public void setId(Long id) {
        
        this.id = id;
    }
    
    public String getName() {
        
        return name;
    }
    
    public void setName(String name) {
        
        this.name = name;
    }
    
    public Member getMember() {
        
        return member;
    }
    
    public void setMember(Member member) {
        
        this.member = member;
    }
}
