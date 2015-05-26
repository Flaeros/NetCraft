package com.netcraft.hibernate.service;

import com.netcraft.hibernate.DAO.ReferenceDAO;
import com.netcraft.model.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
public class ReferenceServiceImpl implements ReferenceService {

    @Qualifier("ReferenceDAO")
    @Autowired
    ReferenceDAO referenceDAO;

    @Transactional
    public void addReference(Reference reference) throws SQLException {
        referenceDAO.addReference(reference);
    }

    @Transactional
    public void updateReference(Reference reference) throws SQLException {
        referenceDAO.updateReference(reference);
    }

    @Transactional
    public Reference getReference(long attr_id, long object_id) throws SQLException {
        return referenceDAO.getReference(attr_id, object_id);
    }

    @Transactional
    public void deleteReference(Reference reference) throws SQLException {
        referenceDAO.deleteReference(reference);
    }
}
