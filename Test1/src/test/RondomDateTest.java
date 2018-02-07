package test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RondomDateTest {
	public static void main(String[] args) {  
        Date date = randomDate("2009-08-31 23:00:00","2009-09-01 00:00:00");  
        System.out.println(new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date));  
    }  
      
      
    /** 
     * 获取随机日期 
     * @param beginDate 起始日期，格式为：yyyy-MM-dd 
     * @param endDate 结束日期，格式为：yyyy-MM-dd 
     * @return 
     */  
    private static Date randomDate(String beginDate,String endDate){  
        try {  
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
            Date start = format.parse(beginDate);  
            Date end = format.parse(endDate);  
              
            if(start.getTime() >= end.getTime()){  
                return null;  
            }  
              
            long date = random(start.getTime(),end.getTime());  
              
            return new Date(date);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return null;  
    }  
      
    private static long random(long begin,long end){  
        long rtn = begin + (long)(Math.random() * (end - begin));  
        if(rtn == begin || rtn == end){  
            return random(begin,end);  
        }  
        return rtn;  
    }  
}
