package com.netcraft.hibernate.service;

import com.netcraft.model.Attribute;
import com.netcraft.hibernate.DAO.AttributeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
public class AttributeServiceImpl implements AttributeService {

    @Autowired
    AttributeDAO attributeDAO;

    @Override
    @Transactional
    public void addAttribute(Attribute attribute) throws SQLException {
        attributeDAO.addAttribute(attribute);
    }

    @Override
    @Transactional
    public void updateAttribute(Attribute attribute) throws SQLException {
        attributeDAO.updateAttribute(attribute);
    }

    @Override
    @Transactional
    public Attribute getAttribute(long attr_id) throws SQLException {
        return attributeDAO.getAttribute(attr_id);
    }

    @Override
    @Transactional
    public void deleteAttribute(Attribute attribute) throws SQLException {
        attributeDAO.deleteAttribute(attribute);
    }
}
