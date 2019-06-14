package com.yanxin.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.xml.soap.SOAPException;

import com.github.pagehelper.PageInfo;
import com.yanxin.domain.Order;
import com.yanxin.domain.StaffDistribution;

public interface DistributionService {

	PageInfo<Order> orderList(Integer pageNum, Integer pageSize,Integer shopId ,String status,Integer adminId);
	
	Integer addDistribution(StaffDistribution distribution);
	
	Integer updateStatusByOrderId(Integer orderId) throws UnsupportedEncodingException, SOAPException, IOException;

	Integer cancelOrder(Integer orderId, String cancelReason);

	Order orderDetail(Integer orderId);
	
}
