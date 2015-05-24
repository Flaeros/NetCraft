package com.netcraft.model;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "objects")
public class NCObject {
    @Id
    @Column
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private long object_id;

    @Column
    private String name;
    @Column
    private long parent_id;
    @Column
    private long object_type_id;

    @OneToMany(fetch = FetchType.EAGER, mappedBy="ncObject")
    private Set<Param> params;

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

    public Set<Param> getParams() {
        return params;
    }
    public void setParams(Set<Param> params) {
        this.params = params;
    }
}
