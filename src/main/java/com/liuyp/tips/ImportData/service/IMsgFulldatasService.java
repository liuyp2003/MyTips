package com.liuyp.tips.ImportData.service;

import com.liuyp.tips.ImportData.pojo.MsgFulldatas;

import java.util.List;

public interface IMsgFulldatasService {
    /**
     * 全量列表
     * @return 2016年全量集合
     */
    public List<MsgFulldatas> selectMsgFulldatasList();
    public boolean insertBatch(String filepath, String tablename, String msgdate) throws Exception ;
}
