package com.netcraft.util.hibernate;

import com.netcraft.model.NCObjectORM;

import java.math.BigInteger;
import java.sql.SQLException;

/**
 * Created by Flaeros on 14.05.2015.
 */
public interface NCObjectDAO {
    public void addObject(NCObjectORM object) throws SQLException;   //добавить объект
    public void updateObject(NCObjectORM object) throws SQLException;//обновить объект
    public NCObjectORM getObjectById(long id) throws SQLException;    //получить объект по id
    public void deleteStudent(NCObjectORM object) throws SQLException;//удалить объект
}
