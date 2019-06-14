package com.yanxin.dao;

import java.util.List;
import java.util.Map;

import com.yanxin.domain.CouponCode;
import com.yanxin.domain.CouponDetail;

public interface CouponCodeMapper {
    int delete(Long id);
    int insert(CouponCode record);
    CouponCode select(Long id);
    int update(CouponCode record);
    List<CouponCode> findCouponsWithParam(Map<String,Object> map);
    List<CouponCode> findCouponsWithParamExt(Map<String,Object> map);
    
    List<CouponCode> findCouponsWithStatus(Long couponId);
    
    List<CouponDetail> findCouponsByUserId(Map<String,Object> map);
    
    CouponDetail findCouponsByCode(String code);

    int findListCount(Map<String,Object> map);
    int findDispatchCount(Map<String,Object> map);
}