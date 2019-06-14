package com.yanxin.dao;

import com.yanxin.domain.PushMessage;
import com.yanxin.domain.PushMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PushMessageMapper {
    long countByExample(PushMessageExample example);

    int deleteByExample(PushMessageExample example);

    int insert(PushMessage record);

    int insertSelective(PushMessage record);

    List<PushMessage> selectByExample(PushMessageExample example);

    int updateByExampleSelective(@Param("record") PushMessage record, @Param("example") PushMessageExample example);

    int updateByExample(@Param("record") PushMessage record, @Param("example") PushMessageExample example);
}