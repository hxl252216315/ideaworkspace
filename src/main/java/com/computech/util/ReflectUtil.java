package com.computech.util;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.computech.dto.AccoutAntCondition;

public class ReflectUtil {

	public static <T> T  concatPercent(T t) throws Exception {
		
		@SuppressWarnings("unchecked")
		Class<AccoutAntCondition> clazz = (Class<AccoutAntCondition>) t.getClass();
		Method[] methods = clazz.getMethods();
		Map<String,String> map = new HashMap<String,String>();
		
		for (Method method : methods) {
			String mName = method.getName();
			if(mName.startsWith("get") && mName != "getClass") {
				String filedName = mName.replaceFirst("get", "");
				Object result = method.invoke(t);
				if( result != null && !"".equals(result)) {
					map.put(filedName, (String)result);
				}
			}
		}
		
		Set<Entry<String, String>> set = map.entrySet();
		for (Entry<String, String> entry : set) {
			Method method = clazz.getMethod("set"+entry.getKey(), String.class);
			method.invoke(t,"%"+entry.getValue()+"%");
		}
		return t;
	}; 
}
