package com.netcraft.model;

import javax.persistence.*;

@Entity
@Table(name = "attr_groups")
public class AttrGroup {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "attr_group_id")
    private long attr_group_id;

    @Column
    private String name;
    @Column
    private String tab;

    public long getAttr_group_id() {
        return attr_group_id;
    }
    public void setAttr_group_id(long attr_group_id) {
        this.attr_group_id = attr_group_id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getTab() {
        return tab;
    }
    public void setTab(String tab) {
        this.tab = tab;
    }
}
