package com.jason.ch04;

import javax.persistence.*;
import java.util.Date;

/**
 * @author : Yusik
 * @version : 1.0
 * @date : 2018-10-28
 * @description :
 */

@Entity
@SequenceGenerator(
        name = "SEQ_MEMBER",
        allocationSize = 1)
@Table(name = "MEMBER4", uniqueConstraints = {@UniqueConstraint(
        name = "NAME_AGEE_UNIQUE",
        columnNames = {"NAME", "AGE"})})
public class Member {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_MEMBER")
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Temporal(TemporalType.DATE)
    private Date lastModifiedDate;

    @Lob
    private String description;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", roleType=" + roleType +
                ", createDate='" + createDate + '\'' +
                ", lastModifiedDate='" + lastModifiedDate + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

