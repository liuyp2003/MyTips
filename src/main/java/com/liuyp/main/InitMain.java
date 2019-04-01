package com.liuyp.main;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class InitMain {
	private static Log log = LogFactory.getLog(InitMain.class);
	public static InitMain getInstance(){
		return new InitMain();
	}
	/**   
	 *@Description:
	 *@author liuyingping-2016-10-11 
	 *@param args
	 */
	public static void main(String[] args) {
		System.out.println("java -jar loadToHadoop-0.0.1.jar help 查看帮助");
		if(args.length == 2){
			String pattern="^(?:(?!0000)[0-9]{4}(?:(?:0[1-9]|1[0-2])(?:0[1-9]|1[0-9]|2[0-8])|(?:0[13-9]|1[0-2])(?:29|30)|(?:0[13578]|1[02])31)|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)0229)$";
			if(args[1].matches(pattern)){
				if(StringUtils.equalsIgnoreCase("creattable",args[0])){
					BehaviorHiveDaoImpl.getInstance().createBehaviourTableByDate(args[1]);
				}
			}else{
				log.warn("参数【"+args[1]+"】必须为日期年月日");
			}
		}
		
		if(args.length > 0){
			if(StringUtils.equalsIgnoreCase("help",args[0])){
				printHelpMsg();
			}
		}else{
			//定时任务
			InitMain.getInstance().scheduleTask();
		}
	}
	
	/**
	 *@Description:定时任务
	 *@author liuyingping-2016-10-19
	 */
	public void scheduleTask(){
	   	Timer timer =new Timer();
	   	
	   	//每天凌晨10分创建后一天的hive表
	   	timer.scheduleAtFixedRate(new TimerTask() {
	         @Override
	         public void run() {
	        	 String datetype = getStringDate(1,"yyyyMMdd");
	        	 BehaviorHiveDaoImpl.getInstance().createBehaviourTableByDate(datetype);
	         }
	     },getSpecialDate(4,10,0),24*3600*1000);
	   	
	   	//每隔一个小时导入一次数据
	     timer.scheduleAtFixedRate(new TimerTask() {
	         @Override
	         public void run() {
	        	 String datetype = getStringDate(0,"yyyyMMdd");
	        	 try{
	        		 BehaviorHiveDaoImpl.getInstance().behaviorCollection(datetype);
	        	 }catch(Exception e){
		        	 try {
		        		 log.error(e);
		        		 log.error("数据导入至Hadoop中时，表("+datetype+")不存在，正在重新创建。");
		        		 HiveDataSourceUtil.getHiveDataSource(true);
		        		 
		        		 BehaviorHiveDaoImpl.getInstance().createBehaviourTableByDate(datetype);
		        		 BehaviorHiveDaoImpl.getInstance().behaviorCollection(datetype);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
	        	 }
	         }
	     },getStartTime(),60*1000);
	}
	/**
	 *@Description:根据调整的天数及格式类型输出字符串日期
	 *@author liuyingping-2016-10-11 
	 *@param day 调整的天数（负数表示更早的日期）
	 *@param format
	 *@return
	 */
	public static String getStringDate(int day, String format){
		
		//获取当前日期
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Calendar calday = Calendar.getInstance();
		calday.setTime(new Date());
		calday.add(Calendar.DAY_OF_MONTH, day);
		return sdf.format(calday.getTime());
	}

	public static Date getSpecialDate(int HH, int mm, int ss){
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);//每天
        //定制每天的00:10:00执行
        calendar.set(year, month, day, HH, mm, ss);
        Date date = calendar.getTime();
        return date;
	}
	
    /**
     * 获取开始任务的时间
     * 下一分钟的30秒开始
     */
    private static Date getStartTime(){
        Date current = new Date();
        return DateUtils.addSeconds(current, 5);
    }
    
    /**
     *@Description:帮助提示
     *@author liuyingping-2016-9-18
     */
	private static void printHelpMsg(){
		System.out.println("参数设置详情：");
		System.out.println("\t参数一[功能类型-creattable：创建Hive表|loaddata:导入数据]");
		System.out.println("\t参数二[日期-年月日：例如20161019]");
	}
}
