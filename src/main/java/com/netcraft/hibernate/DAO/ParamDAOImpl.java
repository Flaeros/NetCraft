package com.netcraft.hibernate.DAO;

import com.netcraft.hibernate.composite.ParamPK;
import com.netcraft.model.Param;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
public class ParamDAOImpl implements ParamDAO {

    @Autowired
    SessionFactory sessionFactory;

    public void addParam(Param param) throws SQLException {
        sessionFactory.getCurrentSession().save(param);
    }

    public void updateParam(Param param) throws SQLException {
        sessionFactory.getCurrentSession().update(param);
    }

    public Param getParam(long attr_id, long object_id) throws SQLException {
        ParamPK paramPK = new ParamPK(attr_id, object_id);
        return (Param) sessionFactory.getCurrentSession().get(Param.class, paramPK);
    }

    public void deleteParam(Param param) throws SQLException {
        sessionFactory.getCurrentSession().delete(param);
    }
}
