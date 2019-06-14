package com.yanxin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yanxin.dao.PermissionRoleMapper;

@Service
public class PermissionRoleService {

	
	@Autowired
	PermissionRoleMapper permissionRoleDao;
	
}
