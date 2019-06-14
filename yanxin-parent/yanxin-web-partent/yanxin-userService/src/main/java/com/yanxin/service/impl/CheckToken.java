package com.yanxin.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.yanxin.dao.UserLoginMapper;
import com.yanxin.dao.UserMapper;
import com.yanxin.domain.AppUser;
import com.yanxin.domain.AppUserExample;
import com.yanxin.domain.UserLogin;
import com.yanxin.domain.UserLoginExample;

/**
 * 验证Token
 * User: CQL
 *
 */
@Primary
@Service
public class CheckToken {
    @Autowired
    private UserMapper userMapper;
    
    @Autowired
    private UserLoginMapper userLoginMapper;
    
    public AppUser  check(String token){
    	
        //根据Token查询用户的信息
    	UserLoginExample example = new UserLoginExample();
		
		example.createCriteria().andTokenEqualTo(token);
    	
    	List<UserLogin> userLogins = userLoginMapper.selectByExample(example);
    	if(userLogins.size()!=0){
    		//根据用户名查询用户信息
    		AppUserExample example1 = new AppUserExample();

    		example1.createCriteria().andUserNameEqualTo(userLogins.get(0).getUserAccount());

    		List<AppUser> userList = userMapper.selectByExample(example1);
    		
    		return userList.get(0);
    	}else{
    		return null;
    	}
		
    }


}
