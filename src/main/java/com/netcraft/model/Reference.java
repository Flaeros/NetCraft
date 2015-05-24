package com.netcraft.model;

import com.netcraft.hibernate.composite.ReferencePK;

import javax.persistence.*;

@Entity
@Table(name = "referencess")
public class Reference {
    @EmbeddedId
    ReferencePK referencePK;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="attr_id", insertable = false, updatable = false)
    private Attribute attribute;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="object_id", insertable = false, updatable = false)
    private NCObject ncObject;

    @Column
    private long reference;

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

    public long getReference() {
        return reference;
    }

    public void setReference(long reference) {
        this.reference = reference;
    }
}
