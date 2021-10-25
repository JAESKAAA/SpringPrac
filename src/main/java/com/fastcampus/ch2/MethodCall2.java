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
		
		// 1. �����ڷ� ��ü ����
		Class clazz = Class.forName("com.fastcampus.ch2.YoilTellerMVC");
		Object obj = clazz.newInstance();
		
		// 2. main �޼����� ���� ��������
		Method main = clazz.getDeclaredMethod("main", int.class, int.class, int.class, Model.class);
		
		// 3. �� ���� (Model�� �������̽��� BindingAwareModelMap �̶�� ����ü ����ؼ� �ν��Ͻ�ȭ ��Ŵ)
		Model model = new BindingAwareModelMap();
		System.out.println("[before] model = "+model);
		
		// 4. main �޼��带 ȣ�� (Reflection API ����� �̿��Ϸ��� invoke �޼��� ���)
		//String viewName = obj.main(2021, 10, 1, model); �� �ڵ�� ������ �ڵ���
		//�ϱ� invoke���� �ؼ��غ���, obk��ü�� main�޼ҵ带 �����Ұǵ�, �Ķ���ʹ� new Object {2021,10,1,model)�� ����Ѵٴ� �ǹ�
		String viewName = (String)main.invoke(obj, new Object[] {2021,10,1,model});
		System.out.println("viewName = "+ viewName);
		
		//Model�� ������ ���
		System.out.println("[after] model = "+model);
		
		//�ؽ�Ʈ ������ �̿��� ������
		render(model, viewName);
		
	}

	 static void render(Model model, String viewName) throws IOException {
		 String result="";
		 
		 // 1. ���� ������ ���پ� �о �ϳ��� ���ڿ��� ����
		 Scanner sc = new Scanner(new File("src/main/webapp/WEB-INF/views/"+viewName+".jsp"), "utf-8");
		 
		 while(sc.hasNextLine())
			 result += sc.nextLine()+System.lineSeparator();
		 
		 // 2. model�� map���� ��ȯ
		 Map map = model.asMap();
		 
		 // 3. key�� �ϳ��� �о template�� ${key}�� value�� �ٲ�
		 Iterator it = map.keySet().iterator();
		 
		 while(it.hasNext()) {
			 String key = (String)it.next();
			 
			 // 4. replace()�� key�� value�� ġȯ��
			 result = result.replace("#{"+key+"}",""+ map.get(key));
		 }
		 
		 // 5. ������ ��� ���
		 System.out.println(result);
		
	}
}