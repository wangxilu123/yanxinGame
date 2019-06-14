package com.yanxin.dao;

import com.yanxin.domain.Receipt;
import com.yanxin.domain.ReceiptExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReceiptMapper {
    long countByExample(ReceiptExample example);

    int deleteByExample(ReceiptExample example);

    int insert(Receipt record);

    int insertSelective(Receipt record);

    List<Receipt> selectByExample(ReceiptExample example);

    int updateByExampleSelective(@Param("record") Receipt record, @Param("example") ReceiptExample example);

    int updateByExample(@Param("record") Receipt record, @Param("example") ReceiptExample example);
}