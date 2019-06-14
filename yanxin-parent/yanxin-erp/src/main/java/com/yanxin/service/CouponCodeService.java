package com.yanxin.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yanxin.dao.CouponCodeMapper;
import com.yanxin.domain.CouponCode;

@Service
public class CouponCodeService {

	@Autowired
	CouponCodeMapper couponCodeDao;
	public List<CouponCode> findCouponsWithParam(Map<String,Object> map){
		return couponCodeDao.findCouponsWithParam(map);
	}
	
	public List<CouponCode> findCouponsWithStatus(Long couponId){
		return couponCodeDao.findCouponsWithStatus(couponId);
	}
	
	public CouponCode selectById(Long couponCodeId) {
		return couponCodeDao.select(couponCodeId);
	}
	public int updateCouponCode(CouponCode couponCode) {
		return couponCodeDao.update(couponCode);
	}
}
