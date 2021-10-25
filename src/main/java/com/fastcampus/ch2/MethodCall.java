package com.fastcampus.ch2;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

// ������ ó�� �� ���ȭ������ ����� ������ ������ �ϴ� ��Ʈ�ѷ� ���������� ����
class ModelController{
	public String main(HashMap map) {
		map.put("id", "asdf");
		map.put("pwd", "1111");
		
		return "txtView2";
	}
}
public class MethodCall {
	public static void main(String[] args) throws Exception{
		
		// 1. �ڷḦ ���� ��(model)����
		HashMap map = new HashMap();
		System.out.println("before: "+map);
		
		ModelController mc = new ModelController();
		String viewName = mc.main(map);
		
		System.out.println("after : " + map);
		
		render(map, viewName);
		
	}

	 static void render(HashMap map, String viewName) throws IOException {
		 String result ="";
		 // 1. ���� ������ ���پ� �о �ϳ��� ���ڿ��� �����.
		 Scanner sc = new Scanner(new File(viewName+".txt"));
		 
		 while(sc.hasNextLine()){
			 result += sc.nextLine()+System.lineSeparator();
		 }
		// 2. map�� ��� key�� �ϳ��� �о template�� ${key}�� value�� �ٲ�
			 Iterator it = map.keySet().iterator();
			 
			 while(it.hasNext()) {
				 String key = (String)it.next();
				 
				 // 3. replace()�� key�� value�� ġȯ��
				 result = result.replace("${"+key+"}", (String)map.get(key));
			 }
		 System.out.println(result);
	}
	
}