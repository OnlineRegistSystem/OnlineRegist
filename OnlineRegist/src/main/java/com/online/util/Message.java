package com.online.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用于格式化输出json 数据
 * @author chuankun   email:yichuankun@qq.com
 * 2016年4月18日 上午11:03:34
 *	TODO
 */
public class Message {

	/**
	 * 格式化返回数据
	 * @return
	 */
	public static Object getMessage(int code,String error,Object data){
		Map<String , Object> map = new HashMap<String, Object>();
		map.put("code", code);
		map.put("error", error);
		map.put("data", data);
		return map;
	}
	/**返回成功的结果
	 * @return
	 */
	public static Object getMessage(){
		Map<String , Object> map = new HashMap<String, Object>();
		map.put("code", 1);
		map.put("error", "");
		map.put("date", "");
		return map;
	}
	/**成功，并有返回值
	 * @param date
	 * @return
	 */
	public static Object getMessage(Object date){
		Map<String , Object> map = new HashMap<String, Object>();
		int code=1;
		if(date==null){
			code=2;
		}else if(date instanceof List ){ //如果对象为LIst对象，为空的判断
			if(((List) date).isEmpty()){
				code=2;
			}
		}
		map.put("code", code);
		map.put("error", "");
		map.put("date", date);
		return map;
	}
	public static Object getMessageParmNull(){
		Map<String , Object> map = new HashMap<String, Object>();
		map.put("code", 0);
		map.put("error", "参数为空！");
		map.put("date", "");
		return map;
	}
	
}
