package com.yanxin.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yanxin.domain.Shop;
import com.yanxin.domain.ShopExample;

public interface ShopMapper {
    long countByExample(ShopExample example);

    int deleteByExample(ShopExample example);

    int insert(Shop record);

    int insertSelective(Shop record);
    
    Shop selectByPrimaryKey(Integer id);

    List<Shop> selectByExample(ShopExample example);

    int updateByExampleSelective(@Param("record") Shop record, @Param("example") ShopExample example);

    int updateByExample(@Param("record") Shop record, @Param("example") ShopExample example);
    
    List<Shop> findListAll();
    
    List<Shop> findListByPage(Map<String,Object> map);
}