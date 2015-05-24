package com.netcraft.hibernate.DAO;

import com.netcraft.hibernate.composite.ReferencePK;
import com.netcraft.model.Reference;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
public class ReferenceDAOImpl implements ReferenceDAO{

    @Autowired
    SessionFactory sessionFactory;

    public void addReference(Reference reference) throws SQLException {
        sessionFactory.getCurrentSession().save(reference);
    }

    public void updateReference(Reference reference) throws SQLException {
        sessionFactory.getCurrentSession().update(reference);
    }

    public Reference getReference(long attr_id, long object_id) throws SQLException {
        ReferencePK ReferencePK = new ReferencePK(attr_id, object_id);
        return (Reference) sessionFactory.getCurrentSession().get(Reference.class, ReferencePK);
    }

    public void deleteReference(Reference reference) throws SQLException {
        sessionFactory.getCurrentSession().delete(reference);
    }
}
