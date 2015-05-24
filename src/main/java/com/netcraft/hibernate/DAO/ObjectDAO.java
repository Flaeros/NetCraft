package com.netcraft.hibernate.DAO;

import com.netcraft.model.NCObject;

import java.sql.SQLException;

public interface ObjectDAO {
    public void addObject(NCObject NCObject) throws SQLException;   //добавить объект
    public void updateObject(NCObject NCObject) throws SQLException;//обновить объект
    public NCObject getObject(long object_id) throws SQLException;    //получить объект по id
    public void deleteObject(NCObject NCObject) throws SQLException;//удалить объект
}
