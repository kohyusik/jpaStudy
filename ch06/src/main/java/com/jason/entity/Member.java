package com.jason.entity;

import javax.persistence.*;

@Entity
@SequenceGenerator(
        name = "SEQ_MEMBER",
        allocationSize = 1)
@Table(name = "MEMBER", uniqueConstraints = {
        @UniqueConstraint(
                name = "NAME_UNIQUE",
                columnNames = {"NAME"})})
public class Member {
    
    
    public Member() {}
    public Member(String name) {
        this.name = name;
    }
    
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_MEMBER")
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;
    
    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;
    
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
    
    public Locker getLocker() {
        
        return locker;
    }
    
    public void setLocker(Locker locker) {
        
        this.locker = locker;
    }
    
    @Override
    public String toString() {
        
        return "\n[ Member ]\n{\n" +
                "\n- id=" + id +
                "\n- name=" + name +
                "\n- locker=" + locker +
                "\n}";
    }
}

