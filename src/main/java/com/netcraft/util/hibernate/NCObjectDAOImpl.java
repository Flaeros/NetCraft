package com.netcraft.util.hibernate;

import com.netcraft.model.NCObjectORM;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
            System.out.println("addObject error " +e.toString());
            //e.printStackTrace();
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
            System.out.println("error " + e.toString());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public NCObjectORM getObjectById(long id) throws SQLException {
        Session session = null;
        NCObjectORM object = null;
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            System.out.println("sessionFactory = " + sessionFactory);
            session = sessionFactory.openSession();
            object = (NCObjectORM) session.load(NCObjectORM.class, id);
            System.out.println("impl object = " + object.getName());
        } catch (Exception e) {
            System.out.println("getObjectById error " +e.toString());
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
            System.out.println("error " + e.toString());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
