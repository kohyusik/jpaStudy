package com.jason.ch02;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author : Yusik
 * @version : 1.0
 * @date : 2018-10-28
 * @description :
 */

@Entity
@Table(name="MEMBER")
public class Member {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    private Integer age;

    public String getId() {

        return id;
    }

    public void setId(String id) {

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

    @Override
    public String toString() {

        return "\n[ Member ]\n{\n" +
                "\n- id=" + id +
                "\n- name=" + name +
                "\n- age=" + age +
                "\n}";
    }
}
