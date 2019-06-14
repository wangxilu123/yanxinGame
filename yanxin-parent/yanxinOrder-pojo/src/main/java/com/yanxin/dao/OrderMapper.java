package com.yanxin.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.yanxin.domain.Order;
import com.yanxin.domain.OrderExample;


@Mapper
public interface OrderMapper {
	long countByExample(OrderExample example);

    int deleteByExample(OrderExample example);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExample(OrderExample example);

    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);
    
    List<Order> selectParseStatus(@Param("storeId")Integer storeId);
    
    List<Order> findOrdersWithParam(Map<String,Object> map);
    
}