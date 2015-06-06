package com.netcraft.hibernate.service;

import com.netcraft.hibernate.DAO.ObjectTypeDAO;
import com.netcraft.model.ObjectType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    public List<ObjectType> getAllTypes() throws SQLException {
        return objectTypeDAO.getAllTypes();
    }

    @Transactional
    public void deleteObjectType(ObjectType objectType) throws SQLException {
        objectTypeDAO.deleteObjectType(objectType);
    }

    @Transactional
    public List<ObjectType> getChildTypes(long object_type_id) throws SQLException {
        return objectTypeDAO.getChildTypes(object_type_id);
    }

    @Transactional
    public List<ObjectType> getParentTypes(long object_type_id) throws SQLException{
        if(object_type_id == 0)
            return null;

        ObjectType objectType = getObjectType(object_type_id);
        long current_id = objectType.getParent_id();

        List<ObjectType> typesList= new ArrayList<ObjectType>();
        while (current_id != 0)
        {
            System.out.println("current_id = " + current_id);
            ObjectType currentType = getObjectType(current_id);
            typesList.add(currentType);
            current_id = currentType.getParent_id();
        }
        return typesList;
    }
}
