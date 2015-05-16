package com.netcraft.util.hibernate.Attribute;

import com.netcraft.model.Attribute;
import com.netcraft.util.hibernate.HibernateUtil;
import org.hibernate.Session;

import java.sql.SQLException;

public class AttributeDAOImpl implements AttributeDAO {

    @Override
    public void addAttribute(Attribute attribute) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(attribute);
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
    public void updateAttribute(Attribute attribute) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(attribute);
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
    public Attribute getAttribute(long attr_id) throws SQLException {
        Session session = null;
        Attribute attribute = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            attribute = (Attribute) session.load(Attribute.class, attr_id);
            System.out.println("[AttributeDAOImpl] attribute = " + attribute.getName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return attribute;
    }

    @Override
    public void deleteAttribute(Attribute attribute) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(attribute);
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
