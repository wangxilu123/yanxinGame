package com.yanxin.dao;

import com.yanxin.domain.HaixinGood;
import com.yanxin.domain.HaixinGoodExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HaixinGoodMapper {
    long countByExample(HaixinGoodExample example);

    int deleteByExample(HaixinGoodExample example);

    int insert(HaixinGood record);

    int insertSelective(HaixinGood record);

    List<HaixinGood> selectByExample(HaixinGoodExample example);

    int updateByExampleSelective(@Param("record") HaixinGood record, @Param("example") HaixinGoodExample example);

    int updateByExample(@Param("record") HaixinGood record, @Param("example") HaixinGoodExample example);
}