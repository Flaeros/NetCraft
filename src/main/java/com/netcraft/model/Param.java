package com.netcraft.model;

import com.netcraft.hibernate.composite.ParamPK;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="params")
public class Param {
    @EmbeddedId
    ParamPK paramPK;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="attr_id", insertable = false, updatable = false)
    private Attribute attribute;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="object_id", insertable = false, updatable = false)
    private NCObject ncObject;

    @Column
    private String value;

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    public NCObject getNcObject() {
        return ncObject;
    }

    public void setNcObject(NCObject ncObject) {
        this.ncObject = ncObject;
    }

    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
}
