package com.netcraft.util.hibernate.NCObjectORM;

public class NCObjectORMFactory {
    private static NCObjectDAO objectDAO = null;
    private static NCObjectORMFactory instance = null;

    public static synchronized NCObjectORMFactory getInstance(){
        if (instance == null){
            instance = new NCObjectORMFactory();
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
