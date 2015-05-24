package com.netcraft.hibernate.service;

import com.netcraft.hibernate.DAO.ParamDAO;
import com.netcraft.model.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
public class ParamServiceImpl implements ParamService {

    @Autowired
    ParamDAO paramDAO;

    @Transactional
    public void addParam(Param param) throws SQLException {
        paramDAO.addParam(param);
    }

    @Transactional
    public void updateParam(Param param) throws SQLException {
        paramDAO.updateParam(param);
    }

    @Transactional
    public Param getParam(long attr_id, long object_id) throws SQLException {
        return paramDAO.getParam(attr_id, object_id);
    }

    @Transactional
    public void deleteParam(Param param) throws SQLException {
        paramDAO.deleteParam(param);
    }
}
