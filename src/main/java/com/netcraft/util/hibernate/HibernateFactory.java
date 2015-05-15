package com.netcraft.util.hibernate;

/**
 * Created by Flaeros on 14.05.2015.
 */
public class HibernateFactory {
    private static NCObjectDAO objectDAO = null;
    private static HibernateFactory instance = null;

    public static synchronized HibernateFactory getInstance(){
        if (instance == null){
            instance = new HibernateFactory();
        }
        return instance;
    }

    public NCObjectDAO getNCObjectDAO(){
        if (objectDAO == null){
            objectDAO = new NCObjectDAOImpl();
        }
        return objectDAO;
    }
}
