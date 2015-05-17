package com.netcraft.hibernate.Attribute.DAO;

import com.netcraft.model.Attribute;

import java.sql.SQLException;

public interface AttributeDAO {
    public void addAttribute(Attribute attribute) throws SQLException;   //добавить аттрибут
    public void updateAttribute(Attribute attribute) throws SQLException;//обновить аттрибут
    public Attribute getAttribute(long attr_id) throws SQLException;    //получить аттрибут по id
    public void deleteAttribute(Attribute attribute) throws SQLException;//удалить аттрибут
}
