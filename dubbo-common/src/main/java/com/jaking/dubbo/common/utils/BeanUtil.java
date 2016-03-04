package com.jaking.dubbo.common.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

 
public class BeanUtil {

	private  static String[] basicType ={"int","boolean","char","byte","long","short","float","double"};
	
	@SuppressWarnings("unchecked")
	public static Boolean IsEmptyObject(Object o,Class<?> annotationclazz) throws Exception{
		boolean emptyFlag=true;
		Class<? extends Object> clazz=o.getClass();
		Field[] fields= clazz.getDeclaredFields();
		for (Field field : fields) {
			 if(annotationclazz!=null && (!field.isAnnotationPresent( (Class<? extends Annotation>) annotationclazz))){
				  continue;
			 }else{
				 if(!isNull(field, o)){
					 emptyFlag=false;
					 break;
				 }
			 }
		}
		return emptyFlag;
	}
	
	public static Boolean IsEmptyObject(Object object) throws Exception{
		return IsEmptyObject(object, null);
	}
	
	private static Boolean isNull(Field field,Object object) throws Exception{
		if(Arrays.asList(basicType).indexOf(field.getType().getName())!=-1){
			return true;
		}else{
			Method m=object.getClass().getMethod("get" +getMethodName(field.getName()));
			String s= (String) m.invoke(object);
			if(isBlank(s)){
				return true;
			}else{
				return false;
			}
		}
	}
	
	private static Boolean isBlank(String s){
		return s==null ||s=="";
	}
	
	private static String getMethodName(String fieldName){
		byte[] items = fieldName.getBytes();
		items[0] = (byte) ((char) items[0] - 'a' + 'A');
		return new String(items);
	}
}
