package com.yanxin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yanxin.domain.Advertisement;
import com.yanxin.domain.AdvertisementExample;

public interface AdvertisementMapper {
    long countByExample(AdvertisementExample example);

    int deleteByExample(AdvertisementExample example);

    int insert(Advertisement record);

    int insertSelective(Advertisement record);

    List<Advertisement> selectByExample(AdvertisementExample example);
    
    Advertisement selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Advertisement record, @Param("example") AdvertisementExample example);

    int updateByExample(@Param("record") Advertisement record, @Param("example") AdvertisementExample example);
}