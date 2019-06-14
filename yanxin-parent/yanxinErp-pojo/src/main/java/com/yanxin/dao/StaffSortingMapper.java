package com.yanxin.dao;

import com.yanxin.domain.StaffSorting;
import com.yanxin.domain.StaffSortingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StaffSortingMapper {
    long countByExample(StaffSortingExample example);

    int deleteByExample(StaffSortingExample example);

    int insert(StaffSorting record);

    int insertSelective(StaffSorting record);

    List<StaffSorting> selectByExample(StaffSortingExample example);

    int updateByExampleSelective(@Param("record") StaffSorting record, @Param("example") StaffSortingExample example);

    int updateByExample(@Param("record") StaffSorting record, @Param("example") StaffSortingExample example);
}