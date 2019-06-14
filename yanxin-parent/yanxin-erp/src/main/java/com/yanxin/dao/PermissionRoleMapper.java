package com.yanxin.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.yanxin.domain.PermissionRole;
public interface PermissionRoleMapper {
	
	public SqlSessionTemplate getSqlSessionTemplate();
	
	public int insertPermissionRolesBatch(List<PermissionRole> permissionRole);
	
	public int deleteByRoles(Long roleId);
	
	public List<PermissionRole> findByPermissions(Long permissions);
	
    public List<PermissionRole> findListAll();
	
	public PermissionRole findById(Long id);
	
	int insert(PermissionRole parameter);
	
	int update(PermissionRole parameter);
	
	int delete(Long id);
}