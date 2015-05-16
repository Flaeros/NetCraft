package com.netcraft.util.hibernate.NCObjectORM;

import com.netcraft.model.NCObjectORM;
import com.netcraft.util.hibernate.HibernateUtil;
import org.hibernate.Session;

import java.sql.SQLException;

public class NCObjectDAOImpl implements NCObjectDAO {

    @Override
    public void addObject(NCObjectORM object) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(object);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void updateObject(NCObjectORM object) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(object);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public NCObjectORM getObject(long id) throws SQLException {
        Session session = null;
        NCObjectORM object = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            object = (NCObjectORM) session.load(NCObjectORM.class, id);
            System.out.println("[NCObjectDAOImpl] object = " + object.getName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return object;
    }

    @Override
    public void deleteStudent(NCObjectORM object) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(object);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
