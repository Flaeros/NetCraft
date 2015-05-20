package com.netcraft.hibernate.service;

import com.netcraft.model.HObject;
import com.netcraft.hibernate.DAO.ObjectDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
public class ObjectServiceImpl implements ObjectService {

    @Autowired
    ObjectDAO objectDAO;

    @Override
    @Transactional
    public void addObject(HObject HObject) throws SQLException {
        objectDAO.addObject(HObject);
    }

    @Override
    @Transactional
    public void updateObject(HObject HObject) throws SQLException {
        objectDAO.updateObject(HObject);
    }

    @Override
    @Transactional
    public HObject getObject(long object_id) throws SQLException {
        return objectDAO.getObject(object_id);
    }

    @Override
    @Transactional
    public void deleteStudent(HObject HObject) throws SQLException {
        objectDAO.deleteStudent(HObject);
    }
}
