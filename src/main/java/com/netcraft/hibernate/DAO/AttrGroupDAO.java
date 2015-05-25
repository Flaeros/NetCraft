package com.netcraft.hibernate.DAO;

import com.netcraft.model.AttrGroup;

import java.sql.SQLException;

public interface AttrGroupDAO {
    public void addAttrGroup(AttrGroup attrGroup) throws SQLException;   //добавить аттрибутную группу
    public void updateAttrGroup(AttrGroup attrGroup) throws SQLException;//обновить аттрибутную группу
    public AttrGroup getAttrGroup(long attr_group_id) throws SQLException;    //получить аттрибутную группу по id
    public void deleteAttrGroup(AttrGroup attrGroup) throws SQLException;//удалить аттрибутную группу
}
