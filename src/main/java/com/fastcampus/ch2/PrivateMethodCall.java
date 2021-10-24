package com.fastcampus.ch2;

import java.lang.reflect.Method;

public class PrivateMethodCall {
	public static void Main(String[] args) throws Exception {
//		Hello hello = new Hello();
//		hello.main();
		
		//Reflection API 사용 - 클래스 정보를 얻고 다룰 수 있는 기능 제공
		//java.lang.reflect패키지를 제공
		//Hello클래스의 Class객체(클래스의 정보를 담고있는 객체를 얻어옴)
		//클래스의 정보를 못가져오는 경우가 있을 수 있어서 예외처리가 필요함
		
		Class helloClass = Class.forName("com.fastcampus.ch2.Hello");
		
		//newInstance()의 반환타입이 Object타입이라 형변환 필요
	
		Hello hello = (Hello)helloClass.newInstance(); //Class 객체가 가진 정보로 객체 생성
		Method main = helloClass.getDeclaredMethod("main");
		main.setAccessible(true); //private인 main()을 호출가능하게 한다.
		
		main.invoke(hello); //hello.main()과 같음. 즉, 인보크는 매개변수의 객체를 찾아가 자신의이름으로 선언된 변수를 실행시킴
	}

}
