package com.fastcampus.ch2;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.StringJoiner;

public class MethodInfo  {

	public static void main(String[] args) throws Exception {
		
		// 1. YoilTeller의 객체를 가져와서 생성
		Class clazz = Class.forName("com.fastcampus.ch2.YoilTellerMVC");
		Object obj = clazz.newInstance();
		
		// 2. 모든 메서드의 정보를 가져와서 배열에 저장
		Method[] methodArr = clazz.getDeclaredMethods();
		
		for(Method m : methodArr ) {
			String name = m.getName(); // 메서드의 이름 (요일 텔러에는 메인 메서드만 있어서 main 반환)
			Parameter[] paramArr = m.getParameters(); //메서드의 매개변수 목록 (request, response 반환)
			Class returnType = m.getReturnType(); // 반환 타입 (메인 메서드의 반환타입은 보이드임)
			
			//StringJoiner(구분자, 접두사, 접미사)
			StringJoiner paramList = new StringJoiner(", ","(",")");
		
			for(Parameter param : paramArr) {
				String paramName = param.getName();
				Class paramType = param.getType();
				
				paramList.add(paramType.getName() + " " + paramName);
			}
			//컴파일 된 상태에서는 매개변수의 이름은 중요하지 않아 arg0, arg1 등으로 반환됨 
			//매개변수 이름을 따로 저장하려면 컴파일 옵션에 -parameters를 줘야함
			System.out.printf("%s %s%s%n", returnType.getName(), name, paramList);
		}
	}
	
}
