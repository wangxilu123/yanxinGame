package com.yanxin.dao;

import com.yanxin.domain.Postage;
import com.yanxin.domain.PostageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PostageMapper {
    long countByExample(PostageExample example);

    int deleteByExample(PostageExample example);

    int insert(Postage record);

    int insertSelective(Postage record);

    List<Postage> selectByExample(PostageExample example);

    int updateByExampleSelective(@Param("record") Postage record, @Param("example") PostageExample example);

    int updateByExample(@Param("record") Postage record, @Param("example") PostageExample example);
}