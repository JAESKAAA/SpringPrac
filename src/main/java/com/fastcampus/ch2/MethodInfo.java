package com.fastcampus.ch2;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.StringJoiner;

public class MethodInfo  {

	public static void main(String[] args) throws Exception {
		
		// 1. YoilTeller�� ��ü�� �����ͼ� ����
		Class clazz = Class.forName("com.fastcampus.ch2.YoilTellerMVC");
		Object obj = clazz.newInstance();
		
		// 2. ��� �޼����� ������ �����ͼ� �迭�� ����
		Method[] methodArr = clazz.getDeclaredMethods();
		
		for(Method m : methodArr ) {
			String name = m.getName(); // �޼����� �̸� (���� �ڷ����� ���� �޼��常 �־ main ��ȯ)
			Parameter[] paramArr = m.getParameters(); //�޼����� �Ű����� ��� (request, response ��ȯ)
			Class returnType = m.getReturnType(); // ��ȯ Ÿ�� (���� �޼����� ��ȯŸ���� ���̵���)
			
			//StringJoiner(������, ���λ�, ���̻�)
			StringJoiner paramList = new StringJoiner(", ","(",")");
		
			for(Parameter param : paramArr) {
				String paramName = param.getName();
				Class paramType = param.getType();
				
				paramList.add(paramType.getName() + " " + paramName);
			}
			//������ �� ���¿����� �Ű������� �̸��� �߿����� �ʾ� arg0, arg1 ������ ��ȯ�� 
			//�Ű����� �̸��� ���� �����Ϸ��� ������ �ɼǿ� -parameters�� �����
			System.out.printf("%s %s%s%n", returnType.getName(), name, paramList);
		}
	}
	
}
