package com.yanxin.dao;

import java.util.List;

import com.yanxin.domain.AppUser;
import com.yanxin.domain.AppUserExample;
	
public interface UserMapper {
	 long countByExample(AppUserExample example);

	    int deleteByExample(AppUserExample example);

	    int insert(AppUser record);

	    int insertSelective(AppUser record);

	    List<AppUser> selectByExample(AppUserExample example);

	    int updateByPrimaryKey(AppUser record); 
}