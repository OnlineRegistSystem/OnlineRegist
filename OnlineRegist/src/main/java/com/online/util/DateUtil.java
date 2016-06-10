package com.online.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**用于格式化输出当前时间，时间戳
 * @author chuankun
 *@2016年5月15日 下午3:00:55
 * email:yichuankun@qq.com
 */
public class DateUtil {

	/**
	 * 获取标准化时间
	 * @return
	 */
	public static String getDate(){
		Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		return format.format(now);
	}
	/**
	 * 根据时间返回星期几
	 * @param data yyyy-mm-dd
	 * @param spiter 分割符
	 * @return
	 */
	public static String getWeek(String data,String regex){
		String [] str1 = data.split(regex);
		int year = Integer.valueOf(str1[0]);
		int month = Integer.valueOf(str1[1]);
		int day = Integer.valueOf(str1[2]);
	     
	     Calendar calendar = Calendar.getInstance();//获得一个日历
	     calendar.set(year, month-1, day);//设置当前时间,月份是从0月开始计算
	     int number = calendar.get(Calendar.DAY_OF_WEEK);//星期表示1-7，是从星期日开始，   
	     String [] str = {"","星期日","星期一","星期二","星期三","星期四","星期五","星期六",};
		return str[number];
	}
}
