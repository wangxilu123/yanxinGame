package com.yanxin.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.yanxin.domain.Role;


public interface RoleMapper{

	
	public SqlSessionTemplate getSqlSessionTemplate();
	public List<Role> findByUserName(String username);
	
	public Role selectByName(String rolename);
	
    public List<Role> findListAll();
	
	public Role findById(Long id);
	
	int insert(Role parameter);
	
	int update(Role parameter);
	
	int delete(Long id);
    
}