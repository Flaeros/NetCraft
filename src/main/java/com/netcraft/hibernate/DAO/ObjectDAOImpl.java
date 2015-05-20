package com.netcraft.hibernate.DAO;

import com.netcraft.model.HObject;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
public class ObjectDAOImpl implements ObjectDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addObject(HObject HObject) throws SQLException {
        sessionFactory.getCurrentSession().save(HObject);
    }

    @Override
    public void updateObject(HObject HObject) throws SQLException {
        sessionFactory.getCurrentSession().update(HObject);
    }

    @Override
    public HObject getObject(long object_id) throws SQLException {
        return (HObject)sessionFactory.getCurrentSession().get(HObject.class, object_id);
    }

    @Override
    public void deleteStudent(HObject HObject) throws SQLException {
        sessionFactory.getCurrentSession().delete(HObject);
    }
}
