package com.jason.entity.embedded;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MotherId implements Serializable {

    @Column(name = "MOTHER_ID1")
    private String id1;

    @Column(name = "MOTHER_ID2")
    private String id2;

    public MotherId() {
    }

    public MotherId(String id1, String id2) {
        this.id1 = id1;
        this.id2 = id2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MotherId)) return false;
        MotherId parentId = (MotherId) o;
        return Objects.equals(getId1(), parentId.getId1()) &&
                Objects.equals(getId2(), parentId.getId2());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId1(), getId2());
    }

    public String getId1() {
        return id1;
    }

    public void setId1(String id1) {
        this.id1 = id1;
    }

    public String getId2() {
        return id2;
    }

    public void setId2(String id2) {
        this.id2 = id2;
    }
}
