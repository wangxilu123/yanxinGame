package com.yanxin.service;

import com.github.pagehelper.PageInfo;
import com.yanxin.domain.Order;
import com.yanxin.domain.StaffSorting;

public interface SortingService {

	PageInfo<Order> orderList(Integer pageNum, Integer pageSize,Integer shopId ,String status,Integer adminId);
	
	Integer addSorting(StaffSorting staffSorting);
	
	Integer updateStatusByOrderId(Integer orderId,Integer shopId);
	
	Order orderDetail(Integer orderId);

	Integer cancelOrder(Integer orderId, String cancelReason);
	
}
