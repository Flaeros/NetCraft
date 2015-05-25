package com.netcraft.hibernate.DAO;

import com.netcraft.model.Attribute;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
public class AttributeDAOImpl implements AttributeDAO {

    @Autowired
    SessionFactory sessionFactory;

    public void addAttribute(Attribute attribute) throws SQLException {
        sessionFactory.getCurrentSession().save(attribute);
    }

    public void updateAttribute(Attribute attribute) throws SQLException {
        sessionFactory.getCurrentSession().update(attribute);
    }

    public Attribute getAttribute(long attr_id) throws SQLException {
        return (Attribute)sessionFactory.getCurrentSession().get(Attribute.class, attr_id);
    }

    public void deleteAttribute(Attribute attribute) throws SQLException {
        sessionFactory.getCurrentSession().delete(attribute);
    }
}
