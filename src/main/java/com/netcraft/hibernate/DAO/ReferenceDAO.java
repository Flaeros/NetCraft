package com.netcraft.hibernate.DAO;

import com.netcraft.model.Reference;

import java.sql.SQLException;

public interface ReferenceDAO {
    public void addReference(Reference reference) throws SQLException;   //�������� ������
    public void updateReference(Reference reference) throws SQLException;//�������� ������
    public Reference getReference(long attr_id, long object_id) throws SQLException;    //�������� ������ �� id
    public void deleteReference(Reference reference) throws SQLException;//������� ������
}
