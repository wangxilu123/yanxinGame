package com.yanxin.service;

import com.yanxin.domain.AppUser;
import com.yanxin.domain.LoginEntity;


public interface UserService {

    /**
     * 用户注册
     * @param RegisterEntity
     * @return
     */
/*	ResultDto<Integer> addUser(RegisterEntity register);
*/	
    /**
     * 用户登录
     * @param LoginEntity
     * @return
     */
    AppUser login(LoginEntity user);
}
