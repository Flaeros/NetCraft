package com.netcraft.hibernate.DAO;

import com.netcraft.model.AttrGroup;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
public class AttrGroupDAOImpl implements AttrGroupDAO {

    @Autowired
    SessionFactory sessionFactory;

    public void addAttrGroup(AttrGroup attrGroup) throws SQLException {
        sessionFactory.getCurrentSession().save(attrGroup);
    }

    public void updateAttrGroup(AttrGroup attrGroup) throws SQLException {
        sessionFactory.getCurrentSession().update(attrGroup);
    }

    public AttrGroup getAttrGroup(long attr_group_id) throws SQLException {
        return (AttrGroup)sessionFactory.getCurrentSession().get(AttrGroup.class, attr_group_id);
    }

    public void deleteAttrGroup(AttrGroup attrGroup) throws SQLException {
        sessionFactory.getCurrentSession().delete(attrGroup);
    }
}
