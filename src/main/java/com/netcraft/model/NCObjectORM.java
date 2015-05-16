package com.netcraft.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "objects")
public class NCObjectORM {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private long object_id;

    private String name;
    private long parent_id;
    private long object_type_id;

    public long getObject_id() {
        return object_id;
    }
    public void setObject_id(long object_id) {
        this.object_id = object_id;
    }

    public long getObject_type_id() {
        return object_type_id;
    }
    public void setObject_type_id(long object_type_id) {
        this.object_type_id = object_type_id;
    }

    public long getParent_id() {
        return parent_id;
    }
    public void setParent_id(long parent_id) {
        this.parent_id = parent_id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
