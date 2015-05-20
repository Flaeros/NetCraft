package com.netcraft.hibernate.service;

import com.netcraft.hibernate.DAO.ObjectTypeDAO;
import com.netcraft.model.ObjectType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
public class ObjectTypeServiceImpl implements ObjectTypeService {

    @Autowired
    ObjectTypeDAO objectTypeDAO;

    @Override
    @Transactional
    public void addObjectType(ObjectType objectType) throws SQLException {
        objectTypeDAO.addObjectType(objectType);
    }

    @Override
    @Transactional
    public void updateObjectType(ObjectType objectType) throws SQLException {
        objectTypeDAO.updateObjectType(objectType);
    }

    @Override
    @Transactional
    public ObjectType getObjectType(long object_type_id) throws SQLException {
        return objectTypeDAO.getObjectType(object_type_id);
    }

    @Override
    @Transactional
    public void deleteObjectType(ObjectType objectType) throws SQLException {
        objectTypeDAO.deleteObjectType(objectType);
    }
}
