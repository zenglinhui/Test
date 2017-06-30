package com.noah.type.test;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;

public class ParameterizedTypeTest {

	public static void main(String[] args) {

		testParameterizedType();
		
	}
	
	private static void testParameterizedType(){
		try {
			Field[] fields = ParameterizedTypeVo.class.getDeclaredFields();
			for(Field f : fields){
				System.out.println(f.getName() + " type: " + (f.getGenericType() instanceof ParameterizedType));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
