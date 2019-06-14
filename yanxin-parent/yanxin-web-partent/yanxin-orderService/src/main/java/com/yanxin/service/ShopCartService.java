package com.yanxin.service;

import com.github.pagehelper.PageInfo;
import com.yanxin.domain.ShopCart;

public interface ShopCartService {
  
	Integer addShopCart(ShopCart shopCart);
	
	Integer updateShopCart(ShopCart shopCart);
	
    Integer deleteShopCart(String shopCartIds,Integer userId);
    
    PageInfo<ShopCart> shopCartList(Integer userId,Integer shopId);
}
