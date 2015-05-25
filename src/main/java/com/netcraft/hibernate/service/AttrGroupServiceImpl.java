package com.netcraft.hibernate.service;

import com.netcraft.hibernate.DAO.AttrGroupDAO;
import com.netcraft.model.AttrGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
public class AttrGroupServiceImpl implements AttrGroupService{


    @Autowired
    AttrGroupDAO attrGroupDAO;

    @Transactional
    public void addAttrGroup(AttrGroup attrGroup) throws SQLException {
        attrGroupDAO.addAttrGroup(attrGroup);
    }

    @Transactional
    public void updateAttrGroup(AttrGroup attrGroup) throws SQLException {
        attrGroupDAO.updateAttrGroup(attrGroup);
    }

    @Transactional
    public AttrGroup getAttrGroup(long attr_group_id) throws SQLException {
        return attrGroupDAO.getAttrGroup(attr_group_id);
    }

    @Transactional
    public void deleteAttrGroup(AttrGroup attrGroup) throws SQLException {
        attrGroupDAO.deleteAttrGroup(attrGroup);
    }
}
