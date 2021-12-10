package com.fastcampus.ch2;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class YoilTellerMVC6 {
	
	@ExceptionHandler(Exception.class)
	public String catcher(Exception e, BindingResult result) {
		FieldError error = result.getFieldError();
		System.out.println("filed에러 = "+error.getField());
		System.out.println("디폴트 메시지 = "+error.getDefaultMessage());
		System.out.println("코드에러 = "+error.getCode());
		e.printStackTrace();
		
		return "yoilError";
	}
	
	@RequestMapping("/getYoilMVC6")
//	public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
	public String main( MyDate date, BindingResult result)  {
		//BindingResult에서 에러발생시 컨트롤러 까지 데이터 전달이 안되기때문에 메서드 호출이 안될 것 (따라서 예외에서 찍어보기로!)
		System.out.println("result값은 ? == "+result);
		System.out.println(date);
		if(!isValid(date)) {
			return "yoilError";
		}
		return "yoil"; 
	}

	private boolean isValid(MyDate date) {
		return true;
	}

	private @ModelAttribute("yoil") char getYoil(MyDate date) {
		return getYoil(date.getYear(), date.getMonth(), date.getDate());
	}
	private char getYoil(int year, int month, int date) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month, date);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); 
		return " 일월화수목금토".charAt(dayOfWeek);
	}
}
