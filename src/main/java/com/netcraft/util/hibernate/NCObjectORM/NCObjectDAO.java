package com.netcraft.util.hibernate.NCObjectORM;

import com.netcraft.model.NCObjectORM;
import java.sql.SQLException;

public interface NCObjectDAO {
    public void addObject(NCObjectORM object) throws SQLException;   //добавить объект
    public void updateObject(NCObjectORM object) throws SQLException;//обновить объект
    public NCObjectORM getObject(long object_id) throws SQLException;    //получить объект по id
    public void deleteStudent(NCObjectORM object) throws SQLException;//удалить объект
}
