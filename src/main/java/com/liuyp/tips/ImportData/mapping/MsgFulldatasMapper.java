package com.liuyp.tips.ImportData.mapping;

import com.liuyp.tips.ImportData.pojo.MsgFulldatas;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 2016年全量 数据层
 *
 * @author feinno
 * @date 2018-08-21
 */
public interface MsgFulldatasMapper
{

    /**
     * 查全量消息
     * @return 2016年全量集合
     */
    public List<MsgFulldatas> selectMsgFulldatasList();
    public void insertBatch(@Param("msgs") List<MsgFulldatas> msgs, @Param("tablename") String tablename);

}
