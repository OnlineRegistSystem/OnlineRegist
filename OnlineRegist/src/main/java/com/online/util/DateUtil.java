package com.online.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**用于格式化输出当前时间，时间戳
 * @author chuankun
 *@2016年5月15日 下午3:00:55
 * email:yichuankun@qq.com
 */
public class DateUtil {

	public static String getDate(){
		Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		return format.format(now);
	}
}
