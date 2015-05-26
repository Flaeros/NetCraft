package com.netcraft.hibernate.service;

import com.netcraft.model.Attribute;
import com.netcraft.hibernate.DAO.AttributeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
public class AttributeServiceImpl implements AttributeService {

    @Qualifier("AttributeDAO")
    @Autowired
    AttributeDAO attributeDAO;

    @Transactional
    public void addAttribute(Attribute attribute) throws SQLException {
        attributeDAO.addAttribute(attribute);
    }

    @Transactional
    public void updateAttribute(Attribute attribute) throws SQLException {
        attributeDAO.updateAttribute(attribute);
    }

    @Transactional
    public Attribute getAttribute(long attr_id) throws SQLException {
        return attributeDAO.getAttribute(attr_id);
    }

    @Transactional
    public void deleteAttribute(Attribute attribute) throws SQLException {
        attributeDAO.deleteAttribute(attribute);
    }
}
