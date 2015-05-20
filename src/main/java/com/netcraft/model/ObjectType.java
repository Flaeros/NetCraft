package com.netcraft.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "object_types")
public class ObjectType implements Serializable{

    @Id
    @Column
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long object_type_id;

    @Column
    private String name;
    @Column
    private long parent_id;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "attr_object_types", joinColumns = {
            @JoinColumn(name = "object_type_id", referencedColumnName="object_type_id") },
            inverseJoinColumns = { @JoinColumn(name = "attr_id",
                    referencedColumnName="attr_id") })
    private Set<Attribute> attributes = new HashSet<Attribute>(0);

    public ObjectType() {
    }

    public ObjectType(Set<Attribute> attributes, String name, long parent_id) {

        this.attributes = attributes;
        this.name = name;
        this.parent_id = parent_id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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

    public Set<Attribute> getAttributes() {
        return this.attributes;
    }

    public void setAttributes(Set<Attribute> attributes) {
        this.attributes = attributes;
    }
}
