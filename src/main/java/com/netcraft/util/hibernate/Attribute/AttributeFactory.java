package com.netcraft.util.hibernate.Attribute;

public class AttributeFactory {

    private static AttributeDAO attributeDAO = null;
    private static AttributeFactory instance = null;

    public static synchronized AttributeFactory getInstance(){
        if (instance == null){
            instance = new AttributeFactory();
        }
        return instance;
    }

    public AttributeDAO getAttributeDAO(){
        if (attributeDAO == null){
            attributeDAO = new AttributeDAOImpl();
        }
        return attributeDAO;
    }
}
