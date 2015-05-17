package com.netcraft.model;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity
@Table(name = "attributes")
public class Attribute{
    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long attr_id;

    @Column
    private long attr_type_id;
    @Column
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
