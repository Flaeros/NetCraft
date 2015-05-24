package com.netcraft.hibernate.DAO;

import com.netcraft.model.Param;

import java.sql.SQLException;

public interface ParamDAO {
    public void addParam(Param param) throws SQLException;   //добавить значение
    public void updateParam(Param param) throws SQLException;//обновить значение
    public Param getParam(long attr_id, long object_id) throws SQLException;    //получить значение по объекту и аттрибуту
    public void deleteParam(Param param) throws SQLException;//удалить значение
}
