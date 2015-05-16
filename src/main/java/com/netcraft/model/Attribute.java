package com.netcraft.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "attributes")
public class Attribute {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private long attr_id;

    private long attr_type_id;
    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public long getAttr_type_id() {
        return attr_type_id;
    }
    public void setAttr_type_id(long attr_type_id) {
        this.attr_type_id = attr_type_id;
    }

    public long getAttr_id() {
        return attr_id;
    }
    public void setAttr_id(long attr_id) {
        this.attr_id = attr_id;
    }
}
