package com.yanxin.dao;

import java.util.List;

import com.yanxin.domain.UserLogin;
import com.yanxin.domain.UserLoginExample;

public interface UserLoginMapper {
    long countByExample(UserLoginExample example);

    int deleteByExample(UserLoginExample example);

    int insert(UserLogin record);

    int insertSelective(UserLogin record);

    List<UserLogin> selectByExample(UserLoginExample example);
    
    UserLogin findByToken(String token);
    
    int updateByPrimaryKey(UserLogin record);

}