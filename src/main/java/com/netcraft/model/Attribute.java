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
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long attr_id;

    @Column
    private long attr_type_id;
    @Column
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "attributes")
    private Set<ObjectType> objectTypes = new HashSet<ObjectType>(0);

    public Attribute() {
    }

    public Attribute(long attr_type_id, String name, Set<ObjectType> objectTypes) {

        this.attr_type_id = attr_type_id;
        this.name = name;
        this.objectTypes = objectTypes;
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

    public Set<ObjectType> getObjectTypes() {
        return this.objectTypes;
    }

    public void setObjectTypes(Set<ObjectType> objectTypes) {
        this.objectTypes = objectTypes;
    }
}
