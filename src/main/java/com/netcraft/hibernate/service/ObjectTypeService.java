package com.netcraft.hibernate.service;

import com.netcraft.hibernate.DAO.ObjectTypeDAO;
import com.netcraft.model.ObjectType;

import java.sql.SQLException;
import java.util.List;

public interface ObjectTypeService extends ObjectTypeDAO {
    List<ObjectType> getParentTypes(long object_type_id) throws SQLException; // получить иерархию родительских типов
}
