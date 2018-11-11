package com.jason.entity.embedded;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Mother {


    @EmbeddedId
    private MotherId motherId;

    private String name;

    public MotherId getMotherId() {
        return motherId;
    }

    public void setMotherId(MotherId motherId) {
        this.motherId = motherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
