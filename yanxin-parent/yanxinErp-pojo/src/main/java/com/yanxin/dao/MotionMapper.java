package com.yanxin.dao;

import com.yanxin.domain.Motion;
import com.yanxin.domain.MotionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MotionMapper {
    long countByExample(MotionExample example);

    int deleteByExample(MotionExample example);

    int insert(Motion record);

    int insertSelective(Motion record);

    List<Motion> selectByExample(MotionExample example);

    int updateByExampleSelective(@Param("record") Motion record, @Param("example") MotionExample example);

    int updateByExample(@Param("record") Motion record, @Param("example") MotionExample example);
}