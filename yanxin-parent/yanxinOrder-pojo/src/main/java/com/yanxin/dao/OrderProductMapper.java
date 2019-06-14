package com.yanxin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yanxin.domain.OrderProduct;
import com.yanxin.domain.OrderProductExample;
import com.yanxin.domain.OrderProductTransfer;

public interface OrderProductMapper {
    long countByExample(OrderProductExample example);

    int deleteByExample(OrderProductExample example);

    int insert(OrderProduct record);

    int insertSelective(OrderProduct record);

    List<OrderProduct> selectByExample(OrderProductExample example);
    
    List<OrderProductTransfer> selectOrderDetail(Integer orderId);
    
    List<OrderProductTransfer> selectYouZanOrderDetail(Integer orderId);

    int updateByExampleSelective(@Param("record") OrderProduct record, @Param("example") OrderProductExample example);

    int updateByExample(@Param("record") OrderProduct record, @Param("example") OrderProductExample example);
}