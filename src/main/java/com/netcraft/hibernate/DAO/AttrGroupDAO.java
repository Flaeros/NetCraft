package com.netcraft.hibernate.DAO;

import com.netcraft.model.AttrGroup;

import java.sql.SQLException;

public interface AttrGroupDAO {
    public void addAttrGroup(AttrGroup attrGroup) throws SQLException;   //�������� ����������� ������
    public void updateAttrGroup(AttrGroup attrGroup) throws SQLException;//�������� ����������� ������
    public AttrGroup getAttrGroup(long attr_group_id) throws SQLException;    //�������� ����������� ������ �� id
    public void deleteAttrGroup(AttrGroup attrGroup) throws SQLException;//������� ����������� ������
}
