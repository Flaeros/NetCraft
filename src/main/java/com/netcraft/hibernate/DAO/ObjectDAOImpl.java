package com.netcraft.hibernate.DAO;

import com.netcraft.model.NCObject;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
public class ObjectDAOImpl implements ObjectDAO {

    @Autowired
    SessionFactory sessionFactory;

    public void addObject(NCObject NCObject) throws SQLException {
        sessionFactory.getCurrentSession().save(NCObject);
    }

    public void updateObject(NCObject NCObject) throws SQLException {
        sessionFactory.getCurrentSession().update(NCObject);
    }

    public NCObject getObject(long object_id) throws SQLException {
        return (NCObject)sessionFactory.getCurrentSession().get(NCObject.class, object_id);
    }

    public void deleteObject(NCObject NCObject) throws SQLException {
        sessionFactory.getCurrentSession().delete(NCObject);
    }
}
