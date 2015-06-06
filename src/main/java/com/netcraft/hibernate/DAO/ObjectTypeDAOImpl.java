package com.netcraft.hibernate.DAO;

import com.netcraft.model.ObjectType;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class ObjectTypeDAOImpl implements ObjectTypeDAO {

    @Autowired
    SessionFactory sessionFactory;

    public void addObjectType(ObjectType objectType) throws SQLException {
        sessionFactory.getCurrentSession().save(objectType);
    }

    public void updateObjectType(ObjectType objectType) throws SQLException {
        sessionFactory.getCurrentSession().update(objectType);
    }

    public ObjectType getObjectType(long object_type_id) throws SQLException {
        return (ObjectType)sessionFactory.getCurrentSession().get(ObjectType.class, object_type_id);
    }

    public List<ObjectType> getAllTypes() throws SQLException {
        return (List<ObjectType>) sessionFactory.getCurrentSession().createCriteria(ObjectType.class).addOrder(Order.asc("name")).list();
    }

    public void deleteObjectType(ObjectType objectType) throws SQLException {
        sessionFactory.getCurrentSession().delete(objectType);
    }

    public List<ObjectType> getChildTypes(long object_type_id) throws SQLException {
        List<ObjectType> childTypes = sessionFactory.getCurrentSession()
                .createSQLQuery("select * from object_types WHERE parent_id = :type")
                .setParameter("type", object_type_id)
                .setResultTransformer(Transformers.aliasToBean(ObjectType.class))
                .list();
        return childTypes;
    }
}
