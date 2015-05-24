package com.netcraft.hibernate.DAO;

import com.netcraft.model.Param;

import java.sql.SQLException;

public interface ParamDAO {
    public void addParam(Param param) throws SQLException;   //�������� ��������
    public void updateParam(Param param) throws SQLException;//�������� ��������
    public Param getParam(long attr_id, long object_id) throws SQLException;    //�������� �������� �� ������� � ���������
    public void deleteParam(Param param) throws SQLException;//������� ��������
}
