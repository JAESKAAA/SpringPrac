package com.fastcampus.ch2;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

// 데이터 처리 후 출력화면으로 결과를 던지는 역할을 하는 컨트롤러 내부적으로 구현
class ModelController{
	public String main(HashMap map) {
		map.put("id", "asdf");
		map.put("pwd", "1111");
		
		return "txtView2";
	}
}
public class MethodCall {
	public static void main(String[] args) throws Exception{
		
		// 1. 자료를 담을 맵(model)선언
		HashMap map = new HashMap();
		System.out.println("before: "+map);
		
		ModelController mc = new ModelController();
		String viewName = mc.main(map);
		
		System.out.println("after : " + map);
		
		render(map, viewName);
		
	}

	 static void render(HashMap map, String viewName) throws IOException {
		 String result ="";
		 // 1. 뷰의 내용을 한줄씩 읽어서 하나의 문자열을 만든다.
		 Scanner sc = new Scanner(new File(viewName+".txt"));
		 
		 while(sc.hasNextLine()){
			 result += sc.nextLine()+System.lineSeparator();
		 }
		// 2. map에 담긴 key를 하나씩 읽어서 template의 ${key}를 value로 바꿈
			 Iterator it = map.keySet().iterator();
			 
			 while(it.hasNext()) {
				 String key = (String)it.next();
				 
				 // 3. replace()로 key를 value로 치환함
				 result = result.replace("${"+key+"}", (String)map.get(key));
			 }
		 System.out.println(result);
	}
	
}