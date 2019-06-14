package com.yanxin.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yanxin.domain.FjpsHomePage;
import com.yanxin.domain.StaffDistribution;
import com.yanxin.domain.StaffDistributionExample;

public interface StaffDistributionMapper {
    long countByExample(StaffDistributionExample example);

    int deleteByExample(StaffDistributionExample example);

    int insert(StaffDistribution record);

    int insertSelective(StaffDistribution record);

    List<StaffDistribution> selectByExample(StaffDistributionExample example);

    int updateByExampleSelective(@Param("record") StaffDistribution record, @Param("example") StaffDistributionExample example);

    int updateByExample(@Param("record") StaffDistribution record, @Param("example") StaffDistributionExample example);
    
    FjpsHomePage  selectHomePageNum (Map<String,Object> map);
    
    StaffDistribution  findByOrderId(Integer orderId);
}