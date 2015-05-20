package com.netcraft.hibernate.DAO;

import com.netcraft.model.ObjectType;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
public class ObjectTypeDAOImpl implements ObjectTypeDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addObjectType(ObjectType objectType) throws SQLException {
        sessionFactory.getCurrentSession().save(objectType);
    }

    @Override
    public void updateObjectType(ObjectType objectType) throws SQLException {
        sessionFactory.getCurrentSession().update(objectType);
    }

    @Override
    public ObjectType getObjectType(long object_type_id) throws SQLException {
        return (ObjectType)sessionFactory.getCurrentSession().get(ObjectType.class, object_type_id);
    }

    @Override
    public void deleteObjectType(ObjectType objectType) throws SQLException {
        sessionFactory.getCurrentSession().delete(objectType);
    }
}
