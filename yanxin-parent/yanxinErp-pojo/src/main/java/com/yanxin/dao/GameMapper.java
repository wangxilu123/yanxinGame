package com.yanxin.dao;

import com.yanxin.domain.Game;
import com.yanxin.domain.GameExample;
import com.yanxin.domain.ProductTransfer;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface GameMapper {
	
	public List<Game> findListAllWithCategory(Map<String,Object> map);
	
    int countByExample(GameExample example);

    int deleteByExample(GameExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Game record);

    int insertSelective(Game record);

    List<Game> selectByExample(GameExample example);

    Game selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Game record, @Param("example") GameExample example);

    int updateByExample(@Param("record") Game record, @Param("example") GameExample example);

    int updateByPrimaryKeySelective(Game record);

    int updateByPrimaryKey(Game record);
}