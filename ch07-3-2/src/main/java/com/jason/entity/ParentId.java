package com.jason.entity;

import java.io.Serializable;
import java.util.Objects;

public class ParentId implements Serializable {

    private String id1;

    private String id2;

    public ParentId() {
    }

    public ParentId(String id1, String id2) {
        this.id1 = id1;
        this.id2 = id2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParentId)) return false;
        ParentId parentId = (ParentId) o;
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
