package com.netcraft.hibernate.service;

import com.netcraft.model.NCObject;
import com.netcraft.hibernate.DAO.ObjectDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
public class ObjectServiceImpl implements ObjectService {

    @Autowired
    ObjectDAO objectDAO;

    @Transactional
    public void addObject(NCObject NCObject) throws SQLException {
        objectDAO.addObject(NCObject);
    }

    @Transactional
    public void updateObject(NCObject NCObject) throws SQLException {
        objectDAO.updateObject(NCObject);
    }

    @Transactional
    public NCObject getObject(long object_id) throws SQLException {
        return objectDAO.getObject(object_id);
    }

    @Transactional
    public void deleteObject(NCObject NCObject) throws SQLException {
        objectDAO.deleteObject(NCObject);
    }
}
