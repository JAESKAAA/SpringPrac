package com.fastcampus.ch2;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

public class MethodCall2 {
	public static void main(String[] args) throws Exception {
		
		// 1. 요일텔러 객체 생성
		Class clazz = Class.forName("com.fastcampus.ch2.YoilTellerMVC");
		Object obj = clazz.newInstance();
		
		// 2. main 메서드의 정보 가져오기
		Method main = clazz.getDeclaredMethod("main", int.class, int.class, int.class, Model.class);
		
		// 3. 모델 생성 (Model은 인터페이스라 BindingAwareModelMap 이라는 구현체 사용해서 인스턴스화 시킴)
		Model model = new BindingAwareModelMap();
		System.out.println("[before] model = "+model);
		
		// 4. main 메서드를 호출 (Reflection API 방식을 이용하려면 invoke 메서드 사용)
		//String viewName = obj.main(2021, 10, 1, model); 이 코드와 동일한 코드임
		//하기 invoke문을 해석해보면, obk객체의 main메소드를 실행할건데, 파라미터는 new Object {2021,10,1,model)을 사용한다는 의미
		String viewName = (String)main.invoke(obj, new Object[] {2021,10,1,model});
		System.out.println("viewName = "+ viewName);
		
		//Model의 내용을 출력
		System.out.println("[after] model = "+model);
		
		//텍스트 파일을 이용한 렌더링
		render(model, viewName);
		
	}

	 static void render(Model model, String viewName) throws IOException {
		 String result="";
		 
		 // 1. 뷰의 내용을 한줄씩 읽어서 하나의 문자열로 만듦
		 Scanner sc = new Scanner(new File("src/main/webapp/WEB-INF/views/"+viewName+".jsp"), "utf-8");
		 
		 while(sc.hasNextLine())
			 result += sc.nextLine()+System.lineSeparator();
		 
		 // 2. model을 map으로 변환
		 Map map = model.asMap();
		 
		 // 3. key를 하나씩 읽어서 template의 ${key}를 value로 바꿈
		 Iterator it = map.keySet().iterator();
		 
		 while(it.hasNext()) {
			 String key = (String)it.next();
			 
			 // 4. replace()로 key를 value로 치환함
			 result = result.replace("#{"+key+"}",""+ map.get(key));
		 }
		 
		 // 5. 렌더링 결과 출력
		 System.out.println(result);
		
	}
}