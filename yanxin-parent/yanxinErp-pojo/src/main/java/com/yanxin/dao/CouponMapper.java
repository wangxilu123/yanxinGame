package com.yanxin.dao;

import java.util.List;
import java.util.Map;

import com.yanxin.domain.Coupon;
import com.yanxin.domain.CouponDetail;

public interface CouponMapper {
    int delete(Long id);

    int insert(Coupon record);

    Coupon select(Long id);

    Coupon selectByPrimaryKey(Long id);
    
    int update(Coupon record);
    
    List<Coupon> findCouponsWithParam(Map<String,Object> map);
    
    List<CouponDetail> findCouponsByProduct(Map<String,Object> map);
    
    List<CouponDetail> findCouponsByProduct1(Map<String,Object> map);
    
    List<CouponDetail> findCouponsByProduct2(Map<String,Object> map);
 
}