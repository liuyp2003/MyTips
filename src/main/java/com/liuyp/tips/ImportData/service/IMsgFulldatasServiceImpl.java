package com.liuyp.tips.ImportData.service;

import com.liuyp.tips.ImportData.mapping.MsgFulldatasMapper;
import com.liuyp.tips.ImportData.pojo.MsgFulldatas;
import com.liuyp.tips.utils.FileOperateUtils;
import com.liuyp.tips.utils.ListUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;

@Service
public class IMsgFulldatasServiceImpl implements IMsgFulldatasService {
    private Logger logger = LoggerFactory.getLogger(IMsgFulldatasServiceImpl.class);
    @Autowired
    private MsgFulldatasMapper msgFulldatasMapper;

    @Override
    public List<MsgFulldatas> selectMsgFulldatasList() {
        return msgFulldatasMapper.selectMsgFulldatasList();
    }

    @Override
    public boolean insertBatch(String filePath,String tablename,String msgdate) throws Exception {
        int m_record = 9999;

        ArrayList<MsgFulldatas> list;
        BufferedReader br = new BufferedReader(new FileReader(filePath), 8192);
        LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(filePath));
        lineNumberReader.skip(Long.MAX_VALUE);
        int lineNumber = lineNumberReader.getLineNumber()+1;
        int runSize = lineNumber/m_record + (lineNumber%m_record > 0 ? 1 : 0);

        int corePoolSize = 8;
        ThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(corePoolSize);
        CountDownLatch countDownLatch = new CountDownLatch(runSize);
        Semaphore semaphore = new Semaphore(16);

        String line;
        int count = 0;
        synchronized (br) {
            try {
                list = new ArrayList<MsgFulldatas>();
                while ((line = br.readLine()) != null) {
                    String[] args = line.replace("\\N","").split("\\|",-1);
                    count++;
                    if(args.length >= 37){
                        list.add(new MsgFulldatas(args));
                        if (count >= m_record) {
                            count = 0;
                            semaphore.acquire();
                            executor.execute(new insertFullData(semaphore, countDownLatch, list, tablename));
                            list = new ArrayList<>(m_record);
                        }
                    }else{
                        logger.warn("全量数据上传-该条记录异常或长度低于无法被上传：[" + line + "]");
                    }
                }

                if (list != null && list.size() > 0) {
                    executor.submit(new insertFullData(semaphore, countDownLatch, list, tablename));
                }

                countDownLatch.await();
                String content = "请注意，["+msgdate+"]全量库数据上传成功!";
                String receiveuser = "liuyingping;zhengbangtong;chenjun;admin";
                return true;
            } catch (Exception e) {
                String content = "请注意，["+msgdate+"]全量库数据上传失败!";
                String receiveuser = "liuyingping;zhengbangtong;chenjun;admin";
                logger.error("全量数据上传失败["+filePath+"]-错误：");
                logger.warn(e.getMessage());
                return false;
            } finally {
                executor.shutdown();
            }
        }
    }

    class insertFullData implements Runnable{
        private Semaphore semaphore;
        private CountDownLatch countDownLatch;
        private List<MsgFulldatas> list;
        private String tablename;

        public insertFullData(Semaphore semaphore, CountDownLatch countDownLatch, List<MsgFulldatas> list,String tablename){
            this.semaphore = semaphore;
            this.countDownLatch = countDownLatch;
            this.list = list;
            this.tablename = tablename;
        }
        @Override
        public void run() {
            try {
                insertRecursion(list,tablename);
                list.clear();
            }catch (Exception ex){
                logger.warn("全量数据上传-本批次上传失败");
            }finally {
                countDownLatch.countDown();
                semaphore.release();
            }
        }

        public Boolean insertRecursion(List<MsgFulldatas> insertList,String tablename){
            Boolean b = insert(insertList,tablename);
            if(b) {
                return b;
            } else if(insertList.size() == 1){
//                String pathname = cp.getErrorFileDir()+File.separator+"fulldata.dataToMysql."+insertList.get(0).getMsgdate();
//                FileOperateUtils.WriteStringToFile(pathname, insertList.get(0).toString());
                System.out.println("导入错误数据："+insertList.get(0).toString());
                return false;
            } else {
                List<List<MsgFulldatas>> reSubmitList = ListUtils.averageAssign(insertList,2);
                for(List<MsgFulldatas> subList : reSubmitList){
                    insertRecursion(subList,tablename);
                }
                return false;
            }
        }

        public boolean insert(List<MsgFulldatas> insertList,String tablename){
            try{
                msgFulldatasMapper.insertBatch(insertList, tablename);
                return true;
            }catch (Exception e){
                e.printStackTrace();
                return false;
            }

        }

    }
}
