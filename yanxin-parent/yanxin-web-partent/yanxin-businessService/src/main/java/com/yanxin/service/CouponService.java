package com.yanxin.service;

import com.github.pagehelper.PageInfo;
import com.yanxin.domain.AppUser;
import com.yanxin.domain.CouponDetail;

public interface CouponService {

	PageInfo<CouponDetail> findCouponByUserId(Integer userId,Integer pageNum,Integer pageSize,Integer status);
	
	CouponDetail exchangeCoupons(Integer userId,String code);

	void getCoupons(Integer userId, String couponIds);
	
	AppUser getAppUser(Integer userId);
	
}
