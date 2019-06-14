package com.yanxin.dao;

import java.util.List;
import java.util.Map;

import com.yanxin.domain.Admin;

public interface AdminMapper{

	public Admin findByUserName(String username); 
	public Admin findByAdminName(String name); 
	
	public Admin findAdmin(Map<String, String> map); 
	
	public List<Admin> findListAll();
	
	public Admin findById(Long id);
	
	int insert(Admin parameter);
	
	int update(Admin parameter);
	
	int delete(Long id);
	
}