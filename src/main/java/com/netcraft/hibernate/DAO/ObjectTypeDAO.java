package com.netcraft.hibernate.DAO;

import com.netcraft.model.ObjectType;

import java.sql.SQLException;

public interface ObjectTypeDAO {
    public void addObjectType(ObjectType objectType) throws SQLException;   //добавить объектный тип
    public void updateObjectType(ObjectType objectType) throws SQLException;//обновить объектный тип
    public ObjectType getObjectType(long object_type_id) throws SQLException;    //получить объектный тип по id
    public void deleteObjectType(ObjectType objectType) throws SQLException;//удалить объектный тип
}
