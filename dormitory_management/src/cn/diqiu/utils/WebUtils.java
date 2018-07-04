package cn.diqiu.utils;

import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

public class WebUtils {
	
	/*public static <T> T request2Bean(HttpServletRequest request,Class<T> beanClass){
		
		try {
			T bean = beanClass.newInstance();
			Enumeration e =request.getParameterNames();
			while(e.hasMoreElements()){
				String name = (String) e.nextElement();
				String value = request.getParameter(name);
				BeanUtils.setProperty(bean, name, value);
			}
			return bean;
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (InvocationTargetException e1) {
			throw new RuntimeException(e1);
		}
		
	}*/
	public static <T> T request2Bean(HttpServletRequest request,Class<T> beanClass){
		try{
		//1.创建要封装数据的bean
		T bean = beanClass.newInstance();
		
		//2.把request中的数据弄到bean中
		Enumeration e = request.getParameterNames();
		while(e.hasMoreElements()){
			String name = (String) e.nextElement(); 
			String value = request.getParameter(name);
			BeanUtils.setProperty(bean, name, value);
		}
		return bean;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		
	}
	 
	public static void copyBean(Object src, Object dest){
		ConvertUtils.register(new Converter() {
			public <T> T convert(Class<T> arg0, Object value) {
				if(value==null){
					return null;
				}
				String str = (String) value;
				if(str.trim().equals("")){
					return null;
				}
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				try{
					return (T) df.parse(str);
				}catch(Exception e){
					throw new RuntimeException(e);
				}
			}
		},Date.class);
		
		
		try {
			BeanUtils.copyProperties(dest, src);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static String generateID(){
		return UUID.randomUUID().toString();
	}
	
}
