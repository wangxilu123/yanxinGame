package com.yanxin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yanxin.domain.UserAddress;
import com.yanxin.domain.UserAddressExample;

public interface UserAddressMapper {
    long countByExample(UserAddressExample example);

    int deleteByExample(UserAddressExample example);

    int insert(UserAddress record);

    int insertSelective(UserAddress record);

    List<UserAddress> selectByExample(UserAddressExample example);

    int updateByPrimaryKey(UserAddress record);
    
    int updateByExample(@Param("record") UserAddress record, @Param("example") UserAddressExample example);
}