package com.zejing.qqzone.dao.impl;

import com.zejing.myssm.basedao.BaseDAO;
import com.zejing.qqzone.dao.UserBasicDAO;
import com.zejing.qqzone.pojo.UserBasic;

import java.util.List;

public class UserBasicDAOImpl extends BaseDAO<UserBasic> implements UserBasicDAO {

    @Override
    public UserBasic getUserBasic(String loginId, String password) {
        return load("select * from t_user_basic where loginId = ? and password = ?",loginId,password);
    }

    @Override
    public List<UserBasic> friendIdList(UserBasic userBasic) {

        String sql = "SELECT fid as 'id' FROM t_friend WHERE uid = ?";
        return executeQuery(sql,userBasic);
    }

    @Override
    public UserBasic getByUserBasicId(Integer id) {
        return load("select * from t_user_basic where id = ?",id);
    }
}
