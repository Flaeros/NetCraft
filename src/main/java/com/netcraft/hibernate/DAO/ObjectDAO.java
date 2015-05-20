package com.netcraft.hibernate.DAO;

import com.netcraft.model.HObject;
import java.sql.SQLException;

public interface ObjectDAO {
    public void addObject(HObject HObject) throws SQLException;   //добавить объект
    public void updateObject(HObject HObject) throws SQLException;//обновить объект
    public HObject getObject(long object_id) throws SQLException;    //получить объект по id
    public void deleteStudent(HObject HObject) throws SQLException;//удалить объект
}
