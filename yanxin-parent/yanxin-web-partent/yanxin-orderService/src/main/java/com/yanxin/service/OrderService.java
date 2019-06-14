package com.yanxin.service;

import java.math.BigDecimal;
import java.util.List;

import com.github.pagehelper.PageInfo;
import com.yanxin.domain.CategoryAndAmount;
import com.yanxin.domain.CouponDetail;
import com.yanxin.domain.Order;
import com.yanxin.domain.OrderProduct;
import com.yanxin.domain.Postage;

public interface OrderService {
  
	Integer addOrder(Order order);
	
	Integer updateOrder(Order order);
	
    PageInfo<Order> orderList(Integer pageNum, Integer pageSize,Integer userId,String status);
    
    List<Order> findOrders();
    
    Order findById(Integer orderId);
    
    List<CouponDetail> checkCoupons(Integer userId,List<OrderProduct> productList,List<CategoryAndAmount> amountList,BigDecimal totalAmount);

	Integer returnMoney(Integer orderId);

	Order orderDetail(Integer userId, Integer orderId);
	
	Postage  orderPostage(Integer shopId);
	
	Order findByOrderNum(String orderNum);
}
