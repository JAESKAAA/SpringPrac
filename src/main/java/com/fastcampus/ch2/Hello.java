package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//1. ���� ȣ�� ������ ���α׷����� ���
@Controller
public class Hello {
	int iv = 10;
	static int cv = 20;
	
	//2. URL�� �޼��带 ����
	@RequestMapping("/hello")
	private static void main() { //�ν��Ͻ� 
		
		System.out.println("hello - static");
		System.out.println(cv);
	}
	
	public static void main2() {
		System.out.println(cv);
	}
}
