package com.netcraft.hibernate.service;

import com.netcraft.hibernate.DAO.ObjectTypeDAO;
import com.netcraft.model.ObjectType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
public class ObjectTypeServiceImpl implements ObjectTypeService {

    @Qualifier("ObjectTypeDAO")
    @Autowired
    ObjectTypeDAO objectTypeDAO;

    @Transactional
    public void addObjectType(ObjectType objectType) throws SQLException {
        objectTypeDAO.addObjectType(objectType);
    }

    @Transactional
    public void updateObjectType(ObjectType objectType) throws SQLException {
        objectTypeDAO.updateObjectType(objectType);
    }

    @Transactional
    public ObjectType getObjectType(long object_type_id) throws SQLException {
        return objectTypeDAO.getObjectType(object_type_id);
    }

    @Transactional
    public void deleteObjectType(ObjectType objectType) throws SQLException {
        objectTypeDAO.deleteObjectType(objectType);
    }
}
