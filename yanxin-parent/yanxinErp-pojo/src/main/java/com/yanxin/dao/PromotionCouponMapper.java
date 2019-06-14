package com.yanxin.dao;

import java.util.List;
import java.util.Map;

import com.yanxin.domain.PromotionCoupon;

public interface PromotionCouponMapper {
    int delete(Long id);

    int insert(PromotionCoupon record);

    PromotionCoupon select(Long id);

    int update(PromotionCoupon record);

    List<PromotionCoupon> findPromotionCouponsWithParam(Map<String,Object> map);
}