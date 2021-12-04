package com.fastcampus.ch2;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RequestParamTest {
	
	@ExceptionHandler(Exception.class)
	public String catcher(Exception e) {
		return "yoilError";
	}

	@RequestMapping("/requestParam")
	public String main(@RequestParam int date, HttpServletRequest request) {
		String year = request.getParameter("year");
		System.out.println(date);
		System.out.printf("[%s]year=[%s]%n", new Date(), year);
		return "yoil";
	}
	
}
