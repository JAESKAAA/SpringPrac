package com.fastcampus.ch2;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class YoilTellerMVC5 {
	
	@ExceptionHandler(Exception.class)
	public String catcher(Exception e) {
		e.printStackTrace();
		
		return "yoilError";
	}
	
	@RequestMapping("/getYoilMVC5")
//	public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
	public String main( @ModelAttribute("myDate") MyDate date, Model model)  {
		System.out.println(date);
		if(!isValid(date)) {
			return "yoilError";
		}
		
		//ModelAttribute를 해당 메서드에 선언해둬서 자동 호출되므로 필요없음
//		char yoil = getYoil(date);
		
//		model.addAttribute("myDate", date);
//		model.addAttribute("yoil", yoil);
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
