package com.fastcampus.ch2;

import java.lang.reflect.Method;

public class PrivateMethodCall {
	public static void Main(String[] args) throws Exception {
//		Hello hello = new Hello();
//		hello.main();
		
		//Reflection API ��� - Ŭ���� ������ ��� �ٷ� �� �ִ� ��� ����
		//java.lang.reflect��Ű���� ����
		//HelloŬ������ Class��ü(Ŭ������ ������ ����ִ� ��ü�� ����)
		//Ŭ������ ������ ���������� ��찡 ���� �� �־ ����ó���� �ʿ���
		
		Class helloClass = Class.forName("com.fastcampus.ch2.Hello");
		
		//newInstance()�� ��ȯŸ���� ObjectŸ���̶� ����ȯ �ʿ�
	
		Hello hello = (Hello)helloClass.newInstance(); //Class ��ü�� ���� ������ ��ü ����
		Method main = helloClass.getDeclaredMethod("main");
		main.setAccessible(true); //private�� main()�� ȣ�Ⱑ���ϰ� �Ѵ�.
		
		main.invoke(hello); //hello.main()�� ����. ��, �κ�ũ�� �Ű������� ��ü�� ã�ư� �ڽ����̸����� ����� ������ �����Ŵ
	}

}
