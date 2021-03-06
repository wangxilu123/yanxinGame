package com.yanxin.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yanxin.common.DateKit;
import com.yanxin.common.TokenUtils;
import com.yanxin.dao.AdminMapper;
import com.yanxin.dao.AdminRoleMapper;
import com.yanxin.dao.RoleMapper;
import com.yanxin.dao.ShopMapper;
import com.yanxin.dao.UserLoginMapper;
import com.yanxin.domain.Admin;
import com.yanxin.domain.AdminLogin;
import com.yanxin.domain.AdminRole;
import com.yanxin.domain.LoginEntity;
import com.yanxin.domain.Role;
import com.yanxin.domain.Shop;
import com.yanxin.domain.UserLogin;
import com.yanxin.domain.UserLoginExample;
import com.yanxin.exception.TipException;

@Service
public class AdminService {

	@Autowired
	AdminMapper adminDao;
	@Autowired
	AdminRoleMapper adminRoleDao;
	
	@Autowired
	RoleMapper roleMapper;
	
	@Autowired
	UserLoginMapper userLoginMapper;
	
	@Autowired
	ShopMapper shopMapper;

	public Admin findByUserName(String username) {
		return adminDao.findByUserName(username);
	}
	public Admin findByName(String name) {
		return adminDao.findByAdminName(name);
	}
	
	public AdminLogin findAdmin(String realName,String username,String password) {
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("name", realName);
		map.put("username", username);
		
		Admin admin = adminDao.findAdmin(map);
		
		if(admin!=null){
			
			List<AdminRole> adminRole = adminRoleDao.findByAdmins(admin.getId());
			
			Role role= roleMapper.findById(adminRole.get(0).getRoles());
			
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			
			boolean  check = encoder.matches(password, admin.getPassword());
			
			if(check==true){
				// 根据用户名查询用户登录信息

				UserLoginExample example1 = new UserLoginExample();

				example1.createCriteria().andUserAccountEqualTo(username);

				List<UserLogin> userLogins = userLoginMapper.selectByExample(example1);
				
				LoginEntity loginUser = new LoginEntity();
				
				loginUser.setUserAccount(username);
				
				String newToken = TokenUtils.createToken(loginUser);
				if (userLogins.size() != 0) {
					UserLogin userLogin = userLogins.get(0);

					userLogin.setToken(newToken);
					userLogin.setLastLogin(new Date());
					// token保鲜
					userLoginMapper.updateByPrimaryKey(userLogin);
				} else {
					UserLogin userLogin = new UserLogin();
					userLogin.setToken(newToken);
					userLogin.setUserAccount(loginUser.getUserAccount());
					userLogin.setLastLogin(new Date());

					userLoginMapper.insert(userLogin);
				}
				//根据门店ID查询门店信息
				Shop shop  = shopMapper.selectByPrimaryKey(admin.getCompanyId());
				
	            AdminLogin adminLogin = new AdminLogin();
				
				adminLogin.setAdminId(admin.getId().intValue());
				adminLogin.setRealName(admin.getName());
				adminLogin.setCompanyId(admin.getCompanyId());
				adminLogin.setToken(newToken);
				adminLogin.setUsername(admin.getUsername());
				adminLogin.setShopName(shop.getShopName());
				adminLogin.setRole(role.getValue());
				return adminLogin;
			}else{
				return null;
			}
		}else{
			return null;
		}
		 
	}
	

	public List<Admin> findListAll() {
		return adminDao.findListAll();
	}

	public Admin findById(Long id) {
		return adminDao.findById(id);
	}

	@Transactional
	public void insert(String username, String password, String name, Boolean isAccountEnabled, String email,
			String department, String[] roleIds,Integer companyId,String phone) {
		Admin admin = adminDao.findByUserName(username);
		if (admin != null) {
			throw new TipException("用户名已经存在");
		}
		admin = new Admin();
		admin.setUsername(username);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		admin.setPassword(encoder.encode(password.trim()));
		admin.setName(name);
		admin.setIsEnabled(isAccountEnabled);
		admin.setEmail(email);
		admin.setDepartment(department);
		admin.setDeleteFlag(false);
		admin.setIsLocked(false);
		admin.setCompanyId(companyId);
		admin.setPhone(phone);
		admin.setCreationDate(DateKit.dateFormat(DateKit.dateFormat(new Date())));
		adminDao.insert(admin);
		if (roleIds != null && roleIds.length > 0) {
			List<AdminRole> ars = new ArrayList<>();
			for (String roleId : roleIds) {
				AdminRole ar = new AdminRole();
				ar.setAdmins(admin.getId());
				ar.setRoles(Long.valueOf(roleId));
				ars.add(ar);
			}
			adminRoleDao.insertAdminRolesBatch(ars);
		}
	}

	@Transactional
	public int delete(String[] adminIds) {
		int resultDelete = 0;
		if (adminIds != null && adminIds.length > 0) {
			for(String adminId : adminIds) {
				adminRoleDao.deleteByAdmins(Long.valueOf(adminId));
				adminDao.delete(Long.valueOf(adminId));
			}
		}
		resultDelete = 1;
		return resultDelete;
	}

	@Transactional
	public void update(String username, String password, String name, Boolean isAccountEnabled, String email,
			String department, String[] roleIds,Long id,Integer companyId,String phone) {
		Admin admin = adminDao.findById(id);
		if(admin==null) {
			throw new TipException("用户不存在");
		}
		if(null != roleIds && roleIds.length>0) {
			adminRoleDao.deleteByAdmins(Long.valueOf(id));
			for(String roleId : roleIds) {
				AdminRole ar = new AdminRole();
				ar.setAdmins(id);
				ar.setRoles(Long.valueOf(roleId));
				adminRoleDao.insert(ar);
			}
		}
		admin.setUsername(username);
		if(null != password && !"".equals(password)) {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			admin.setPassword(encoder.encode(password.trim()));
		}
		admin.setIsEnabled(isAccountEnabled);
		admin.setEmail(email);
		admin.setDepartment(department);
		admin.setLastUpdatedDate(DateKit.dateFormat(DateKit.dateFormat(new Date())));
		admin.setCompanyId(companyId);
		admin.setName(name);
		admin.setPhone(phone);
		adminDao.update(admin);
	}
}
