package com.liuyp.tips.utils;

import java.io.*;
import java.util.Properties;

/**
 * User: liuyingping
 * Date: 16-6-9
 * Time: 下午12:43
 */
public class PropertiesUtil {

    private static Properties dataSourceProp ;
    public synchronized static Properties getDataSourceProp(){
    	dataSourceProp = getProp("datasource.properties");
        return dataSourceProp;
    }

    public static Properties fileProp;
    public synchronized static Properties getfileProp(){
    	fileProp = getProp("application.properties");
        return fileProp;
    }
    
    public static Properties redisProp;
    public synchronized static Properties getRedisProp(){
    	redisProp = getProp("redis.properties");
        return redisProp;
    }
    
    /**
     *@Description:初始化获取属性文件信息
     *@author liuyingping-2016-9-7 
     *@param fileName
     *@return
     */
    @SuppressWarnings("unused")
	public static Properties getProp(String fileName){
    	Properties prop = null;
		InputStream in = null;
		String filePath = "";
    	try {
             if(prop == null) {   
            	 prop = new Properties();
             }
        	 filePath = System.getProperty("user.dir") + File.separator+ fileName;
        	 in = new BufferedInputStream(new FileInputStream(filePath));
        	 prop.load(new InputStreamReader(in, "UTF-8"));
        	 in.close();
             
         } catch (IOException e) {
             if(prop == null) {   
            	 prop = new Properties();
             }
           	 try {
					prop.load(PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
             
         }
         return prop;
    }
}
