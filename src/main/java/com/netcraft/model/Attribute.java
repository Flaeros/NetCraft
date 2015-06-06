package com.netcraft.model;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "attributes")
public class Attribute implements Serializable{
    @Id
    @Column
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private long attr_id;

    @Column
    private long attr_type_id;
    @Column
    private String name;
    @Column(nullable = true)
    private long attr_group_id;


    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "attributes")
    private Set<ObjectType> objectTypes = new HashSet<ObjectType>(0);

    @OneToMany(fetch = FetchType.EAGER, mappedBy="attribute")
    private Set<Param> params;

    @OneToMany(fetch = FetchType.EAGER, mappedBy="attribute")
    private Set<Reference> references;

    public Attribute() {
    }

    public Attribute(long attr_type_id, String name, Set<ObjectType> objectTypes, long attr_group_id) {

        this.attr_type_id = attr_type_id;
        this.name = name;
        this.objectTypes = objectTypes;
        this.attr_group_id = attr_group_id;
    }

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

    public long getAttr_group_id() {
        return attr_group_id;
    }

    public void setAttr_group_id(long attr_group_id) {
        this.attr_group_id = attr_group_id;
    }

    public Set<ObjectType> getObjectTypes() {
        return this.objectTypes;
    }
    public void setObjectTypes(Set<ObjectType> objectTypes) {
        this.objectTypes = objectTypes;
    }

    public Set<Param> getParams() {
        return params;
    }
    public void setParams(Set<Param> params) {
        this.params = params;
    }

    public Set<Reference> getReferences() {
        return references;
    }
    public void setReferences(Set<Reference> references) {
        this.references = references;
    }
}
