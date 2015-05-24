package com.netcraft.hibernate.DAO;

import com.netcraft.model.Reference;

import java.sql.SQLException;

public interface ReferenceDAO {
    public void addReference(Reference reference) throws SQLException;   //добавить ссылку
    public void updateReference(Reference reference) throws SQLException;//обновить ссылку
    public Reference getReference(long attr_id, long object_id) throws SQLException;    //получить ссылку по id
    public void deleteReference(Reference reference) throws SQLException;//удалить ссылку
}
